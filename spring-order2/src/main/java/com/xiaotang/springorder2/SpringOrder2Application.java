package com.xiaotang.springorder2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@MapperScan("com.xiaotang.springorder2.dao")
public class SpringOrder2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringOrder2Application.class, args);
    }

}
