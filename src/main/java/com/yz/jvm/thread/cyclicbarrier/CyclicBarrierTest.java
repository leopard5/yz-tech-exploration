package com.yz.jvm.thread.cyclicbarrier;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * ThreadTest 
 * CyclicBarrierTest.java 
 *  
 * TODO  
 * @author yazhong
 * @date   2015年8月13日 上午10:35:16 
 * @Copyright 2015, 唯创国际 幸福9号 All Rights Reserved. 
 * @version   1.0
 */

/**
 * ClassName:CyclicBarrierTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年8月13日 上午10:35:16 <br/>
 * 
 * @author yazhong
 * @version 1.0
 * @since JDK 1.7
 * @see
 */
public class CyclicBarrierTest {
	public static class ComponentThread implements Runnable {
		CyclicBarrier barrier;// 计数器
		int ID; // 组件标识
		int[] array; // 数据数组

		// 构造方法
		public ComponentThread(CyclicBarrier barrier, int[] array, int ID) {
			this.barrier = barrier;
			this.ID = ID;
			this.array = array;
		}

		public void run() {
			try {
				array[ID] = new Random().nextInt(100);
				System.out.println("Component " + ID + " generates: "
						+ array[ID]);
				// 在这里等待Barrier处
				System.out.println("Component " + ID + " sleep");
				barrier.await();
				System.out.println("Component " + ID + " awaked");
				// 计算数据数组中的当前值和后续值
				int result = array[ID] + array[ID + 1];
				System.out.println("Component " + ID + " result: " + result);
			} catch (Exception ex) {
			}
		}
	}

	/** */
	/**
	 * 测试CyclicBarrier的用法
	 */
	public static void testCyclicBarrier() {
		final int[] array = new int[3];
		CyclicBarrier barrier = new CyclicBarrier(2, new Runnable() {
			// 在所有线程都到达Barrier时执行
			public void run() {
				System.out.println("testCyclicBarrier run");
				array[2] = array[0] + array[1];
			}
		});

		// 启动线程
		new Thread(new ComponentThread(barrier, array, 0)).start();
		new Thread(new ComponentThread(barrier, array, 1)).start();
	}

	public static void main(String[] args) {
		CyclicBarrierTest.testCyclicBarrier();
	}
}
