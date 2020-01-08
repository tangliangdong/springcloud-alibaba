package com.xiaotang.springaccount;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@MapperScan("com.xiaotang.springaccount.dao")
public class SpringAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAccountApplication.class, args);
    }

}
