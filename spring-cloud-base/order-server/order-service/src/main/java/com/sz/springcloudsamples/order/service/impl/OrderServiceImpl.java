package com.sz.springcloudsamples.order.service.impl;

import com.sz.springcloudsamples.common.mvc.dto.ResponseResultDTO;
import com.sz.springcloudsamples.common.mvc.service.impl.BaseServiceImpl;
import com.sz.springcloudsamples.order.dao.OrderDao;
import com.sz.springcloudsamples.order.entity.OrderEntity;
import com.sz.springcloudsamples.order.service.OrderService;
import com.sz.springcloudsamples.order.service.feign.StorageFeignClient;
import com.sz.springcloudsamples.order.service.mapper.OrderMapper;
import com.sz.springcloudsamples.order.vo.OrderVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Yanghj
 * @date 2023/7/17 18:35
 */
@Service
@Slf4j
public class OrderServiceImpl extends BaseServiceImpl<OrderDao, OrderEntity> implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private StorageFeignClient storageFeignClient;

    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    @Override
    public void create(OrderVO order) {
        log.info("------->交易开始");
        //本地方法
        OrderEntity entity = OrderMapper.INSTANCE.toEntity(order);
        super.save(entity);

        //远程方法 扣减库存
        ResponseResultDTO responseResultDTO = storageFeignClient.decrease(order.getProductId(), order.getCount());
        log.info("------->扣减库存结果:" + responseResultDTO.getMsg());

        this.update(entity.getId(), entity.getMoney(), 1);
        log.info("------->交易结束");
    }

    /**
     * 修改订单状态
     *
     * @param id
     * @param money
     * @param status
     */
    @Override
    public void update(Long id, BigDecimal money, Integer status) {
        OrderEntity orderEntity = orderDao.selectById(id);
        orderEntity.setMoney(money);
        orderEntity.setStatus(status);
        orderDao.updateById(orderEntity);
    }
}
