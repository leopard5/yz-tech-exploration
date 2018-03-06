package com.yz.jvm.classload;

public class FinalTest {
    public static final int x = 6 / 3;

    static {
        System.out.println("FinalTest static block");
    }
}

class Test2 {
    public static void main(String[] args) {
        System.out.println(FinalTest.x);
    }
}