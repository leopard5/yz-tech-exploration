package com.yz.jvm.forkjoin.threads;

public class BasicThread {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                }
                System.out.println(">>> I am running in a separate thread!");
            }
        };

        thread.start();
        thread.join();
        System.out.println("main thread running");
    }
}