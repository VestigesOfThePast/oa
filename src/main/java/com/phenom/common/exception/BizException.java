package com.phenom.common.exception;

/**
 * @description 业务异常定义
 * @author: lsh
 * @create: 2022/1/22
 **/
public class BizException extends RuntimeException {

    private static final long serialVersionUID = -4841089165626408293L;
    /** 编码 **/
    private String code;
    /** 描述 **/
    private String msg;

    public BizException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;

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
}