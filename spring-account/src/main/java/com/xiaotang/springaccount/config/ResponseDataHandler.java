package com.xiaotang.springaccount.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaotang.springaccount.dto.ResponseBodyDTO;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author Administrator
 * @data 2020/1/15
 * @time 15:25
 */
@ControllerAdvice
public class ResponseDataHandler implements ResponseBodyAdvice {


    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
//        if (body instanceof String) {
//            return new ResponseBodyDTO(body);
//        }
//        if(body == null){
//            return new ResponseBodyDTO("");
//        }
        if(! (body instanceof ResponseBodyDTO)){
            ResponseBodyDTO responseBodyDTO = new ResponseBodyDTO();
            responseBodyDTO.setCode(200);
            responseBodyDTO.setMsg("操作成功");
            responseBodyDTO.setSuccess(true);
//            body = body ==null ? "":body;
            responseBodyDTO.setResult(body);
            body = responseBodyDTO;
        }

        return body;
    }
}
