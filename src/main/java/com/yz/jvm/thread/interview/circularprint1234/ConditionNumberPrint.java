package com.yz.jvm.thread.interview.circularprint1234;

import java.util.concurrent.Semaphore;

public class ConditionNumberPrint {
    private static Semaphore sem1 = new Semaphore(1);
    private static Semaphore sem2 = new Semaphore(1);
    private static Semaphore sem3 = new Semaphore(1);
    private static Semaphore sem4 = new Semaphore(1);

    public static void main(String[] args) {

        new Thread(new ReentrantLockNumberPrint.OneThread()).start();
        new Thread(new ReentrantLockNumberPrint.SencondThread()).start();
        new Thread(new ReentrantLockNumberPrint.ThirdThread()).start();
        new Thread(new ReentrantLockNumberPrint.FourThread()).start();
    }

    static class OneThread implements Runnable {

        @Override
        public void run() {
            while (true && !Thread.interrupted()){
                try {
                    sem1.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(1);
                sem1.release();
            }
        }
    }

    static class Secondhread implements Runnable {

        @Override
        public void run() {
            while (true && !Thread.interrupted()){
                try {
                    sem1.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(2);
                sem1.release();
            }
        }
    }

    static class ThirdThread implements Runnable {

        @Override
        public void run() {
            while (true && !Thread.interrupted()){
                try {
                    sem1.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(3);
                sem1.release();
            }
        }
    }

    static class Fourhread implements Runnable {

        @Override
        public void run() {
            while (true && !Thread.interrupted()){
                try {
                    sem1.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(4);
                sem1.release();
            }
        }
    }
}
