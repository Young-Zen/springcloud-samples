package com.sz.springcloudsamples.common.webmvc.interceptor;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sz.springcloudsamples.common.annotation.IgnoreTracing;
import com.sz.springcloudsamples.common.mvc.constant.ConstantForHttpHeader;
import com.sz.springcloudsamples.common.mvc.dto.LogDTO;
import com.sz.springcloudsamples.common.thread.threadlocal.LogHolder;
import com.sz.springcloudsamples.common.util.FeignUtils;

import cn.hutool.extra.servlet.ServletUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 日志拦截器
 *
 * @author Yanghj
 * @date 1/13/2020
 */
@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    private static final String DEFAULT_SKIP_PATTERN = "/swagger.*";

    private final Pattern pattern;

    private String applicationContextPath = "/";

    public LogInterceptor(String additionalSkipPattern) {
        String skipPattern =
                StringUtils.hasText(additionalSkipPattern)
                        ? DEFAULT_SKIP_PATTERN + "|" + additionalSkipPattern
                        : DEFAULT_SKIP_PATTERN;
        pattern = Pattern.compile(skipPattern);
    }

    public LogInterceptor setApplicationContextPath(String applicationContextPath) {
        this.applicationContextPath = applicationContextPath;
        return this;
    }

    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        LogDTO logDTO = new LogDTO();
        String logCode = "http_" + UUID.randomUUID();
        logDTO.setLogCode(logCode)
                .setLogStep(0)
                .setAdviceCount(0)
                .setIsThrowing(false)
                .setIsIgnoreTracing(false);
        // 设置 isIgnoreTracing
        Method method = ((HandlerMethod) handler).getMethod();
        IgnoreTracing ignoreTracing = method.getAnnotation(IgnoreTracing.class);
        if (ignoreTracing == null) {
            // ignoreTracing = ((HandlerMethod)
            // handler).getBeanType().getAnnotation(IgnoreTracing.class);
            ignoreTracing = method.getDeclaringClass().getAnnotation(IgnoreTracing.class);
        }
        if (ignoreTracing != null) {
            logDTO.setIsIgnoreTracing(true);
        }

        Matcher matcher =
                pattern.matcher(
                        this.trimHead(
                                request.getRequestURI(),
                                "/".equals(applicationContextPath) ? "" : applicationContextPath));
        if (matcher.matches()) {
            logDTO.setIsIgnoreTracing(true);
            LogHolder.setLogDto(logDTO);
            return true;
        }

        if (FeignUtils.getInstance().isFeignRequest(request)) {
            logDTO.setLogCode(request.getHeader(ConstantForHttpHeader.LOG_CODE))
                    .setLogStep(Integer.parseInt(request.getHeader(ConstantForHttpHeader.LOG_STEP)))
                    .setIsIgnoreTracing(
                            Boolean.valueOf(
                                    request.getHeader(ConstantForHttpHeader.LOG_IGNORE_TRACING)));
        }

        LogHolder.setLogDto(logDTO);
        response.setHeader(ConstantForHttpHeader.LOG_CODE, logDTO.getLogCode());
        log.info(
                "{}，服务器IP：{}，请求IP：{}，请求方式：{}，URL：{}",
                logDTO.getLogCode(),
                InetAddress.getLocalHost().getHostAddress(),
                ServletUtil.getClientIP(request),
                request.getMethod(),
                request.getRequestURL());
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView)
            throws Exception {}

    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        LogHolder.clean();
    }

    private String trimHead(String source, String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return source;
        }
        if (source != null && source.startsWith(prefix)) {
            return source.substring(prefix.length());
        }
        return source;
    }
}
