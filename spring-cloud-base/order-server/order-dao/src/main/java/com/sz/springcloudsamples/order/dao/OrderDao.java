package com.sz.springcloudsamples.order.dao;

import org.apache.ibatis.annotations.Mapper;

import com.sz.springcloudsamples.common.mvc.dao.BaseDAO;
import com.sz.springcloudsamples.order.entity.OrderEntity;

/**
 * @author Yanghj
 * @date 2023/7/17 16:55
 */
@Mapper
public interface OrderDao extends BaseDAO<OrderEntity> {}
