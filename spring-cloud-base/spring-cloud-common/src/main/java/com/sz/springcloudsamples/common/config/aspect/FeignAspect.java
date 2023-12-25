package com.sz.springcloudsamples.common.config.aspect;

import java.util.Objects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.sz.springcloudsamples.common.aspect.LogAspect;
import com.sz.springcloudsamples.common.exception.BaseException;
import com.sz.springcloudsamples.common.mvc.dto.ResponseResultDTO;
import com.sz.springcloudsamples.common.mvc.enums.ResponseCodeEnum;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Yanghj
 * @date 2023/7/17 20:44
 */
@Aspect
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
@Component
@Slf4j
public class FeignAspect {

    @Autowired private LogAspect logAspect;

    @Pointcut("@within(org.springframework.cloud.openfeign.FeignClient)")
    public void feignClientAspect() {}

    @AfterReturning(value = "feignClientAspect()", returning = "obj")
    public void methodAfterReturning(Object obj) {
        if (obj instanceof ResponseResultDTO) {
            ResponseResultDTO resultDTO = (ResponseResultDTO) obj;
            if (!Objects.equals(ResponseCodeEnum.OK.getCode(), resultDTO.getCode())) {
                throw new BaseException(resultDTO.getCode(), resultDTO.getMsg());
            }
        }
    }

    @Before(value = "feignClientAspect()")
    public void methodBefore(JoinPoint joinPoint) {
        logAspect.methodBefore(joinPoint);
    }
}
