package com.sz.springcloudsamples.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * SpringCloud Demo应用程序
 *
 * @author Yanghj
 * @date 1/11/2020
 */
@SpringBootApplication(scanBasePackages = "com.sz")
@MapperScan({"com.sz.**.dao"})
@EnableEurekaClient
public class SpringCloudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoApplication.class, args);
    }
}
