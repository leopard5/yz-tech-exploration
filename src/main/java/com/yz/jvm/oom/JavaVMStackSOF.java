package com.yz.jvm.oom;

/**
 * VM args:  栈内存的容量
 * -verbose:gc -Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError -Xss160k
 * Exception in thread "main" java.lang.StackOverflowError
 */
public class JavaVMStackSOF {
	private int stackLength = 1;

	public void stackLeak() {
		stackLength++;
		stackLeak();// 递归
	}

	public static void main(String[] args) throws Throwable {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("statck length:" + oom.stackLength);
			throw e;
		}
	}
}
