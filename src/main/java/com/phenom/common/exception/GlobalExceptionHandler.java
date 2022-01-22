package com.phenom.common.exception;


import com.alibaba.fastjson.JSONObject;
import com.phenom.common.enums.ResultCode;
import org.apache.catalina.connector.ClientAbortException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @description 统一异常处理
 * @author: lsh
 * @create: 2022/1/22
 **/

@RestControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = BizException.class)
    public JSONObject businessExceptionHandler(BizException exception){
        JSONObject jsonObject = new JSONObject();
        logger.info(exception.toString());
        jsonObject.put("code", exception.getCode());
        jsonObject.put("msg", exception.getMessage());
        return jsonObject;
    }

    @ExceptionHandler(value = ClientAbortException.class)
    public JSONObject clientAbortExceptionHandler(ClientAbortException exception){
        JSONObject jsonObject = new JSONObject();
        logger.info(exception.toString());
        jsonObject.put("code", ResultCode.ERROR.getCode());
        jsonObject.put("msg", exception.getMessage());
        return jsonObject;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public JSONObject methodArgumentNotValidException(MethodArgumentNotValidException exception){
        logger.info(exception.toString());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", ResultCode.PARAM_VALIDATE_FAIL.getCode());
        jsonObject.put("msg", getError(exception.getBindingResult()));
        return jsonObject;
    }

    @ExceptionHandler(value = Exception.class)
    public JSONObject otherExceptionHandler(Exception e){
        JSONObject jsonObject = new JSONObject();
        logger.error(e.toString());
        jsonObject.put("code", "E0019S05");
        jsonObject.put("msg", e.getMessage());
        return jsonObject;
    }

    /**
     * 组装参数绑定异常
     * @param result
     * @return
     */
    private String getError(BindingResult result) {
        StringBuilder sb = new StringBuilder();
        List<FieldError> list = result.getFieldErrors();
        for (FieldError error : list) {
            sb.append(error.getDefaultMessage()).append("，");
        }
        String s = sb.toString();
        s = s.substring(0, s.length() - 1) + "！";
        return s;
    }
}
