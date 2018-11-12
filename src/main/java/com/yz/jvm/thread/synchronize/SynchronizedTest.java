package com.yz.jvm.thread.synchronize;

public class SynchronizedTest {
    private static int count = 0;
    private static Object lockObj = new Object();

    public void testSynchronizedBlock() {
        System.out.println("SynchronizedBlock start...");
        synchronized (lockObj) {
            count++;
            System.out.println("SynchronizedBlock");
        }
    }

    public synchronized void testSynchronizedMethod() {
        count++;
        System.out.println("testSynchronizedMethod");
    }


    public static synchronized void testSynchronizedStaticMethod() {
        count++;
        System.out.println("testSynchronizedStaticMethod");
    }
}
