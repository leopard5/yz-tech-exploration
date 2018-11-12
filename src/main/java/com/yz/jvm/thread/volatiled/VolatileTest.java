package com.yz.jvm.thread.volatiled;

import java.util.concurrent.CountDownLatch;

public class VolatileTest {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        CountDownLatch downLatch = new CountDownLatch(10);
        VolatileTest test = new VolatileTest();
        try {
            for (int i = 0; i < 10; i++) {
                Thread threadTemp = new Thread(new ThreadTest(test, downLatch));
                threadTemp.start();
            }
            downLatch.await();
            System.out.println(test.inc);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class ThreadTest implements Runnable {
        private VolatileTest v1;
        private CountDownLatch v2;

        ThreadTest(VolatileTest v1, CountDownLatch v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                v1.increase();
            }
            v2.countDown();
        }
    }
}
