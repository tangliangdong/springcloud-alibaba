package com.xiaotang.springcloudgateway.definition;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Administrator
 * @data 2019/12/26
 * @time 16:40
 */
@Getter
@Setter
public class GatewayFilterDefinition {
    //Filter Name
    private String name;
    //对应的路由规则
    private Map<String, String> args = new LinkedHashMap<>();
}
