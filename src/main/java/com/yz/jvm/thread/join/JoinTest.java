package com.yz.jvm.thread.join;

import static java.lang.Thread.sleep;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                sleep(5000);
                System.out.println("t1 exec");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread t2 = new Thread(() -> {
            try {
                sleep(10000);
                System.out.println("t2 exec");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        t2.join();
        System.out.println("main exec");
    }
}
