package com.sz.springcloudsamples.common.mvc.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sz.springcloudsamples.common.mvc.entity.BaseEntity;
import com.sz.springcloudsamples.common.mvc.vo.BaseVO;

import java.util.List;

/**
 * 基本实体映射处理接口
 *
 * @author Yanghj
 * @date 1/11/2020
 */
public interface BaseMapper<T extends BaseVO, S extends BaseEntity> {

    /**
     * to VO
     * @param entity
     * @return
     */
    T toVO(S entity);

    /**
     * to Entity
     * @param vo
     * @return
     */
    S toEntity(T vo);

    /**
     * to VOList
     * @param entityList
     * @return
     */
    List<T> toVOList(List<S> entityList);

    /**
     * to EntityList
     * @param voList
     * @return
     */
    List<S> toEntityList(List<T> voList);

    /**
     * to VOPage
     * @param entityPage
     * @return
     */
    default IPage<T> toVoPage(IPage<S> entityPage) {
        if (entityPage == null) {
            return null;
        }
        IPage<T> voPage = new Page<T>(entityPage.getCurrent(), entityPage.getSize(), entityPage.getTotal());
        voPage.setRecords(this.toVOList(entityPage.getRecords()));
        return voPage;
    }
}
