package com.xiaotang.springaccount.model;

import com.xiaotang.commonpart.annotation.CreateTime;
import com.xiaotang.commonpart.annotation.UUID;
import com.xiaotang.commonpart.annotation.UpdateTime;

import java.util.Date;

public class Account {
    @UUID
    private String uuid;

    private String username;

    private String password;

    private String money;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
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