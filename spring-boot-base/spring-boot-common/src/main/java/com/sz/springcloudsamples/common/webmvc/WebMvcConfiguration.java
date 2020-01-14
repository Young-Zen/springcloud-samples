package com.sz.springcloudsamples.common.webmvc;

import com.sz.springcloudsamples.common.config.property.LogProperties;
import com.sz.springcloudsamples.common.webmvc.interceptor.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Spring WebMvc配置类
 *
 * @author Yanghj
 * @date 1/13/2020
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    LogProperties logProperties;

    @Value("${server.servlet.context-path:/}")
    private String applicationContextPath;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        if (logProperties.getEnable()) {
            LogInterceptor logInterceptor = new LogInterceptor(logProperties.getAdditionalSkipPattern());
            logInterceptor.setApplicationContextPath(applicationContextPath);
            registry.addInterceptor(logInterceptor);
        }
    }
}
