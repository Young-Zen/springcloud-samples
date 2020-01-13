package com.sz.springcloudsamples.common.mvc.controller;

import com.sz.springcloudsamples.common.annotation.IgnoreTracing;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Yanghj
 * @date 1/13/2020
 */
@Controller
@ConditionalOnProperty(name = "custom.swagger.enable", havingValue = "true", matchIfMissing = true)
@Api(tags = "主页")
public class HomeController {

    @GetMapping("/")
    @IgnoreTracing
    @ApiOperation("设置主页")
    public String home() {
        return "redirect:swagger-ui.html";
    }
}
