package com.yz.jvm.proxy;

public class CountCommonProxy implements Count {

	CountImpl countImpl;

	public CountCommonProxy(CountImpl countImpl) {
		this.countImpl = countImpl;
	}

	@Override
	public void queryCount() {
		System.out.println("queryCount事务处理之前");
		// 调用委托类的方法;
		countImpl.queryCount();
		System.out.println("queryCount事务处理之后");
	}

	@Override
	public void updateCount() {
		System.out.println("updateCount事务处理之前");
		// 调用委托类的方法;
		countImpl.updateCount();
		System.out.println("updateCount事务处理之后");
	}
}
