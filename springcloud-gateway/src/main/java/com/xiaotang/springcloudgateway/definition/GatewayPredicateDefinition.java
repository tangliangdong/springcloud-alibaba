package com.xiaotang.springcloudgateway.definition;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Administrator
 * @data 2019/12/26
 * @time 16:41
 */
@Getter
@Setter
public class GatewayPredicateDefinition {
    //断言对应的Name
    private String name;
    //配置的断言规则
    private Map<String, String> args = new LinkedHashMap<>();

}
