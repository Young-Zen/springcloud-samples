package com.sz.springcloudsamples.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.sz.springcloudsamples.common.mvc.dao.BaseDAO;
import com.sz.springcloudsamples.demo.entity.PersonEntity;

/**
 * @author Yanghj
 * @date 1/10/2020
 */
@Mapper
public interface PersonDAO extends BaseDAO<PersonEntity> {}
