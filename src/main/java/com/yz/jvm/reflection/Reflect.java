package com.yz.jvm.reflection;

import com.yz.jvm.proxy.Count;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflect {
    public static void main(String[] args) {
        Class objClass = Count.class;
        Method[] methods = objClass.getMethods();
        for (Method method : methods) {
            Class[] parameterTypes = method.getParameterTypes();
            method.getReturnType();
            System.out.println("method = " + method.getName());

            // 获取方法注解
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
            }

            // 获取方法参数注解
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            Class[] parameterTypesAA = method.getParameterTypes();
        }
        Constructor[] constructors = objClass.getConstructors();
        Field[] fields = objClass.getFields();
        for (Field field : fields) {
            System.out.println("field = " + field.getName() + ",type=" + field.getType());

            // 获取字段注解
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
            }

//            Annotation annotation = field.getAnnotation(Count.class);
        }
        Annotation[] annotations = objClass.getAnnotations();
        for (Annotation annotation : annotations) {
        }
    }

    public static void printGettersSetters(Class aClass) {
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            if (isGetter(method)) System.out.println("getter: " + method);
            if (isSetter(method)) System.out.println("setter: " + method);
        }
    }

    public static boolean isGetter(Method method) {
        if (!method.getName().startsWith("get")) return false;
        if (method.getParameterTypes().length != 0) return false;
        return !void.class.equals(method.getReturnType());
    }

    public static boolean isSetter(Method method) {
        if (!method.getName().startsWith("set")) return false;
        return method.getParameterTypes().length == 1;
    }
}
