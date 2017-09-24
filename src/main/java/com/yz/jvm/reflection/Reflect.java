package com.yz.jvm.reflection;

import com.yz.jvm.proxy.Count;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Reflect {
    public static void main(String[] args) {
        Method[] methods = Count.class.getMethods();

        for (Method method : methods) {
            System.out.println("method = " + method.getName());
        }


        Class aClass = Count.class; //获取Class对象
        Constructor[] constructors = aClass.getConstructors();


    }

}
