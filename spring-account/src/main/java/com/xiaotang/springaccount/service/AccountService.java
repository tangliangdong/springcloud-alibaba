package com.xiaotang.springaccount.service;

import com.xiaotang.springaccount.consumer.OrdersClient;
import com.xiaotang.springaccount.dao.AccountMapper;
import com.xiaotang.springaccount.model.Account;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 * @data 2020/1/8
 * @time 16:09
 */
@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private OrdersClient ordersClient;

    public Integer add(Account account){
        return accountMapper.insert(account);
    }

    @GlobalTransactional(rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public Integer addTest(Account account){

        ordersClient.add("banana", 2, 1, account.getUsername());
        Integer index = add(account);
        throw new RuntimeException();
//        return index;
    }
}
