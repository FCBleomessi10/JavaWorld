package com.shu.zk.case2;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;

public class DistributedLockTest {
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        final DistributedLock lock1 = new DistributedLock();
        final DistributedLock lock2 = new DistributedLock();
        new Thread(() -> {
            try {
                lock1.zkLock();
                System.out.println(Thread.currentThread().getName() + ": get the lock");
                Thread.sleep(5 * 1000);
                lock1.unZkLock();
                System.out.println(Thread.currentThread().getName() + ": release the lock");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                lock2.zkLock();
                System.out.println(Thread.currentThread().getName() + ": get the lock");
                Thread.sleep(5 * 1000);
                lock2.unZkLock();
                System.out.println(Thread.currentThread().getName() + ": release the lock");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
