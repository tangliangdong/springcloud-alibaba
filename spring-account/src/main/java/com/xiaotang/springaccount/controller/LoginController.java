package com.xiaotang.springaccount.controller;

import com.xiaotang.springaccount.dto.UserInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @data 2020/1/15
 * @time 14:58
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @PostMapping("doLogin")
    public UserInfo doLogin(HttpSession session, UserInfo userInfo){
        session.setAttribute("USERINFO", userInfo);
        return userInfo;
    }

    @PostMapping("test")
    public String test(){
        return null;
    }

    @PostMapping("testarray")
    public List testarray(){
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        return list;
    }

    @PostMapping("testarray2")
    public List testarray2(){
        return null;
    }

    @PostMapping("testarray3")
    public Boolean testarray3(){
        return null;
    }
}
