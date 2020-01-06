package com.xiaotang.springcloudgatewayconfig.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @data 2019/12/27
 * @time 14:35
 */
@RefreshScope
@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Value("${spring.cloud.nacos.config.name}")
    String name;

    @GetMapping("/config")
    public String config() {
        return name;
    }
}
