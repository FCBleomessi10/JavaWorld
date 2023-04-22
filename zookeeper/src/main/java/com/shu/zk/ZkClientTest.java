package com.shu.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ZkClientTest {
    private ZooKeeper zkClient;

    @Before
    public void init() throws IOException {
        String connectString = "139.196.149.231:2181";
        int sessionTimeout = 2000;
        zkClient = new ZooKeeper(connectString, sessionTimeout, watchedEvent -> {
            List<String> children;
            try {
                children = zkClient.getChildren("/", true);
            } catch (KeeperException | InterruptedException e) {
                throw new RuntimeException(e);
            }

            for (String child : children) {
                System.out.println(child);
            }
        });
    }

    @Test
    public void create() throws InterruptedException, KeeperException {
        String path = "/shu";
        String data = "shu.avi";
        String nodeCreated = zkClient.create(path, data.getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    @Test
    public void getChildren() throws InterruptedException, KeeperException {
        String path = "/";
        boolean watch = true;
        List<String> children = zkClient.getChildren(path, watch);

        for (String child : children) {
            System.out.println(child);
        }
        Thread.sleep(Long.MAX_VALUE);
    }

    @Test
    public void exist() throws Exception {
        String path = "/shu";
        boolean watch = true;
        Stat stat = zkClient.exists(path, watch);
        System.out.println(stat == null ? "not exist" : "exist");
    }
}
