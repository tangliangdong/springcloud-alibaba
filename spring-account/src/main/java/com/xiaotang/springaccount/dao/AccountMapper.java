package com.xiaotang.springaccount.dao;

import com.xiaotang.springaccount.model.Account;

public interface AccountMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}