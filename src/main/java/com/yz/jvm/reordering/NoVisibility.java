package com.yz.jvm.reordering;

public class NoVisibility {
	private static boolean ready;
	private static int number;

	private static class ReaderThread extends Thread {
		public void run() {
			while (!ready) {
				System.out.println(3);
				// Thread.yield();
			}
			System.out.println(number);
		}
	}

	public static void main(String args[]) throws Exception {
		new ReaderThread().start();
		 Thread.sleep(1000);   //2
		number = 42;    // 1
		ready = true;   // 1
	}
}
