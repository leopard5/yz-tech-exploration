package com.yz.jvm.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{
	private Object target = null;
	
	public Object getInstance(Object target){
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());
		// 回调方法 
		enhancer.setCallback(this);
		// 创建代理对象 
		return enhancer.create();
	}
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy methodProxy) throws Throwable {
		System.out.println("Cglib Proxy事物开始"); 
		methodProxy.invokeSuper(obj, args);
		System.out.println("Cglib Proxy事物结束"); 
		return null;
	}
	
	public static void main(String[] args) {
		CglibProxy cglibProxy = new CglibProxy();
		Count count=(Count)cglibProxy.getInstance(new CountImpl());
		count.queryCount();
		count.updateCount();
		
	}
}
