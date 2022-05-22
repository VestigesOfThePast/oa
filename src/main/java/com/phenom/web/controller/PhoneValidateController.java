package com.phenom.web.controller;

import com.phenom.common.constant.AppContants;
import com.phenom.common.utils.IpUtil;
import com.phenom.common.utils.RedisCacheUtil;
import com.phenom.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/**
 * @author olic
 * @date 2022/5/2214:33
 */
@Slf4j
@RestController
@RequestMapping("/phoneValidate")
public class PhoneValidateController {

    @Resource
    private RedisCacheUtil redisCache;
    @Value("${xxl.job.executor.ipPrefix}")
    private String ipPrefix;

    /**
     * 生成手机验证码
     * @return
     */
    public String generatorCode(){
        return String.valueOf((int)(Math.random()*10000));
    }

    /**
     * 获得当前IP地址
     * @return
     */
    private String getLocalIpAddress() {
        HashSet<String> localAddressList = IpUtil.getLocalAddressList();
        String address = IpUtil.getLocalAddress().getHostAddress();
        for (String addr : localAddressList) {
            if (StringUtils.startsWithIgnoreCase(addr, ipPrefix)) {
                address = addr;
                break;
            }
        }
        return address;
    }

    /**
     * 保护模式
     * 生成保护的key key=phone:code:ip
     * 如果不存在，进行+1，并设置过期时间5分钟
     * 如果存在，进行+1
     * 判断保护key的值是否大于3，大于3时生成IPLOCKKEY phone:code:lock:ip 过期时间为12小时
     * @return
     */
    public boolean protectPhoneCode(){
        String ip = getLocalIpAddress();
        String protectKey = AppContants.IP_PROTECT_CODE_KEY+ip;
        // 全局判断
        if(redisCache.hasKey(AppContants.IP_LOCK_CODE_KEY+ip)){
            return false;
        }
        if(redisCache.hasKey(protectKey)){
            redisCache.increment(protectKey, 1);
        }else{
            redisCache.increment(protectKey, 1);
            redisCache.expire(protectKey, AppContants.IP_PROTECT_CODE_EXPIRE, TimeUnit.MINUTES);
        }
        if((int)redisCache.getCacheObject(protectKey) > 3){
            //IP被锁定12小时
            String lockKey = AppContants.IP_LOCK_CODE_KEY+ip;
            redisCache.setCacheObject(lockKey, ip);
            redisCache.expire(lockKey, 12, TimeUnit.HOURS);
            return false;
        }
        return true;
    }

    /**
     * 获取验证码
     * 根据用户输入的手机号 生成对应的key key=phone:code:手机号码
     * key不存在时对key进行赋值并设置过期时间60s
     * key存在时，提示：验证码还在有效期内(已发送，请查看手机)
     * @param phoneNumber 手机号码
     * @return
     */
    @GetMapping("/getValidateCode")
    public Result<String> getValidateCode(@RequestParam("phoneNumber") String phoneNumber){
        String key=AppContants.PHONE_CODE_KEY_PREFIX+phoneNumber;
        String phoneCode = null;
        String ip = getLocalIpAddress();
        boolean flag = protectPhoneCode();
        if(!flag) {
            Long remainTime = redisCache.getExpire(AppContants.IP_LOCK_CODE_KEY + ip);
            return Result.fail("已被系统限制访问，还剩时间：" + remainTime);
        }
        // 判断用户验证码是否存在
        if(redisCache.hasKey(key)){
            Long remainTime = redisCache.getExpire(key);
            phoneCode = redisCache.getCacheObject(key);
            return Result.fail("验证码还在有效期内，请避免重复发送，还剩时间："+remainTime, phoneCode);
        }else{
            phoneCode = generatorCode();
            log.info("手机号验证码已发送Api短信接口，验证码是：" + phoneCode);
            redisCache.setCacheObject(key, phoneCode, AppContants.PHONE_CODE_EXPIRE, TimeUnit.SECONDS);
            return Result.success("验证码发送成功，请查看手机短信");
        }
    }

    /**
     * 登录验证码校验
     * 将前台输入的验证码的信息和redis中的值进行比较
     * 比较成功，验证通过
     * 比较失败，错误提示
     * @param code 手机验证码
     * @param phoneNumber 手机号码
     * @return
     */
    @GetMapping("/validate")
    public Result<String> validate(@RequestParam("code") String code, @RequestParam("phoneNumber") String phoneNumber){
        String key=AppContants.PHONE_CODE_KEY_PREFIX+phoneNumber;
        if(code.equals(redisCache.getCacheObject(key))){
            log.info("手机号码校验成功，执行登录相应业务");
            //清空redis中相应的key
            redisCache.deleteObject(key);
            return Result.success("登录成功");
        }else{
            return Result.fail("验证码校验失败");
        }
    }
}
