package com.sz.springcloudsamples.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

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
        personService.save(PersonMapper.INSTANCE.personVO2PersonEntity(personVO));

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name", "mybatisPlus");
        wrapper.last("limit 1");
        wrapper.orderByDesc("pk_person_id");
        PersonEntity personEntity = personService.getOne(wrapper);
        return super.ok(PersonMapper.INSTANCE.personEntity2PersonVO(personEntity));
    }
}
