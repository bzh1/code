package com.atguigu;

import lombok.Getter;
import lombok.Setter;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.proto.DeleteRequest;

import java.io.IOException;

public class ZooKeeperDemo {
    private static final String CONNECT_STRING="192.168.144.144:2191";
    private static final int SESSION_TIMEOUT=20*1000;
    private static final String PATH = "/atguigu";
    @Setter@Getter
    private ZooKeeper zooKeeper;
    //获取连接
    public ZooKeeper startZK() throws IOException {
        //String connectString, int sessionTimeout, Watcher watcher
        return new ZooKeeper(CONNECT_STRING, SESSION_TIMEOUT, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }

    //关闭资源
    public void closeZK(ZooKeeper zooKeeper) throws InterruptedException {

        if (null != zooKeeper) {
            zooKeeper.close();
        }
    }

    //增          ACL安全架构，类似于防火墙
    public void createZnode(String path,String data) throws KeeperException, InterruptedException {

        zooKeeper.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

    }

    //查
    public String getZnode(String path) throws KeeperException, InterruptedException {

        String result="";
        byte[] bytes = zooKeeper.getData(path, false, new Stat());
        result = new String(bytes);
        return result;
    }

    //删
    public void deleteZnode(String path, int version) throws KeeperException, InterruptedException {

        zooKeeper.delete(path,version);
    }

    //改
    public void setZnode(String path,String data,int version) throws KeeperException, InterruptedException {

        zooKeeper.setData(path, data.getBytes(), version);
    }

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeperDemo zooKeeperDemo = new ZooKeeperDemo();

        ZooKeeper zooKeeper = zooKeeperDemo.startZK();

        Stat stat = zooKeeper.exists(PATH, false);

        if (null == stat) {
            zooKeeperDemo.setZooKeeper(zooKeeper);

            zooKeeperDemo.createZnode(PATH, "java0222");

            zooKeeperDemo.setZnode(PATH,"hellojava",1);

            zooKeeperDemo.deleteZnode(PATH,1);

            System.out.println("**********result \t" + zooKeeperDemo.getZnode(PATH));
        } else {

            System.out.println("***********this node is already exists");
        }

        zooKeeperDemo.closeZK(zooKeeper);
    }
}
