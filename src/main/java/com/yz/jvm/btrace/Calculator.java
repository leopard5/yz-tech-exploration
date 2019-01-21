package com.yz.jvm.btrace;

import java.util.Scanner;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator test = new Calculator();
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = test.add(a, b);
            System.out.println(String.format("%d + %d = %d", a, b, c));
        }
    }
}
