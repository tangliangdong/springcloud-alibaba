package com.xiaotang.client.nacosclient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Administrator
 * @data 2019/12/24
 * @time 16:34
 */
@RestController
@RequestMapping("open")
public class OpenController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("login")
    public String login(String name) {
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-server");
        String url = serviceInstance.getUri() + "/open/login?name=" + name;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return "Invoke : " + url + ", return : " + result;
    }
}
