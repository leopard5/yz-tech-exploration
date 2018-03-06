package com.yz.jvm.classload;

public class Singleton {
    private static Singleton singleton = new Singleton();

    public static int count1;
    public static int count2 = 0;

//    private static Singleton singleton = new Singleton();

    private Singleton() {
        count1++;
        count2++;
    }

    public static Singleton getInstance() {
        return singleton;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println("count1=" + count1);
        System.out.println("count2=" + count2);
    }
}
