package com.yz.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
* 需要在JDK1.6上才能复现，JDK1.7及之后版本的JVM已经将运行时常量池从方法区中移了出来，在Java 堆（Heap）中开辟了一块区域存放运行时常量池。
* 在JDK1.7上运行的效果则会一直执行，直到堆内存使用完毕
* VM Args：-XX:PermSize=10M -XX:MaxPermSize=10M 
*
* java.lang.OutOfMemoryError:PermGen space
*/
public class RuntimeConstantPoolOOM {
	public static void main(String[] args) {
		// 使用List保持着常量池引用，避免Full GC回收常量池行为
		List<String> list = new ArrayList<String>();
		// 10MB的PermSize在integer范围内足够产生OOM了
		int i = 0;
		while (true) {
			list.add(String.valueOf(i++).intern());
		}
	}
}
