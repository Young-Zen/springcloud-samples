package com.sz.springcloudsamples.demo.service;

import com.sz.springcloudsamples.common.mvc.service.BaseService;
import com.sz.springcloudsamples.demo.entity.PersonEntity;

/**
 * @author Yanghj
 * @date 1/13/2020
 */
public interface PersonService extends BaseService<PersonEntity> {
    /** test async */
    void async();
}
