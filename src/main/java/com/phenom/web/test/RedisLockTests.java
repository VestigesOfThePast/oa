package com.phenom.web.test;

import com.phenom.common.utils.RedisCacheUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author olic
 * @date 2022/5/2218:04
 */
@Slf4j
@RestController
@RequestMapping("/redisLock")
public class RedisLockTests {

    @Resource
    private RedisCacheUtil redisCache;

    class Windows implements Runnable{
        @Override
        public void run() {
            for(int i=0; i<20; i++) {
                String lockUUID = UUID.randomUUID().toString().replace("-", "");
                boolean flag = redisCache.setCacheObjectIfAbsent("lock", lockUUID, 5, TimeUnit.SECONDS);
                try {
                    if (flag) {
                        redisCache.increment("num", 1);
                        log.info(Thread.currentThread().getName() + "打印num值为：" + redisCache.getCacheObject("num"));
                        // 释放锁。比较判断uuid是否一样，保证释放的是自己的锁
                        if (lockUUID.equals(redisCache.getCacheObject("lock"))) {
                            redisCache.deleteObject("lock");
                        }
                    }
                } catch (Exception e) {
                    // 释放锁。比较判断uuid是否一样，保证释放的是自己的锁
                    if (lockUUID.equals(redisCache.getCacheObject("lock"))) {
                        redisCache.deleteObject("lock");
                    }
                }
            }
        }
    }

    @GetMapping("/testRedisLock")
    public void testRedisLock() {
        Windows windows = new Windows();
        Thread t1 = new Thread(windows);
        Thread t2 = new Thread(windows);
        Thread t3 = new Thread(windows);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
