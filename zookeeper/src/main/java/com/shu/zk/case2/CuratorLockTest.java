package com.shu.zk.case2;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class CuratorLockTest {
    public static void main(String[] args) {
        InterProcessMutex lock1 = new InterProcessMutex(getCuratorFramework(), "/locks");
        InterProcessMutex lock2 = new InterProcessMutex(getCuratorFramework(), "/locks");

        new Thread(() -> {
            try {
                lock1.acquire();
                System.out.println(Thread.currentThread().getName() + ": get the lock");
                lock1.acquire();
                System.out.println(Thread.currentThread().getName() + ": get the lock again");

                Thread.sleep(5 * 1000);

                lock1.release();
                System.out.println(Thread.currentThread().getName() + ": release the lock");
                lock1.release();
                System.out.println(Thread.currentThread().getName() + ": release the lock again");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                lock2.acquire();
                System.out.println(Thread.currentThread().getName() + ": get the lock");
                lock2.acquire();
                System.out.println(Thread.currentThread().getName() + ": get the lock again");
                Thread.sleep(5 * 1000);
                lock2.release();
                System.out.println(Thread.currentThread().getName() + ": release the lock");
                lock2.release();
                System.out.println(Thread.currentThread().getName() + ": release the lock again");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    private static CuratorFramework getCuratorFramework() {
        ExponentialBackoffRetry policy = new ExponentialBackoffRetry(3000, 3);
        CuratorFramework client = CuratorFrameworkFactory.builder().connectString("139.196.149.231:2181")
                .connectionTimeoutMs(2000)
                .sessionTimeoutMs(2000)
                .retryPolicy(policy).build();
        client.start();
        System.out.println("zookeeper 启动成功");
        return client;
    }
}
