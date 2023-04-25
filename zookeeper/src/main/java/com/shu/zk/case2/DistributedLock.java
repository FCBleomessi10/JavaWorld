package com.shu.zk.case2;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class DistributedLock {

    private final ZooKeeper zooKeeper;
    private final CountDownLatch countDownLatch = new CountDownLatch(1);
    private final CountDownLatch waitDownLatch = new CountDownLatch(1);
    private String waitPath;
    private String currentMode;

    public DistributedLock() throws IOException, InterruptedException, KeeperException {
        // 获取连接
        String connectString = "139.196.149.231:2181";
        int sessionTimeout = 2000;
        zooKeeper = new ZooKeeper(connectString, sessionTimeout, watchedEvent -> {
            // 连接上zk, 释放connectLatch
            if (watchedEvent.getState() == Watcher.Event.KeeperState.SyncConnected) {
                countDownLatch.countDown();
            }

            // 释放waitLatch
            if (watchedEvent.getType() == Watcher.Event.EventType.NodeDeleted && watchedEvent.getPath().equals(waitPath)) {
                waitDownLatch.countDown();
            }
        });
        countDownLatch.await();

        // 判断根节点/locks是否存在
        Stat stat = zooKeeper.exists("/locks", false);
        if (stat == null) {
            zooKeeper.create("/locks", "locks".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
    }

    public void zkLock() {
        // 创建对应的临时带序号节点
        try {
            currentMode = zooKeeper.create("/locks/" + "seq-", null,
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

            // 判断创建的节点是否是最小的序号节点，如果是获取到锁；如果不是，监听他序号前一个节点
            List<String> children = zooKeeper.getChildren("/locks", false);
            if (children.size() != 1) {
                Collections.sort(children);
                String thisNode = currentMode.substring("/locks/".length());
                int idx = children.indexOf(thisNode);

                if (idx == -1) {
                    System.out.println("数据异常");
                } else if (idx != 0) {
                    waitPath = "/locks/" + children.get(idx - 1);
                    zooKeeper.getData(waitPath, true, null);
                    waitDownLatch.await();
                }
            }
        } catch (KeeperException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void unZkLock() {
        // 删除节点
        try {
            zooKeeper.delete(currentMode, -1);
        } catch (InterruptedException | KeeperException e) {
            throw new RuntimeException(e);
        }
    }
}
