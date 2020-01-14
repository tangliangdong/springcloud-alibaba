package com.xiaotang.springaccount.service;

import com.xiaotang.springaccount.consumer.OrdersClient;
import com.xiaotang.springaccount.consumer.StorageClient;
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

    @Autowired
    private StorageClient storageClient;

    public Integer add(Account account){
        return accountMapper.insert(account);
    }

    public Integer update(Account account){
        return accountMapper.updateByPrimaryKeySelective(account);
    }

    @GlobalTransactional
    @Transactional
    public Integer updateTest(Account account, Integer status){
        Integer index = update(account);
        ordersClient.update("a6ee33c562bf46739e59c0353912eefc", "apple23",2223);
        storageClient.update("bc3a5eddb2e146a3b97a5b2e7a40582e", "apple2", 123);
        if(status == 0){
            throw new RuntimeException("hello world");
        }
        return index;
    }

    @GlobalTransactional
    @Transactional(rollbackFor = Exception.class)
    public Integer addTest(Account account, Integer status){

        ordersClient.add("banana", 2, 1, account.getUsername());
        storageClient.add("apple", 3);
        Integer index = add(account);
        if(status == 0){
            throw new RuntimeException("你好世界");
        }
        return index;
    }
}
