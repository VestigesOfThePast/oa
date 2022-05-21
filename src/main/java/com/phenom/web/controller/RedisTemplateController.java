package com.phenom.web.controller;

import com.phenom.web.domain.SysEmployee;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author olic
 * @date 2022/4/2812:06 上午
 */
@RestController
@RequestMapping("/redisTest")
public class RedisTemplateController {

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping(value = "/string")
    public void string() {
        Map m = new HashMap();
        m.put("name","jack");
        m.put("age", 18);
        redisTemplate.opsForValue().set("ks",m);
        redisTemplate.opsForValue().get("ks");

        // 会使用设置的序列化方式。此时，对象不需要序列化
        SysEmployee sysEmployee = new SysEmployee();
        sysEmployee.setOrgName("org");
        sysEmployee.setEmpName("xx");
        redisTemplate.opsForValue().set("ks2",sysEmployee);
        SysEmployee sysEmployee2 = (SysEmployee)redisTemplate.opsForValue().get("ks2");
        System.out.println(sysEmployee2.getOrgName());
    }

    @GetMapping(value = "/hash")
    public void hash(){
        // 单次操作
        redisTemplate.opsForHash().put("kh", "name","olic");
        redisTemplate.opsForHash().put("kh", "age",20);

        // 批量操作
        Map m = new HashMap();
        m.put("name","jack");
        m.put("age", 18);
        redisTemplate.opsForHash().putAll("user:p1", m);
        Collection c = new ArrayList();
        c.add("name");
        c.add("age");
        List list = redisTemplate.opsForHash().multiGet("user:p1", c);
        System.out.println(list);

    }

    @GetMapping(value = "/list")
    public void list(){
        // 单个操作
        redisTemplate.opsForList().leftPush("kl","name");
        redisTemplate.opsForList().leftPush("kl","age");

        // 批量操作
        Collection c = new ArrayList();
        c.add("name");
        c.add("age");
        redisTemplate.opsForList().leftPushAll("kl2",c);
    }
}
