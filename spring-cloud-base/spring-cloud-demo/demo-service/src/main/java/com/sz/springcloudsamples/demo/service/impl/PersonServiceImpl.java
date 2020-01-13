package com.sz.springcloudsamples.demo.service.impl;

import com.sz.springcloudsamples.common.mvc.service.impl.BaseServiceImpl;
import com.sz.springcloudsamples.common.thread.threadlocal.LogHolder;
import com.sz.springcloudsamples.demo.dao.PersonDAO;
import com.sz.springcloudsamples.demo.entity.PersonEntity;
import com.sz.springcloudsamples.demo.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author Yanghj
 * @date 1/13/2020
 */
@Service
@Slf4j
public class PersonServiceImpl extends BaseServiceImpl<PersonDAO, PersonEntity> implements PersonService {

    @Override
    @Async
    public void async() {
        log.info(LogHolder.getLogDto().getLogCode());
    }
}
