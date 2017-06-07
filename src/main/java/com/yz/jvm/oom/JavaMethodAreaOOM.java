package com.yz.jvm.oom;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * VM args -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 */

public class JavaMethodAreaOOM {
	public static void main(String[] args) {
		try {
			while (true) {
				Enhancer enhancer = new Enhancer();
				enhancer.setSuperclass(OOM.class);
				enhancer.setUseCache(false);
				enhancer.setCallback(new MethodInterceptor() {
					public Object intercept(Object obj, Method arg1, Object[] args,
							MethodProxy proxy) throws Throwable {
						// TODO Auto-generated method stub
						return proxy.invokeSuper(obj, args);
					}
				});
				OOM oom = (OOM) enhancer.create();
				oom.sayHello(" QiYaZhong");
			}
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
	}

	static class OOM {
		public String sayHello(String str) {
			return "HI " + str;
		}
	}
}
