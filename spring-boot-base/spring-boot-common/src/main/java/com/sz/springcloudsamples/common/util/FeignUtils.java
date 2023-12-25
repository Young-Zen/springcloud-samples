package com.sz.springcloudsamples.common.util;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;

import com.sz.springcloudsamples.common.mvc.constant.ConstantForHttpHeader;

/**
 * @author Yanghj
 * @date 2023/7/18 10:38
 */
@Component
public class FeignUtils {

    public static String feignMarkValue;

    @Value("${feign.req.mark:9527}")
    public void setFeignMark(String feignMark) {
        FeignUtils.feignMarkValue = feignMark;
    }

    private static class FeignUtilsHolder {
        private static final FeignUtils INSTANCE = new FeignUtils();
    }

    private FeignUtils() {}

    public static final FeignUtils getInstance() {
        return FeignUtils.FeignUtilsHolder.INSTANCE;
    }

    public boolean isFeignRequest(HttpServletRequest request) {
        String feignMark = request.getHeader(ConstantForHttpHeader.FEIGN_MARK);
        return Objects.equals(feignMark, feignMarkValue);
    }

    public boolean isFeignRequest(ServerHttpRequest serverHttpRequest) {
        HttpHeaders headers = serverHttpRequest.getHeaders();
        String feignMark = headers.getFirst(ConstantForHttpHeader.FEIGN_MARK);
        return Objects.equals(feignMark, feignMarkValue);
    }
}
