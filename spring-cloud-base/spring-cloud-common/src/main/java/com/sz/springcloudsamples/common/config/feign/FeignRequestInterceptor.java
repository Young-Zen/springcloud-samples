package com.sz.springcloudsamples.common.config.feign;

import com.sz.springcloudsamples.common.mvc.constant.ConstantForHttpHeader;
import com.sz.springcloudsamples.common.thread.threadlocal.LogHolder;
import com.sz.springcloudsamples.common.util.FeignUtils;
import com.sz.springcloudsamples.common.util.RequestUtils;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author Yanghj
 * @date 2023/7/17 20:13
 */
@Component
public class FeignRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        HttpServletRequest httpServletRequest = RequestUtils.getInstance().getHttpServletRequest();
        if (Objects.isNull(httpServletRequest)) {
            return;
        }

        requestTemplate.header(ConstantForHttpHeader.AUTHORIZATION, httpServletRequest.getHeader(ConstantForHttpHeader.AUTHORIZATION));
        requestTemplate.header(ConstantForHttpHeader.FEIGN_MARK, FeignUtils.feignMarkValue);
        requestTemplate.header(ConstantForHttpHeader.LOG_CODE, LogHolder.getLogDto().getLogCode());
        requestTemplate.header(ConstantForHttpHeader.LOG_STEP, LogHolder.getLogDto().getLogStep().toString());
        requestTemplate.header(ConstantForHttpHeader.LOG_IGNORE_TRACING, LogHolder.getLogDto().getIsIgnoreTracing().toString());
    }
}
