package com.phenom.common.enums;

import com.phenom.common.error.IErrorCode;

/**
 * 枚举了一些常用API操作码
 * Created by root on 2022/1/22.
 */
public enum ResultCode implements IErrorCode {
    /**
     * 操作成功
     */
    SUCCESS("200", "操作成功"),

    //用户 U
    /**
     * 没有访问系统的权限
     */
    ACCOUNT_NOTEXIST("402","您的账号没有当前访问系统的权限，请联系管理员处理!"),
    /**
     * 租户编码或token错误
     */
    UNAUTHORIZED("401", "租户编码或token错误!"),
    /**
     * 登录状态已过期
     */
    UNAUTHORIZED2("401", "登录状态已过期,请重新登录!"),
    /**
     * 手机号不能为空
     */
    USERNAME_OR_PHONE("U00005", "用户名或者手机号不能为空"),
    /**
     * 密码不一致
     */
    TWO_PASSWORDS_INCONSISTENT("U00006", "两次密码不一致"),
    /**
     * 用户名或者密码不为空
     */
    USERNAME_OR_PASSWORD("U00007", "用户名或者密码不为空"),
    /**
     * 重置密码失败
     */
    RESETPASSWORD_FAIL("U00008", "重置密码失败"),
    /**
     * 密码不为空
     */
    PASSWORD_ISNULL("U00009", "密码不为空"),
    /**
     * 用户信息不为空
     */
    USERNAME_OR_NICKNAME_IDNUMBER_MOBILEPHONE("U00010", "用户名并且姓名并且身份证号并且手机号并且手机验证码不为空"),
    /**
     * 忘记密码参数不为空
     */
    FORGETPASSWORD_PARMISNULL("U00011", "忘记密码参数不为空"),
    /**
     * 密码格式错误
     */
    PASSWORD_CHECK("U00012","密码格式错误"),
    /**
     * 手机号不正确
     */
    PHONE_ERROR("U00013", "请输入正确的手机号码"),
    /**
     * 身份证号不正确
     */
    IDNUM_ERROR("U00014", "请输入正确的身份证号码"),
    /**
     * 用户名错误
     */
    NAME_ERROR("U00015", "用户名不允许带有数字"),
    /**
     * 旧密码错误
     */
    OLD_PASSWORD_ERROR("U00016", "旧密码错误"),
    /**
     * 旧密码或者新密码或者第二次密码为空
     */
    OLDPASSWORD_OR_NEWPASSWORD_RESETPASSWORD_ISNULL("U00017", "旧密码或者新密码或者第二次密码为空"),
    /**
     * 手机号码不存在
     */
    PHONECODE_ISNULL("U00018", "该手机号码不存在"),
    /**
     * 手机号或者验证码或者新手机号为空
     */
    PHONECODE_OR_NEWPHONE_ISNULL("U00019", "手机号或者验证码或者新手机号为空"),
    /**
     * 手机验证码校验失败
     */
    PHONE_VERIFYCODE_CHECK_FAIL("U00020", "手机验证码校验失败"),

    //异常 E
    /**
     * 系统错误
     */
    ERROR("E00001","系统错误"),
    /**
     * 操作失败
     */
    FAIL("E00002", "操作失败"),
    /**
     * 发送短信失败
     */
    SENDMESSAGE_ISFAILD("E00003", "发送短信失败"),
    /**
     * 上传图片失败
     */
    UPLODE_FAILED("E00004", "上传图片失败"),
    /**
     * 系统繁忙
     */
    SYSTEM_ERROR("E00005", "系统繁忙，请稍后重试"),
    /**
     * 没有相关权限
     */
    FORBIDDEN("E00006", "没有相关权限"),
    /**
     * 获取锁失败
     */
    LOOK_GET_ERROR("E00007","获取锁失败"),

    //参数 P
    /**
     * 参数检验失败
     */
    PARAM_VALIDATE_FAIL("P00001", "参数检验失败");

    private String code;
    private String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
