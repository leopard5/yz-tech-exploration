package com.yz.jvm.sort;

public class PrintUtil {

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printArray(int[] arr, boolean v) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println(v);
    }
}
