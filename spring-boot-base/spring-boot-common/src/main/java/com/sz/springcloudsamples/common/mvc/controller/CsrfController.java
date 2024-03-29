package com.sz.springcloudsamples.common.mvc.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 提供csrf token给swagger-ui.html
 *
 * @author Yanghj
 * @date 1/13/2020
 */
@RestController
@ConditionalOnExpression("${custom.swagger.enable:true} && ${custom.swagger.csrf.enable:false}")
@Api(tags = "设置csrf token")
public class CsrfController {

    @GetMapping("/csrf")
    @ApiOperation("Define an endpoint used to fetch csrf token for swagger-ui.html")
    public CsrfToken csrf(CsrfToken token) {
        return token;
    }
}
