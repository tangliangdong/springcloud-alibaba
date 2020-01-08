package com.xiaotang.springaccount.service;

import com.xiaotang.springaccount.dao.AccountMapper;
import com.xiaotang.springaccount.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @data 2020/1/8
 * @time 16:09
 */
@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public Integer add(Account account){
        return accountMapper.insert(account);
    }
}
