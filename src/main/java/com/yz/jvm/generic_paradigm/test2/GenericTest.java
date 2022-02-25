package com.yz.jvm.generic_paradigm.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericTest {

    //方法一
    public static <T extends Comparable<T>> List<T> sort(List<T> list) {
        return Arrays.asList(list.toArray((T[]) new Comparable[list.size()]));
    }

    //方法二
    public static <T extends Comparable<T>> T[] sort2(List<T> list) {
        // 这里没报错
        return list.toArray((T[]) new Comparable[list.size()]);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        // 方法一调用正常
        System.out.println(sort(list).getClass());
        // 方法二调用报错了，这里报错了
        System.out.println(sort2(list).getClass());
    }
}
