package com.xiaotang.server.springserver.utils;

import com.alibaba.csp.sentinel.slots.block.BlockException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @data 2019/12/25
 * @time 16:27
 */
public class ExceptionUtil {

    public static Map<String,Object> handleException(BlockException ex) {
        Map<String,Object> map=new HashMap<>();
        System.out.println("Oops: " + ex.getClass().getCanonicalName());
        map.put("Oops",ex.getClass().getCanonicalName());
        map.put("msg","通过@SentinelResource注解配置限流埋点并自定义处理限流后的逻辑");
        return  map;
    }
}
