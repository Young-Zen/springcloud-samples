package com.sz.springcloudsamples.storage.service.impl;

import com.sz.springcloudsamples.common.mvc.service.impl.BaseServiceImpl;
import com.sz.springcloudsamples.storage.dao.StockDao;
import com.sz.springcloudsamples.storage.entity.StockEntity;
import com.sz.springcloudsamples.storage.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Yanghj
 * @date 2023/7/17 18:35
 */
@Service
@Slf4j
public class StockServiceImpl extends BaseServiceImpl<StockDao, StockEntity> implements StockService {

    @Autowired
    private StockDao stockDao;

    /**
     * 扣减库存
     *
     * @param productId 产品id
     * @param count     数量
     * @return
     */
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->扣减库存开始");
        stockDao.decrease(productId, count);
        log.info("------->扣减库存结束");
    }
}
