package com.xiaotang.springaccount.controller;

import com.xiaotang.springaccount.consumer.OrdersClient;
import com.xiaotang.springaccount.model.Account;
import com.xiaotang.springaccount.service.AccountService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @data 2020/1/8
 * @time 16:53
 */
@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private OrdersClient ordersClient;

    @PostMapping("add")
    public Integer add(Account account){
        Integer index = accountService.add(account);
        ordersClient.add("banana", 2, 1, account.getUsername());
        return index;
    }

    @PostMapping("addTest")
    public Integer addTest(Account account){
        return accountService.addTest(account);
    }

    @PostMapping("order/add")
    public Integer add(String goodsName, Integer price, Integer num, String username){
        return ordersClient.add(goodsName, price, num, username);
    }
}
