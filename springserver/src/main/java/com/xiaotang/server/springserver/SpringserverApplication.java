package com.xiaotang.server.springserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringserverApplication.class, args);
    }

}
