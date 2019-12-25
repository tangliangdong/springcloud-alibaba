package com.xiaotang.server.springserver.controllers;

import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 * @data 2019/12/24
 * @time 16:02
 */
@RestController
@RequestMapping("open")
public class OpenController {

    @GetMapping("login")
    public String login(String name){
        return name + "do login";
    }
}
