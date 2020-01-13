package com.sz.springcloudsamples.common.annotation;

import java.lang.annotation.*;

/**
 * @author Yanghj
 * @date 1/13/2020
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreTracing {
}
