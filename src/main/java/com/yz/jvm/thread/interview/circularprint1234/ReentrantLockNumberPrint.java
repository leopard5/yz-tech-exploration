package com.yz.jvm.thread.interview.circularprint1234;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockNumberPrint {
    private static Lock lock = new ReentrantLock();
    private static int count = 1;

    public static void main(String[] args) {
        new Thread(new OneThread()).start();
        new Thread(new SencondThread()).start();
        new Thread(new ThirdThread()).start();
        new Thread(new FourThread()).start();
    }

    static class OneThread implements Runnable {
        @Override
        public void run() {
            while (true && !Thread.interrupted()) {
                lock.lock();
                if (count % 4 == 1) {
                    System.out.println(1);
                    count++;
                }
                lock.unlock();
            }

        }
    }

    static class SencondThread implements Runnable {

        @Override
        public void run() {
            while (true && !Thread.interrupted()) {
                lock.lock();
                if (count % 4 == 2) {
                    System.out.println(2);
                    count++;
                }
                lock.unlock();
            }
        }
    }

    static class ThirdThread implements Runnable {

        @Override
        public void run() {
            while (true && !Thread.interrupted()) {
                lock.lock();
                if (count % 4 == 3) {
                    System.out.println(3);
                    count++;
                }
                lock.unlock();
            }
        }
    }

    static class FourThread implements Runnable {

        @Override
        public void run() {
            while (true && !Thread.interrupted()) {
                lock.lock();
                if (count % 4 == 0) {
                    System.out.println(4);
                    count++;
                }
                lock.unlock();
            }
        }
    }
}
