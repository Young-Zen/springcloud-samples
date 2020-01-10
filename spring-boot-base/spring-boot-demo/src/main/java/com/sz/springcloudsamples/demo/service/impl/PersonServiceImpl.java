package com.sz.springcloudsamples.demo.service.impl;

import com.sz.springcloudsamples.common.mvc.service.impl.BaseServiceImpl;
import com.sz.springcloudsamples.demo.dao.PersonDAO;
import com.sz.springcloudsamples.demo.entity.PersonEntity;
import com.sz.springcloudsamples.demo.service.PersonService;
import org.springframework.stereotype.Service;

/**
 * @author Yanghj
 * @date 1/10/2020
 */
@Service
public class PersonServiceImpl extends BaseServiceImpl<PersonDAO, PersonEntity> implements PersonService {
}
