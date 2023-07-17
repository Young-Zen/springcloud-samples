package com.sz.springcloudsamples.order.service.mapper;

import com.sz.springcloudsamples.common.mvc.mapper.BaseMapper;
import com.sz.springcloudsamples.order.entity.OrderEntity;
import com.sz.springcloudsamples.order.vo.OrderVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Yanghj
 * @date 2023/7/17 18:41
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderVO, OrderEntity> {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
}
