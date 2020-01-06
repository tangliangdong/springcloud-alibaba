package com.xiaotang.springorder.service;

import com.xiaotang.springorder.dao.OrdersMapper;
import com.xiaotang.springorder.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @data 2020/1/6
 * @time 16:01
 */
@Service
public class OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    public List<Orders> getList(){
        return ordersMapper.getList();
    }
}
