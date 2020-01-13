package com.sz.springcloudsamples.demo.service.mapper;

import com.sz.springcloudsamples.common.mvc.mapper.BaseMapper;
import com.sz.springcloudsamples.demo.entity.PersonEntity;
import com.sz.springcloudsamples.demo.vo.PersonVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author Yanghj
 * @date 1/13/2020
 */
@Mapper
public interface PersonMapper extends BaseMapper<PersonVO, PersonEntity> {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Override
    @Mappings({
            @Mapping(source = "pkPersonId", target = "personId")
    })
    PersonVO toVO(PersonEntity entity);

    @Override
    @Mappings({
            @Mapping(source = "personId", target = "pkPersonId")
    })
    PersonEntity toEntity(PersonVO vo);
}
