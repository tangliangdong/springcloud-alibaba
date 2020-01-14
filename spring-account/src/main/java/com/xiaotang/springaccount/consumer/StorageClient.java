package com.xiaotang.springaccount.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Administrator
 * @data 2020/1/13
 * @time 14:21
 */
@FeignClient("storage-server")
public interface StorageClient {

    @PostMapping("/storage/add")
    Integer add(@RequestParam("goodsName") String goodsName, @RequestParam("num") Integer num);

    @PostMapping("/storage/update")
    Integer update(@RequestParam("uuid") String uuid, @RequestParam("goodsName") String goodsName, @RequestParam("num") Integer num);
}
