package com.xiaotang.springstorage.dao;

import com.xiaotang.springstorage.model.Storage;

public interface StorageMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Storage record);

    int insertSelective(Storage record);

    Storage selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);
}