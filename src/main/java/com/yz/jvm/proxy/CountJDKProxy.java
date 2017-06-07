package com.yz.jvm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CountJDKProxy implements InvocationHandler {
	private Object target;

	public Object bind(Object target) {
		this.target = target;
		// 取得代理对象
		return Proxy.newProxyInstance(
				target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), 
				this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;
		System.out.println("JDK Proxy事物开始");
		result = method.invoke(target, args);
		System.out.println("JDK Proxy事物结束");
		return result;
	}

	public static void main(String[] args) {
		CountJDKProxy countJDKProxy = new CountJDKProxy();
		Count count=(Count)countJDKProxy.bind(new CountImpl());
		count.queryCount();
		
	}
}
