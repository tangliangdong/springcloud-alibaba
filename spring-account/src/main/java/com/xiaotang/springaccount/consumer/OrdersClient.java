package com.xiaotang.springaccount.consumer;

import com.xiaotang.springaccount.model.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Administrator
 * @data 2020/1/8
 * @time 17:22
 */
@FeignClient("order-server")
public interface OrdersClient {

    @PostMapping("/order/add")
    Integer add(@RequestParam("goodsName") String goodsName, @RequestParam("price") Integer price, @RequestParam("num") Integer num, @RequestParam("username") String username);


}
