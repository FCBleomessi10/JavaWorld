package com.shu.zk.case1;

import org.apache.zookeeper.*;

import java.io.IOException;

public class DistributeServer {
    private String connectString = "139.196.149.231:2181";
    private int sessionTimeout = 2000;
    private ZooKeeper zooKeeper;

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        DistributeServer server = new DistributeServer();

        // 1. 获取zk连接
        server.getConnection();

        // 2. 在zk上创建ZNode
        server.register(args[0]);

        // 3. 执行业务逻辑
        server.doBusiness();

    }

    private void doBusiness() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }

    private void register(String hostname) throws InterruptedException, KeeperException {
        String s = zooKeeper.create("/servers/" + hostname, hostname.getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(s + " is online!");
    }

    private void getConnection() throws IOException {
        zooKeeper = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }
}
