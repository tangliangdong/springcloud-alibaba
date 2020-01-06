package com.xiaotang.springorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xiaotang.springorder.dao")
public class SpringOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringOrderApplication.class, args);
    }

}
