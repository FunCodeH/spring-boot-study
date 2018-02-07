package com.funcodeh.shiro.demo.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Function: TODO: ADD FUNCTION <br>
 *
 * @Author: funcodeh <br>
 * @Date: 2018-02-07 下午2:45
 */
public class ResultDto {

    /**
     * 返回的错误信息，默认为空表示接口正常处理
     */
    private String msg = "";

    /**
     * 返回的业务数据
     */
    private Object data;

    public ResultDto(){}

    public ResultDto(String msg, Object data) {
        this.msg = msg;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
