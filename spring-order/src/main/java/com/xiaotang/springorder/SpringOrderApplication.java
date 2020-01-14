package com.xiaotang.springorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.xiaotang.springorder.dao")
public class SpringOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringOrderApplication.class, args);
    }

}
