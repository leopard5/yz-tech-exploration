package com.yz.jvm.test;

public class JoinTest implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " run start!");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " run end!");
		
	}

}
