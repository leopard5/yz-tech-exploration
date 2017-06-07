package com.yz.jvm.test;

import java.util.concurrent.CountDownLatch;


public class DebugThreadTest implements Runnable{

	private CountDownLatch countDownLatch = null;
	
	public DebugThreadTest(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}
	
	@Override
	public void run() {
	String[] array = {"ab","cd"};
		for (int i = 0; i < array.length; i++) {
			if ("ab".equals(array[i]) ) {
				System.out.println("----------");
			}
			System.out.println("array[i]=" + array[i]);
		}
		System.out.println("test:" + Thread.currentThread().getName());
		countDownLatch.countDown();
	}
	
}
