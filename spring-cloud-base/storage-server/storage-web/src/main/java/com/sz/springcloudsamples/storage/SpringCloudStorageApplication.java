package com.sz.springcloudsamples.storage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Order server 应用程序
 *
 * @author Yanghj
 * @date 1/11/2020
 */
@SpringBootApplication(scanBasePackages = "com.sz")
@MapperScan({"com.sz.**.dao"})
@EnableEurekaClient
public class SpringCloudStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStorageApplication.class, args);
    }
}
