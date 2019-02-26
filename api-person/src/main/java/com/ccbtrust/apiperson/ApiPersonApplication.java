package com.ccbtrust.apiperson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author nzhang
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.ccbtrust.remoteclient.client"})
public class ApiPersonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiPersonApplication.class, args);
    }

}
