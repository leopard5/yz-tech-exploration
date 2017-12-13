package com.yz.jvm.thread.condition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ConditionPrintTest {

    static class NumberWrapper {
        public int value = 1;
    }

    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        //初始化可重入锁
        final Lock lock = new ReentrantLock();

        //第一个条件当屏幕上输出到3
        final Condition reachThreeCondition = lock.newCondition();
        //第二个条件当屏幕上输出到6
        final Condition reachSixCondition = lock.newCondition();

        //NumberWrapper只是为了封装一个数字，一边可以将数字对象共享，并可以设置为final
        //注意这里不要用Integer, Integer 是不可变对象
        final NumberWrapper num = new NumberWrapper();

        cachedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                //需要先获得锁
                lock.lock();
                try {
                    System.out.println("threadA start write");
                    //A线程先输出前3个数
                    while (num.value <= 3) {
                        System.out.println(num.value);
                        num.value++;
                    }
                    //输出到3时要signal，告诉B线程可以开始了
                    reachThreeCondition.signal();
                } finally {
                    lock.unlock();
                }
                lock.lock();
                try {
                    //等待输出6的条件
                    reachSixCondition.await();
                    System.out.println("threadA start write");
                    //输出剩余数字
                    while (num.value <= 9) {
                        System.out.println(num.value);
                        num.value++;
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        });


        cachedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();

                    while (num.value <= 3) {
                        //等待3输出完毕的信号
                        reachThreeCondition.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                try {
                    lock.lock();
                    //已经收到信号，开始输出4，5，6
                    System.out.println("threadB start write");
                    while (num.value <= 6) {
                        System.out.println(num.value);
                        num.value++;
                    }
                    //4，5，6输出完毕，告诉A线程6输出完了
                    reachSixCondition.signal();
                } finally {
                    lock.unlock();
                }
            }

        });
    }
}
