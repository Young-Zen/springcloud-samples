package com.sz.springcloudsamples.storage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sz.springcloudsamples.common.mvc.dao.BaseDAO;
import com.sz.springcloudsamples.storage.entity.StockEntity;

/**
 * @author Yanghj
 * @date 2023/7/17 16:55
 */
@Mapper
public interface StockDao extends BaseDAO<StockEntity> {

    /**
     * 扣减库存
     *
     * @param productId 产品id
     * @param count 数量
     * @return
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
