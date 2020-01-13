package com.sz.springcloudsamples.demo.dao;

import com.sz.springcloudsamples.common.mvc.dao.BaseDAO;
import com.sz.springcloudsamples.demo.entity.PersonEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Yanghj
 * @date 1/13/2020
 */
@Mapper
public interface PersonDAO extends BaseDAO<PersonEntity> {
}
