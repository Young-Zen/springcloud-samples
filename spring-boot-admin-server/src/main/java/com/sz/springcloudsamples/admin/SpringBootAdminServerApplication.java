package com.sz.springcloudsamples.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.sz.springcloudsamples.admin.config.security.AdminServerWebSecurityConfig;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

/**
 * Spring Boot Admin服务器
 *
 * @author Yanghj
 * @date 1/3/2020
 */
@Configuration
@EnableAutoConfiguration
@EnableAdminServer
@EnableEurekaClient
@Import({AdminServerWebSecurityConfig.class})
public class SpringBootAdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminServerApplication.class, args);
    }
}
