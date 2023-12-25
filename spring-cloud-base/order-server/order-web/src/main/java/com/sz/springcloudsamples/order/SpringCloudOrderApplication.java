package com.sz.springcloudsamples.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Order server 应用程序
 *
 * @author Yanghj
 * @date 1/11/2020
 */
@SpringBootApplication(scanBasePackages = "com.sz")
@MapperScan({"com.sz.**.dao"})
@EnableEurekaClient
@EnableFeignClients
public class SpringCloudOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudOrderApplication.class, args);
    }
}
