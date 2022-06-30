package com.example.demo;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.TimeUnit;

/**
 * @author olic
 * @date 2022/6/2918:57
 */
public class Ticket12306 implements Runnable{
    private int ticket = 10;  //数据库票数
    private InterProcessMutex lock;

    public Ticket12306() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(3000,10);
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString("127.0.0.1:2181")
                .sessionTimeoutMs(60*1000)
                .connectionTimeoutMs(15*1000)
                .retryPolicy(retryPolicy)
                .build();
        client.start();
        //第一个参数是客户端连接对象，第二个参数是要监控的锁节点
        lock = new InterProcessMutex(client,"/lock");
    }

    @Override
    public void run() {
        while (true){
            try {
                //获取锁
                lock.acquire(3, TimeUnit.SECONDS);  //参数指明没拿到锁要等多久
                if (ticket > 0){
                    System.out.println(Thread.currentThread() + "==" + ticket);
                    ticket--;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //释放锁
                try {
                    lock.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
