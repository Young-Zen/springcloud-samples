package com.sz.springcloudsamples.common.mvc.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sz.springcloudsamples.common.mvc.entity.BaseEntity;
import com.sz.springcloudsamples.common.mvc.vo.BaseVO;

import java.util.List;

/**
 * @author Yanghj
 * @date 1/11/2020
 */
public interface BaseMapper<V extends BaseVO, E extends BaseEntity> {

    V entity2Vo(E entity);

    E vo2Entity(V v);

    List<V> entityList2VoList(List<E> entityList);

    List<E> voList2EntityList(List<V> voList);

    default IPage<V> entityPage2VoPage(IPage<E> entityPage) {
        if (entityPage == null) {
            return null;
        }
        IPage<V> voPage = new Page<V>(entityPage.getCurrent(), entityPage.getSize(), entityPage.getTotal());
        voPage.setRecords(this.entityList2VoList(entityPage.getRecords()));
        return voPage;
    }
}
