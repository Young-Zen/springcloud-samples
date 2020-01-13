package com.sz.springcloudsamples.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sz.springcloudsamples.common.annotation.IgnoreTracing;
import com.sz.springcloudsamples.common.exception.BaseException;
import com.sz.springcloudsamples.common.mvc.controller.BaseController;
import com.sz.springcloudsamples.common.mvc.dto.ResponseResultDTO;
import com.sz.springcloudsamples.demo.entity.PersonEntity;
import com.sz.springcloudsamples.demo.mapper.PersonMapper;
import com.sz.springcloudsamples.demo.service.PersonService;
import com.sz.springcloudsamples.demo.vo.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * @author Yanghj
 * @date 1/10/2020
 */
@RestController
@RequestMapping("/person")
public class PersonController extends BaseController {

    @Autowired
    PersonService personService;

    @GetMapping("/mybatisPlus")
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
    public ResponseResultDTO list() {
        List<PersonEntity> demoPOList = personService.list();
        return ResponseResultDTO.ok(PersonMapper.INSTANCE.toVOList(demoPOList));
    }

    @GetMapping("/mybatisPlus/page")
    public ResponseResultDTO page() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.orderByDesc("pk_person_id");
        IPage<PersonEntity> page = personService.page(new Page<>(0, 10), wrapper);
        return ResponseResultDTO.ok(PersonMapper.INSTANCE.toVOPage(page));
    }

    @GetMapping("/lombok/chain")
    public PersonVO chain() {
        PersonVO personVO = new PersonVO();
        personVO.setName("lombok").setAge(2).setBirthday(LocalDate.of(2020, 1, 1)).setAccount(new BigDecimal("5.2")).setDeleted(false);
        PersonEntity personEntity = PersonMapper.INSTANCE.toEntity(personVO);
        return PersonMapper.INSTANCE.toVO(personEntity);
    }

    @GetMapping("/exception")
    public ResponseResultDTO exception() {
        throw new BaseException();
    }

    @GetMapping("/ignoreTracing")
    @IgnoreTracing
    public ResponseResultDTO ignoreTracing() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name", "mybatisPlus");
        wrapper.last("limit 1");
        PersonEntity personEntity = personService.getOne(wrapper);
        return ResponseResultDTO.ok("look console", personEntity);
    }

    @GetMapping("/async")
    public ResponseResultDTO async() {
        personService.async();
        return ResponseResultDTO.ok("look console");
    }
}
