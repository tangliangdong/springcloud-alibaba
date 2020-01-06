package com.xiaotang.server.springserver.controllers;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xiaotang.server.springserver.utils.ExceptionUtil;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @data 2019/12/24
 * @time 16:02
 */
@RestController
@RequestMapping("open")
public class OpenController {

    @GetMapping("login")
    public String login(String name) {
        return name + "do login";
    }

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public String byResource() {
        return "按资源名称限流";
    }

    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl", blockHandler = "handleException")
    public String byUrl() {
        return "按url限流";
    }


    @SentinelResource("resource")
    @RequestMapping("/sentinel/hello")
    public Map<String, Object> hello(String appName) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("appName", appName);
        map.put("method", "hello");
        return map;
    }


    @RequestMapping("/sentinel/test")
    public Map<String, Object> test(String appName) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("appName", appName);
        map.put("method", "test");
        return map;
    }

    @SentinelResource(value = "resource2", blockHandler = "handleException", blockHandlerClass = {ExceptionUtil.class})
    @RequestMapping("/sentinel/test2")
    public Map<String, Object> test2() {
        Map<String, Object> map = new HashMap<>();
        map.put("method", "test2");
        map.put("msg", "自定义限流逻辑处理");
        return map;
    }

}
