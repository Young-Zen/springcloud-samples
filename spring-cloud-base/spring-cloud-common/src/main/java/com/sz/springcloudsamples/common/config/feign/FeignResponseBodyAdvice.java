package com.sz.springcloudsamples.common.config.feign;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.sz.springcloudsamples.common.mvc.constant.ConstantForHttpHeader;
import com.sz.springcloudsamples.common.thread.threadlocal.LogHolder;
import com.sz.springcloudsamples.common.util.FeignUtils;

/**
 * @author Yanghj
 * @date 2023/7/18 10:34
 */
@ControllerAdvice
public class FeignResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(
            MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(
            Object o,
            MethodParameter methodParameter,
            MediaType mediaType,
            Class<? extends HttpMessageConverter<?>> aClass,
            ServerHttpRequest serverHttpRequest,
            ServerHttpResponse serverHttpResponse) {
        if (FeignUtils.getInstance().isFeignRequest(serverHttpRequest)) {
            HttpHeaders headers = serverHttpResponse.getHeaders();
            headers.add(
                    ConstantForHttpHeader.LOG_STEP, LogHolder.getLogDto().getLogStep().toString());
        }
        return o;
    }
}
