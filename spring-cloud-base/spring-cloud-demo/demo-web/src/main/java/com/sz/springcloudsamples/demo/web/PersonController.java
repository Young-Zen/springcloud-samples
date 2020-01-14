package com.sz.springcloudsamples.demo.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sz.springcloudsamples.common.annotation.IgnoreTracing;
import com.sz.springcloudsamples.common.exception.BaseException;
import com.sz.springcloudsamples.common.mvc.controller.BaseController;
import com.sz.springcloudsamples.common.mvc.dto.ResponseResultDTO;
import com.sz.springcloudsamples.demo.entity.PersonEntity;
import com.sz.springcloudsamples.demo.service.PersonService;
import com.sz.springcloudsamples.demo.service.mapper.PersonMapper;
import com.sz.springcloudsamples.demo.vo.PersonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author Yanghj
 * @date 1/13/2020
 */
@RestController
@RequestMapping("/person")
@Api(tags = "Person 控制器")
public class PersonController extends BaseController {

    @Autowired
    PersonService personService;

    @GetMapping("/mybatisPlus")
    @ApiOperation("MybatisPlus 例子")
    public ResponseResultDTO mybatisPlus() {
        PersonVO personVO = new PersonVO();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        personVO.setName("mybatisPlus").setAge(1).setBirthday(LocalDate.parse("2020-01-01", dateTimeFormatter)).setAccount(new BigDecimal("5.2")).setDeleted(false);
        personService.save(PersonMapper.INSTANCE.toEntity(personVO));

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name", "mybatisPlus");
        wrapper.last("limit 1");
        wrapper.orderByDesc("pk_person_id");
        PersonEntity personEntity = personService.getOne(wrapper);
        return super.ok(PersonMapper.INSTANCE.toVO(personEntity));
    }

    @GetMapping("/mybatisPlus/list")
    @ApiOperation("MybatisPlus list 方法例子")
    public ResponseResultDTO list() {
        List<PersonEntity> personEntityList = personService.list();
        return ResponseResultDTO.ok(PersonMapper.INSTANCE.toVOList(personEntityList));
    }

    @GetMapping("/mybatisPlus/page")
    @ApiOperation("MybatisPlus 分页查询例子")
    public ResponseResultDTO page() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.orderByDesc("pk_person_id");
        IPage<PersonEntity> page = personService.page(new Page<>(0, 10), wrapper);
        return ResponseResultDTO.ok(PersonMapper.INSTANCE.toVOPage(page));
    }

    @PostMapping("/add")
    @ApiOperation("插入")
    public ResponseResultDTO add(@ApiParam(name = "PersonVO对象", value = "json格式", required = true) @Validated(PersonVO.Add.class) @RequestBody PersonVO personVO) {
        personService.save(PersonMapper.INSTANCE.toEntity(personVO));

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.last("limit 1");
        wrapper.orderByDesc("pk_person_id");
        PersonEntity personEntity = personService.getOne(wrapper);
        return ResponseResultDTO.ok(PersonMapper.INSTANCE.toVO(personEntity));
    }

    @PostMapping("/delete")
    @ApiOperation("删除")
    public ResponseResultDTO delete(@ApiParam(value = "正整数", required = true) @NotNull(message = "ID不能为空") @Min(value = 1, message = "ID最小为1") @RequestParam("id") Long id) {
        personService.removeById(id);
        return ResponseResultDTO.ok();
    }

    @GetMapping("/lombok/chain")
    @ApiOperation("Lombok 链式 set 方法例子")
    public PersonVO chain() {
        PersonVO personVO = new PersonVO();
        personVO.setName("lombok").setAge(2).setBirthday(LocalDate.of(2020, 1, 1)).setAccount(new BigDecimal("5.2")).setDeleted(false);
        PersonEntity personEntity = PersonMapper.INSTANCE.toEntity(personVO);
        return PersonMapper.INSTANCE.toVO(personEntity);
    }

    @GetMapping("/exception")
    @ApiOperation("抛出 BaseException 例子")
    public ResponseResultDTO exception() {
        throw new BaseException();
    }

    @GetMapping("/ignoreTracing")
    @IgnoreTracing
    @ApiOperation("@IgnoreTracing 例子")
    public ResponseResultDTO ignoreTracing() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name", "mybatisPlus");
        wrapper.last("limit 1");
        PersonEntity personEntity = personService.getOne(wrapper);
        return ResponseResultDTO.ok("look console", personEntity);
    }

    @GetMapping("/async")
    @ApiOperation("异步方法例子")
    public ResponseResultDTO async() {
        personService.async();
        return ResponseResultDTO.ok("look console");
    }

    @GetMapping("/security")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @ApiOperation("Security 方法上 @PreAuthorize 例子")
    public ResponseResultDTO security() {
        ResponseResultDTO responseResultDTO = null;
        responseResultDTO.getCode();
        return ResponseResultDTO.fail();
    }
}
