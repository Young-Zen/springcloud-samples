package com.sz.springcloudsamples.demo.mapper;

import com.sz.springcloudsamples.demo.entity.PersonEntity;
import com.sz.springcloudsamples.demo.vo.PersonVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Yanghj
 * @date 1/10/2020
 */
@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonVO personEntity2PersonVO(PersonEntity personEntity);

    PersonEntity personVO2PersonEntity(PersonVO personVO);
}
