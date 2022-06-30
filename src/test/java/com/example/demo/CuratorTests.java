package com.example.demo;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author olic
 * @date 2022/6/2814:25
 * @描述 zookeeper客户端
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JedisTests.class)
public class CuratorTests {
    private CuratorFramework client;
    /**
     * 创建连接
     */
    @Before
    @Test
    public void coon(){
        //connectString:多个地址用,隔开; sessionTimeoutMs:会话超时时间; connectionTimeoutMs:连接超时时间; retryPolicy:重试策略
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(3000, 10);
        client = CuratorFrameworkFactory.builder()
                .connectString("127.0.0.1:2181")
                .retryPolicy(retryPolicy)
                .namespace("phenom") //此时phenom就是'/'目录
                .build();
        //开启连接
        client.start();
    }

    /**
     * 释放资源
     */
    @After
    @Test
    public void close(){
       if(client != null){
           client.close();
       }
    }


    /**
     * 创建节点
     */
    @Test
    public void create() throws Exception {
        // 创建节点不指定数据时，默认将当前客户端的ip作为数据存储
        String path = client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/app1/p1", "234".getBytes());
        System.out.println(path);
    }

    /**
     * 查询节点
     */
    @Test
    public void select() throws Exception {
        // 节点值
        byte[] bytes = client.getData().forPath("/app1");
        // 子节点
        List<String> sons = client.getChildren().forPath("/");
        // 节点状态
        Stat stat = new Stat();
        client.getData().storingStatIn(stat);
        System.out.println("子节点列表："+ sons);
        System.out.println("节点值为："+ new String(bytes));
        System.out.println("节点状态："+ stat);
    }

    /**
     * 修改节点
     */
    @Test
    public void update() throws Exception {
        Stat stat = new Stat();
        client.getData().storingStatIn(stat);
        int version = stat.getVersion();
        // 带着版本号去修改，防止查询和修改之间被别的线程操作数据
        client.setData().withVersion(version).forPath("/app1", "iii".getBytes());
    }

    /**
     * 删除节点
     */
    @Test
    public void delete() throws Exception {
        // 删除带有子节点的节点
        client.delete().deletingChildrenIfNeeded().forPath("/app1");
        // 强制删除，一定删除
        client.delete().guaranteed().deletingChildrenIfNeeded().forPath("/app1");
        // 删除回调
        client.delete().inBackground(new BackgroundCallback() {
            @Override
            public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
                System.out.println("已经被删除了");
            }
        });
    }

    /**
     * 给指定的一个节点注册监听器
     */
    @Test
    public void nodeCache() throws Exception {
        // 创建NodeCache对象
        NodeCache cache = new NodeCache(client,"/app1");
        // 注册监听
        cache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                //只要节点增删改此处就会执行
                System.out.println("节点变化了");
                //获取修改节点后的数据
                byte[] data = cache.getCurrentData().getData();
                System.out.println(new String(data));
            }
        });
        // 开启监听
        cache.start();

        //监听需要保证服务未关闭，因为此处是测试方法
        while (true){ }
    }

    /**
     * 监控一个ZNode的子节点
     */
    @Test
    public void pathChildrenCache() throws Exception {
        PathChildrenCache cache = new PathChildrenCache(client, "/app1", false);
        //2、注册监听
        cache.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                System.out.println(event);  //节点变化的信息，内部可直接拿到修改的数据

                //1.获取变化类型
                PathChildrenCacheEvent.Type type = event.getType();
                //2.判断类型
                if (type.equals(PathChildrenCacheEvent.Type.CHILD_UPDATED)){
                    //3.获取变化的数据
                    byte[] data = event.getData().getData();
                    System.out.println(new String(data));
                }

            }
        });
        //3、开启监听
        cache.start();

        //监听需要保证服务未关闭，因为此处是测试方法
        while (true){ }
    }

    /**
     * 监控一个ZNode节点和他的子节点们
     */
    @Test
    public void testTreeCache() throws Exception {
        //1、创建 TreeCache 对象
        //构造器参数：连接客户端对象client、要监听的路径path
        TreeCache cache = new TreeCache(client,"/app4");

        //2、注册监听
        cache.getListenable().addListener(new TreeCacheListener() {
            @Override
            public void childEvent(CuratorFramework client, TreeCacheEvent event) throws Exception {
                System.out.println(event);  //节点变化的信息，内部可直接拿到修改的数据

                //1.获取变化类型
                TreeCacheEvent.Type type = event.getType();
                //2.判断类型
                if (type.equals(TreeCacheEvent.Type.NODE_UPDATED)){
                    //3.获取变化的数据
                    byte[] data = event.getData().getData();
                    System.out.println(new String(data));
                }

            }
        });

        //3、开启监听
        cache.start();

        //监听需要保证服务未关闭，因为此处是测试方法
        while (true){ }
    }

    /**
     * 分布式锁测试
     */
    @Test
    public void lock() throws InterruptedException {
        Ticket12306 ticket12306 = new Ticket12306();

        //创建客户端
        Thread t1 = new Thread(ticket12306, "携程");
        Thread t2 = new Thread(ticket12306, "飞猪");

        t1.start();
        t2.start();
        Thread.sleep(10000);
    }
}
