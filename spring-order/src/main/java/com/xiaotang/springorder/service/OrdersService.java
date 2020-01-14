package com.xiaotang.springorder.service;

import com.xiaotang.springorder.dao.OrdersMapper;
import com.xiaotang.springorder.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(rollbackFor = Exception.class)
    public Integer add(Orders orders){
        Integer index = ordersMapper.insert(orders);
        System.out.println("你好世界");
//        throw new RuntimeException();
        return index;
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer update(Orders orders){
        Integer index = ordersMapper.updateByPrimaryKeySelective(orders);
        System.out.println("你好世界");
//        throw new RuntimeException();
        return index;
    }
}
