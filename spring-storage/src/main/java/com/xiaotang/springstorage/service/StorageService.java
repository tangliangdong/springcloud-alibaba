package com.xiaotang.springstorage.service;

import com.xiaotang.springstorage.dao.StorageMapper;
import com.xiaotang.springstorage.model.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 * @data 2020/1/13
 * @time 14:17
 */
@Service
public class StorageService {

    @Autowired
    private StorageMapper storageMapper;

    @Transactional
    public Integer add(Storage storage){
        Integer index = storageMapper.insert(storage);
//        throw new RuntimeException();
        return index;
    }

    @Transactional
    public Integer update(Storage storage){
        Integer index = storageMapper.updateByPrimaryKeySelective(storage);
//        throw new RuntimeException();
        return index;
    }
}
