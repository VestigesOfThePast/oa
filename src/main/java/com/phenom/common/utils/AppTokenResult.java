package com.phenom.common.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppTokenResult {

    private Integer code;

    private String msg;

    private String token;

    private Long expires;

    public static AppTokenResult success(String token, Long expires){
        return new AppTokenResult(0,"success",token,expires);
    }

    public static AppTokenResult failed(String msg){
        return new AppTokenResult(-1,msg,null,null);
    }
}