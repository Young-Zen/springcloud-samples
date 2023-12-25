package com.sz.springcloudsamples.storage.service;

import com.sz.springcloudsamples.common.mvc.service.BaseService;
import com.sz.springcloudsamples.storage.entity.StockEntity;

/**
 * @author Yanghj
 * @date 2023/7/17 18:34
 */
public interface StockService extends BaseService<StockEntity> {

    /**
     * 扣减库存
     *
     * @param productId 产品id
     * @param count 数量
     * @return
     */
    void decrease(Long productId, Integer count);
}
