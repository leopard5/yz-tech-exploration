package com.yz.jvm.thread.callable;
import java.util.concurrent.Callable;

public class CallableTest implements Callable<String> {
	private String strAppendTest;

	public CallableTest(String myStr) {
		this.strAppendTest = myStr;
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			sb.append(strAppendTest);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
