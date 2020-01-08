package com.xiaotang.springaccount.config;

import com.xiaotang.springaccount.interceptor.InsertInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 * @data 2020/1/7
 * @time 9:14
 */
@Configuration
public class MybatisConfiguration {

    @Bean
    InsertInterceptor insertInterceptor(){
        return new InsertInterceptor();
    }
}
