package com.sz.springcloudsamples.order.service;

import com.sz.springcloudsamples.common.mvc.service.BaseService;
import com.sz.springcloudsamples.order.entity.OrderEntity;
import com.sz.springcloudsamples.order.vo.OrderVO;

import java.math.BigDecimal;

/**
 * @author Yanghj
 * @date 2023/7/17 18:34
 */
public interface OrderService extends BaseService<OrderEntity> {

    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    void create(OrderVO order);

    /**
     * 修改订单状态
     *
     * @param id
     * @param money
     * @param status
     */
    void update(Long id, BigDecimal money, Integer status);
}
