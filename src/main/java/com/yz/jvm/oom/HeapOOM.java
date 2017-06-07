package com.yz.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * -verbose:gc -Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError
 * @author qiyz
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 */
public class HeapOOM {
	static class OOMObject {
	}

	public static void main(String[] args) throws InterruptedException {
		List<OOMObject> list = new ArrayList<HeapOOM.OOMObject>();
		while (true) {
//			Thread.sleep(1);
			list.add(new OOMObject());
		}
	}
}
