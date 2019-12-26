//package com.xiaotang.springcloudgateway.controllers;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author Administrator
// * @data 2019/12/26
// * @time 10:00
// */
//
//@RestController
//@RequestMapping("/config")
//@RefreshScope
//public class ConfigController {
//
//    @Value("${useLocalCache:false}")
//    private boolean useLocalCache;
//
//    @RequestMapping("/get")
//    public boolean get() {
//        return useLocalCache;
//    }
//}