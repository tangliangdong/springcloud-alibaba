package com.xiaotang.springorder2.controller;

import com.xiaotang.springorder2.model.Storage;
import com.xiaotang.springorder2.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @data 2020/1/13
 * @time 14:16
 */
@RestController
@RequestMapping("storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping("add")
    public Integer add(String goodsName, Integer num){
        Storage storage = new Storage();
        storage.setGoodsName(goodsName);
        storage.setNum(num);
        return storageService.add(storage);
    }

    @PostMapping("update")
    public Integer update(String uuid, String goodsName, Integer num){
        Storage storage = new Storage();
        storage.setUuid(uuid);
        storage.setGoodsName(goodsName);
        storage.setNum(num);
        return storageService.update(storage);
    }
}
