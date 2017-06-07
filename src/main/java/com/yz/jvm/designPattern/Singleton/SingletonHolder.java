package com.yz.jvm.designPattern.Singleton;

/**
 * Initialization Demand Holder(IoDH)
 * @author qiyazhong
 *
 */
public class SingletonHolder {
	private SingletonHolder() {
	}

	private static class SingletonClassHolder {
		private final static SingletonHolder INSTANCE = new SingletonHolder();
	}

	public static SingletonHolder getInstance() {
		return SingletonClassHolder.INSTANCE;
	}
}
