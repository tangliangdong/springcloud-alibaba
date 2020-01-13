package com.xiaotang.springstorage.model;

import com.xiaotang.commonpart.annotation.CreateTime;
import com.xiaotang.commonpart.annotation.UUID;
import com.xiaotang.commonpart.annotation.UpdateTime;

import java.util.Date;

public class Storage {
    @UUID
    private String uuid;

    private String goodsName;

    private Integer num;

    private Short status;

    @CreateTime
    private Date ctime;
    @UpdateTime
    private Date utime;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }
}