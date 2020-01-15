package com.xiaotang.springaccount;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import io.seata.config.ConfigType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.xiaotang.springaccount.dao")
public class SpringAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAccountApplication.class, args);
    }

}
