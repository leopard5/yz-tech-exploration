package com.yz.jvm.classload;

public class Book {

    int price = 110;
    static int amount = 112;

    static {
        System.out.println("书的静态代码块");
        System.out.println("amount=" + amount);
    }

    public static void main(String[] args) {
        System.out.println("Hello ShuYi.");

    }

    Book() {
        System.out.println("书的构造方法");
        System.out.println("price=" + price + ",amount=" + amount);
    }

    {
        System.out.println("书的普通代码块");
    }

}
