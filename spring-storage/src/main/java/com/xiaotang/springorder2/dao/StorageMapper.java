package com.xiaotang.springorder2.dao;

import com.xiaotang.springorder2.model.Storage;

public interface StorageMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Storage record);

    int insertSelective(Storage record);

    Storage selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);
}