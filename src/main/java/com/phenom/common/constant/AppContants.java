package com.phenom.common.constant;

/**
 * @author olic
 * @date 2022/3/14:04 下午
 */
public class AppContants {
    /**
     * 令牌
     */
    public static final String LOGIN_USER_TOKEN = "login_user_token_test";

    /**
     * 手机验证码
     */
    /** 过期时间 */
    public static final long PHONE_CODE_EXPIRE = 10;
    /** key前缀 */
    public static final String PHONE_CODE_KEY_PREFIX = "phone:code:";

    /**
     * ip
     */
    /** 保护模式key(验证码) */
    public static final String IP_PROTECT_CODE_KEY = "phone:code:";
    /** 保护模式过期时间(验证码) */
    public static final long IP_PROTECT_CODE_EXPIRE = 5;
    /** 锁定ip(验证码) */
    public static final String IP_LOCK_CODE_KEY = "phone:code:lock";
    /** 锁定ip过期时间(验证码) */
    public static final long IP_LOCK_CODE_EXPIRE = 12;

}
