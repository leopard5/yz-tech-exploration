package com.yz.jvm.test;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import com.yz.jvm.thread.callable.CallableTest;

public class MainDemo {

	public static void main(String[] args) throws RunnerException {
//		Options opt = new OptionsBuilder()
//				.include(".*" + MainDemo.class.getSimpleName() + ".*")
//				.forks(1)
//				.build();
//		new Runner(opt).run();
		
		// UUidString生产串测试
		// getUUidString();

		// Callable用法测试
		// callableTest()

		// semahpore用法测试

		// debugThread测试
		// debugThread(2);

		// 条件断点测试
		// conditionDebugPoint(999);

		// jion测试
		 joinTest(20);
		Integer aaa = 890;

	}

	public static void joinTest(final int count) {
		Thread thread = null;
		for (int i = 0; i < count; i++) {
			thread = new Thread(new JoinTest(), "JoinTest" + i);
			thread.start();
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("joinTest Main Thread run end!!!");
	}

	public static void conditionDebugPoint(final int count) {
		for (int i = 0; i < count; i++) {
			System.out.println("现在运行的是:" + i);
		}
	}

	public static void debugThread(final int threadCount) {
		Thread thread = null;
		CountDownLatch countDownLatch = new CountDownLatch(threadCount);
		long start = System.currentTimeMillis();
		for (int i = 0; i < threadCount; i++) {
			thread = new Thread(new DebugThreadTest(countDownLatch), "debugThread" + i);
			thread.setPriority(Thread.NORM_PRIORITY);
			thread.start();
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("运行函数debugThread所花时间为:" + (end - start) + "毫秒");

	}

	public static void callableTest() {
		FutureTask<String> future = new FutureTask<String>(new CallableTest("tree"));
		ExecutorService exe = Executors.newFixedThreadPool(1);
		exe.submit(future);
		System.out.println("客户端请求结束了");
		System.out.println("任务是否已经完成：" + future.isDone());
		try {
			/*
			 * 这段时间，就是后台在获取真正数据的时间
			 */
			System.out.println("在这段时间，我可以做我自己的事情");
			System.out.println("真正的数据:" + future.get());
			System.out.println("任务是否已经完成：" + future.isDone());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getUUidString() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		// 去掉"-"符号
		String temp = str.replaceAll("\\-", "");
		return str + "," + temp;
	}

	public static void getSemahporeTest() {
		Semaphore semaphore = new Semaphore(10);
		// semaphore.
	}
}
