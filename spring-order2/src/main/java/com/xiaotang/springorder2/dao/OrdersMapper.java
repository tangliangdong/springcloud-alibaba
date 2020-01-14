package com.xiaotang.springorder2.dao;

import com.xiaotang.springorder2.model.Orders;

import java.util.List;

public interface OrdersMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    List<Orders> getList();
}