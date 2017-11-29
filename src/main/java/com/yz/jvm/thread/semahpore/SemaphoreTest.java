package com.yz.jvm.thread.semahpore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore can be counted, while mutex can only count to 1.
 * <p>
 * 　　Suppose you have a thread running which accepts client connections. This thread can handle 10 clients simultaneously.
 * Then each new client sets the semaphore until it reaches 10.
 * When the Semaphore has 10 flags, then your thread won't accept new connections
 * <p>
 * 　　Mutex are usually used for guarding stuff. Suppose your 10 clients can access multiple parts of the system.
 * Then you can protect a part of the system with a mutex so when 1 client is connected to that sub-system,
 * no one else should have access. You can use a Semaphore for this purpose too. A mutex is a "Mutual Exclusion Semaphore".
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        // 线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        // 只能5个线程同时访问
        final Semaphore semp = new Semaphore(5);
        // 模拟20个客户端访问
        for (int index = 0; index < 50; index++) {
            final int NO = index;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        // 获取许可
                        semp.acquire();
                        System.out.println("Accessing: " + NO);
                        Thread.sleep((long) (Math.random() * 10000));
                        // 访问完后，释放
                        semp.release();
                        // availablePermits()指的是当前信号灯库中有多少个可以被使用
                        System.out.println("-----------------"
                                + semp.availablePermits());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(run);
        }
        // 退出线程池
        exec.shutdown();
    }
}
