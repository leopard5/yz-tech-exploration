package com.yz.jvm.thread.interview.print;

/**
 * 启动3个线程打印递增的数字, 线程1先打印1,2,3,4,5,
 * 然后是线程2打印6,7,8,9,10,
 * 然后是线程3打印11,12,13,14,15.
 * 接着再由线程1打印16,17,18,19,20....以此类推, 直到打印到75.
 */
public class Print {
    public static void main(String[] args) {
        int a = 5;
        System.out.println(5/5%3);
//        new Thread(new PrintRunnable(1)).start();
//        new Thread(new PrintRunnable(2)).start();
//        new Thread(new PrintRunnable(3)).start();
    }
}

class PrintRunnable implements Runnable {
    private static volatile int printNum = 0;
    private int threadId;

    public PrintRunnable(int threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        synchronized (Print.class) {
            while (printNum < 75) {
                if (printNum / 5 % 3 + 1 == threadId) {
                    for (int i = 0; i < 5; i++) {
                        System.out.println("线程" + threadId + ":" + (++printNum));
                    }
                    Print.class.notifyAll();
                } else {
                    try {
                        Print.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
