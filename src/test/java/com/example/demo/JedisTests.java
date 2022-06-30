package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * @author olic
 * @date 2022/6/2814:25
 * @描述 Redis客户端
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JedisTests.class)
public class JedisTests {

    @Test
    public void conn(){
        //连接redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println(jedis.ping());
    }

    @Test
    public void key(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        Set<String> keys = jedis.keys("*");
        Set<String> key2 = jedis.keys("k?");
        Boolean k1 = jedis.exists("k1");
        Long k11 = jedis.ttl("k1");
        String k12 = jedis.get("k1");
    }

    @Test
    public void string(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.mset("k11", "11", "k22","22");
        List<String> mget = jedis.mget("k11", "k22");
    }

    @Test
    public void list(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.lpush("kl", "6","5","4","2","3","4");
        List<String> kl = jedis.lrange("kl", 0, -1);
    }

    @Test
    public void set(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.sadd("ks", "22", "33", "44");
        Set<String> ks = jedis.smembers("ks");
    }

    @Test
    public void zset(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.zadd("kz", 1, "11");
        jedis.zadd("kz", 3, "33");
        jedis.zadd("kz", 2, "22");
        Set<String> kz = jedis.zrange("kz", 0, -1);
    }

    @Test
    public void hash(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.hset("kh","name","olic");
        String hget = jedis.hget("kh", "name");
    }
}
