package com.yz.jvm.thread.lock;
/**
 * ThreadTest WaitNotifyDemo.java
 * 
 * TODO
 * 
 * @author yazhong
 * @date 2015年8月31日 下午5:14:56
 * @version 1.0
 */
/**
 * 
 * 假定我们有两个线程要打印1到9这9个数字，要求第一个线程打印1，2，3然后停止打印，
 * 由线程2打印4，5，6，然后线程2停止打印，通知线程1继续打印7，8，9.
 * 
 * @author yazhong
 * @date 2015年8月31日 下午5:15:44
 * @version 1.0
 */
public class WaitNotifyPrintTest {
	private volatile int val = 1;

	private synchronized void printAndIncrease() {
		System.out.println(Thread.currentThread().getName() + " prints " + val);
		val++;
	}

	// print 1,2,3 7,8,9
	public class PrinterA implements Runnable {
		@Override
		public void run() {
			while (val <= 3) {
				printAndIncrease();
			}

			// print 1,2,3 then notify printerB
			synchronized (WaitNotifyPrintTest.this) {
				System.out.println("PrinterA printed 1,2,3; notify PrinterB");
				WaitNotifyPrintTest.this.notify();
			}

			try {
				while (val <= 6) {
					synchronized (WaitNotifyPrintTest.this) {
						System.out.println("wait in printerA");
						WaitNotifyPrintTest.this.wait();
					}
				}
				System.out.println("wait end printerA");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			while (val <= 9) {
				printAndIncrease();
			}
			System.out.println("PrinterA exits");
		}
	}

	// print 4,5,6 after printA print 1,2,3
	public class PrinterB implements Runnable {

		@Override
		public void run() {
			while (val < 3) {
				synchronized (WaitNotifyPrintTest.this) {
					try {
						System.out
								.println("printerB wait for printerA printed 1,2,3");
						WaitNotifyPrintTest.this.wait();
						System.out
								.println("printerB waited for printerA printed 1,2,3");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			while (val <= 6) {
				printAndIncrease();
			}

			System.out.println("notify in printerB");
			synchronized (WaitNotifyPrintTest.this) {
				WaitNotifyPrintTest.this.notify();
			}
			System.out.println("notify end printerB");
			System.out.println("PrinterB exits.");
		}
	}

	public static void main(String[] args) {
		WaitNotifyPrintTest demo = new WaitNotifyPrintTest();
		demo.doPrint();
	}

	private void doPrint() {
		PrinterA pa = new PrinterA();
		PrinterB pb = new PrinterB();
		Thread a = new Thread(pa);
		a.setName("printerA");
		Thread b = new Thread(pb);
		b.setName("printerB");
		// 必须让b线程先执行，否则b线程有可能得不到锁，执行不了wait，而a线程一直持有锁，会先notify了
		b.start();
		a.start();
	}
}
