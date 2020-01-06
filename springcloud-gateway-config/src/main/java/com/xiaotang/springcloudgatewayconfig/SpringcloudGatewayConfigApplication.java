package com.xiaotang.springcloudgatewayconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudGatewayConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudGatewayConfigApplication.class, args);
    }

}


