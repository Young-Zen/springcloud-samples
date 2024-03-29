package com.sz.springcloudsamples.common.mvc.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sz.springcloudsamples.common.annotation.IgnoreTracing;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 设置主页为/swagger-ui.html
 *
 * @author Yanghj
 * @date 1/13/2020
 */
@Controller
@ConditionalOnProperty(name = "custom.swagger.enable", havingValue = "true", matchIfMissing = true)
@IgnoreTracing
@Api(tags = "主页")
public class HomeController {

    @GetMapping("/")
    @ApiOperation("设置主页")
    public String home() {
        return "redirect:swagger-ui.html";
    }
}
