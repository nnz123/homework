package com.ccbtrust.serviceperson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author nzhang
 */
@EnableEurekaClient
@SpringBootApplication
public class ServicePersonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicePersonApplication.class, args);
    }

}
