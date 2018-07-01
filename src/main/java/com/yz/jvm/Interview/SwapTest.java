package com.yz.jvm.Interview;

import java.lang.reflect.Field;

public class SwapTest {
    public static void main(String[] args) {
        Integer one = 1;
        Integer another = 2;
        System.out.println("交换前 -> " + one + ":" + another);
//        swap(one, another);
        swapReference(one, another);
        System.out.println("交换后 -> " + one + ":" + another);
    }

    public static void swap(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
    }

    public static void swapReference(Integer a, Integer b) {
        int temp = a.intValue();
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            field.set(a, b);
            field.set(b, new Integer(temp));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
