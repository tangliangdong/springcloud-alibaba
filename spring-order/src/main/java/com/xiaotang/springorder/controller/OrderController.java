package com.xiaotang.springorder.controller;

import com.xiaotang.springorder.model.Orders;
import com.xiaotang.springorder.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Administrator
 * @data 2020/1/6
 * @time 15:54
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping("list")
    public List<Orders> getOrdersList(){
        System.out.println("你好世界12312");
        return ordersService.getList();
    }

    @PostMapping("add")
    public Integer add(String goodsName, Integer price, Integer num, String username){
        Orders orders = new Orders();
        orders.setUsername(username);
        orders.setGoodsName(goodsName);
        orders.setPrice(price);
        orders.setNum(num);

        return ordersService.add(orders);
    }
}
