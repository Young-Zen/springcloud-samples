package com.sz.springcloudsamples.storage.service.mapper;

import com.sz.springcloudsamples.common.mvc.mapper.BaseMapper;
import com.sz.springcloudsamples.storage.entity.StockEntity;
import com.sz.springcloudsamples.storage.vo.StockVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Yanghj
 * @date 2023/7/17 18:41
 */
@Mapper
public interface StockMapper extends BaseMapper<StockVO, StockEntity> {
    StockMapper INSTANCE = Mappers.getMapper(StockMapper.class);
}
