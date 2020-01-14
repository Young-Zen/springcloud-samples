package com.sz.springcloudsamples.common.aspect;

import com.sz.springcloudsamples.common.config.property.LogProperties;
import com.sz.springcloudsamples.common.mvc.dto.LogDTO;
import com.sz.springcloudsamples.common.thread.threadlocal.LogHolder;
import com.sz.springcloudsamples.common.util.AspectUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Yanghj
 * @date 1/13/2020
 */
@Aspect
@Order(1)
@ConditionalOnProperty(name = "custom.log.enable", havingValue = "true", matchIfMissing = true)
@Component
@Slf4j
public class LogAspect {

    @Autowired
    private LogProperties logProperties;

    /**
     * 方法前置通知，打印方法入参
     *
     * @param joinPoint
     */
    @Before(value = "com.sz.springcloudsamples.common.aspect.Pointcuts.controllerAspect()" +
            "||com.sz.springcloudsamples.common.aspect.Pointcuts.serviceAspect()" +
            "||com.sz.springcloudsamples.common.aspect.Pointcuts.daoAspect()")
    public void methodBefore(JoinPoint joinPoint) {
        LogDTO logDTO = LogHolder.getLogDto();
        logDTO.setLogStep(logDTO.getLogStep() + 1)
                .setAdviceCount(logDTO.getAdviceCount() + 1);
//        LogHolder.setLogDto(logDTO);
        if (logDTO.getIsIgnoreTracing() || !logProperties.getParam()) {
            return;
        }
        log.info("第{}步，方法名：{}，参数：{}", logDTO.getLogStep(), joinPoint.getSignature(), AspectUtils.getInstance().getMethodParams(joinPoint));
    }

    /**
     * 方法后置增强，打印方法返回结果
     *
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "com.sz.springcloudsamples.common.aspect.Pointcuts.controllerAspect()" +
            "||com.sz.springcloudsamples.common.aspect.Pointcuts.serviceAspect()" +
            "||com.sz.springcloudsamples.common.aspect.Pointcuts.daoAspect()", returning = "result")
    public void methodAferReturning(JoinPoint joinPoint, Object result) {
        LogDTO logDTO = LogHolder.getLogDto();
        logDTO.setAdviceCount(logDTO.getAdviceCount() + 1);
//        LogHolder.setLogDto(logDTO);
        if (logDTO.getIsIgnoreTracing() || !logProperties.getResult()) {
            return;
        }
        log.info("结果：[{}] {}", joinPoint.getSignature(), result);
    }

    @AfterThrowing(value = "com.sz.springcloudsamples.common.aspect.Pointcuts.controllerAspect()", throwing = "cause")
    public void methodAfterThrowing(Throwable cause) {
        LogDTO logDTO = LogHolder.getLogDto();
        logDTO.setAdviceCount(logDTO.getAdviceCount() + 1)
                .setIsThrowing(true);
//        LogHolder.setLogDto(logDTO);
    }
}
