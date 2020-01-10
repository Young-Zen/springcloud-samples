package com.sz.springcloudsamples.common.mvc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sz.springcloudsamples.common.mvc.dao.BaseDAO;

/**
 * @author Yanghj
 * @date 1/10/2020
 */
public class BaseServiceImpl<M extends BaseDAO<T>, T> extends ServiceImpl<M, T> {
}
