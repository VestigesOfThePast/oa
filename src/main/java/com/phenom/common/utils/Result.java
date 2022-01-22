package com.phenom.common.utils;


import com.alibaba.fastjson.JSON;
import com.phenom.common.enums.ResultCode;

/**
 * api响应数据对象
 * @param <T>
 * @author lsh
 */
public class Result<T> {

    private String code;
    private String msg;
    private T      data;

    public static <T> Result<T> success(T data) {
        Result<T> rtn = new Result<T>();
        // rtn.setCode("200");
        rtn.setCode(ResultCode.SUCCESS.getCode());
        rtn.setMsg("SUCCESS");
        rtn.setData(data);
        return rtn;
    }

    public static <T> Result<T> fail(String desc) {
        return fail(desc, null);
    }

    public static <T> Result<T> fail(String desc, T data) {
        Result<T> rtn = new Result<T>();
        // rtn.setCode("E00002");
        rtn.setCode(ResultCode.FAIL.getCode());
        rtn.setMsg(desc);
        rtn.setData(data);
        return rtn;
    }

    public static <T> Result<T> fail(String code, String desc, T data) {
        Result<T> rtn = new Result<T>();
        if(code == null || code.equals(ResultCode.SUCCESS.getCode())){
            code = ResultCode.FAIL.getCode();
        }
        rtn.setCode(code);
        rtn.setMsg(desc);
        rtn.setData(data);
        return rtn;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
