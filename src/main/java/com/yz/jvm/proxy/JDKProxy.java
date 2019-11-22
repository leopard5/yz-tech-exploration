package com.yz.jvm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {
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
        System.out.println("JDK Proxy before execute");
        Object result = method.invoke(target, args);
        System.out.println("JDK Proxy after execute");
        return result;
    }

    public static void main(String[] args) {
        JDKProxy countJDKProxy = new JDKProxy();
        Account count = (Account) countJDKProxy.bind(new AccountImpl());
        count.queryCount();
        count.updateCount();
    }
}
