package com.xiaotang.springaccount.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Administrator
 * @data 2020/1/15
 * @time 15:26
 */
@Getter
@Setter
public class ResponseBodyDTO {
    private String msg;
    private Integer code;
    private Object result;
    private Boolean success;

    public ResponseBodyDTO(Object result) {
        this.code = 200;
        this.success = true;
        this.msg = "操作成功";
        this.result = result;
    }

    public ResponseBodyDTO(){}

}
