package com.sz.springcloudsamples.common.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 日志属性类
 *
 * @author Yanghj
 * @date 1/13/2020
 */
@Data
@Component
@ConfigurationProperties(prefix = "custom.log")
public class LogProperties {
    private Boolean enable = Boolean.TRUE;
    private Boolean param = Boolean.TRUE;
    private Boolean result = Boolean.TRUE;
    private String additionalSkipPattern = "";
}
