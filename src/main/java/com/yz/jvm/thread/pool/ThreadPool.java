package com.yz.jvm.thread.pool;

import java.time.LocalTime;
import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args) {
        cachedThreadPool();
        fixedThreadPool();
        customThreadPool();
        scheduledThreadPool();
        newWorkStealingPool();
    }

    private static void cachedThreadPool() {
        ExecutorService pool = null;
        try {
            pool = Executors.newCachedThreadPool();
            for (int i = 0; i < 8; i++) {
                int finalI = i + 1;
                pool.submit(() -> {
                    try {
                        System.out.println("任务" + finalI + ":开始等待60秒,时间:" + LocalTime.now() + ",当前线程名：" + Thread.currentThread().getName());
                        Thread.sleep(6000);
                        System.out.println("任务" + finalI + ":结束等待60秒,时间:" + LocalTime.now() + ",当前线程名：" + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                //睡眠10秒
                Thread.sleep(10000);
            }
            pool.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }

    private static void fixedThreadPool() {
        ExecutorService pool = null;
        pool = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 8; i++) {
            int finalI = i + 1;
            pool.submit(() -> {
                try {
                    System.out.println("任务" + finalI + ":开始等待2秒,时间:" + LocalTime.now() + ",当前线程名：" + Thread.currentThread().getName());
                    Thread.sleep(2000);
                    System.out.println("任务" + finalI + ":结束等待2秒,时间:" + LocalTime.now() + ",当前线程名：" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }
        pool.shutdown();
    }

    private static void customThreadPool() {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                1,        //coreSize
                2,      //MaxSize
                60,      //60
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3)            //指定一种队列 （有界队列）
        );
    }

    private static void scheduledThreadPool() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        //延迟5秒后调用
        pool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("调用schedule方法");
            }
        }, 5, TimeUnit.SECONDS);

        //
        pool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("调用scheduleAtFixedRate方法");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 5, 2, TimeUnit.SECONDS);

        pool.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("调用scheduleWithFixedDelay方法");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 5, 2, TimeUnit.SECONDS);


    }

    private static void newWorkStealingPool() {
        ExecutorService pool = Executors.newWorkStealingPool();
    }
}
