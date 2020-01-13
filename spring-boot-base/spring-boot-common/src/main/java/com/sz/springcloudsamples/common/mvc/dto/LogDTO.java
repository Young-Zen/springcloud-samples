package com.sz.springcloudsamples.common.mvc.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Yanghj
 * @date 1/13/2020
 */
@Data
@Accessors(chain = true)
public class LogDTO {
    private String logCode;
    private Integer logStep;
    private Integer adviceCount;
    private Boolean isThrowing;
    private Boolean isIgnoreTracing;
}
