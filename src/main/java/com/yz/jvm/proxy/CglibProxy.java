package com.yz.jvm.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private Object target;

    public Object getInstance(Object target) {
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
        Account count = (Account) cglibProxy.getInstance(new AccountImpl());
        count.queryCount();
        count.updateCount();

    }
}
