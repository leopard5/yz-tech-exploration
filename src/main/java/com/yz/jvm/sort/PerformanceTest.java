package com.yz.jvm.sort;

import java.util.Arrays;
import java.util.Random;

public class PerformanceTest {


    public static void testPerformance() {
        int[] randomArr = PerformanceTest.genRandomArray(10000);
        int[] randomArr2 = PerformanceTest.genRandomArray(100000);
        int[] randomArr3 = PerformanceTest.genRandomArray(1000000);
        int[] arr = null;

        arr = Arrays.copyOf(randomArr, randomArr.length);
        long sTime = System.currentTimeMillis();
        Sort.insertSort(arr);
        long eTime = System.currentTimeMillis();
        System.out.println("插入排序对10000个随机数排序时间: " + (eTime - sTime) + "毫秒");

        arr = Arrays.copyOf(randomArr, randomArr.length);
        sTime = System.currentTimeMillis();
        Sort.shellSort(arr);
        eTime = System.currentTimeMillis();
        System.out.println("希尔排序对10000个随机数排序时间: " + (eTime - sTime) + "毫秒");

        arr = Arrays.copyOf(randomArr, randomArr.length);
        sTime = System.currentTimeMillis();
        Sort.bubbleSort(arr);
        eTime = System.currentTimeMillis();
        System.out.println("冒泡排序对10000个随机数排序时间: " + (eTime - sTime) + "毫秒");

        arr = Arrays.copyOf(randomArr, randomArr.length);
        sTime = System.currentTimeMillis();
        Sort.quickSort(arr);
        eTime = System.currentTimeMillis();
        System.out.println("快速排序对10000个随机数排序时间: " + (eTime - sTime) + "毫秒");

        arr = Arrays.copyOf(randomArr, randomArr.length);
        sTime = System.currentTimeMillis();
        Sort.selectSort(arr);
        eTime = System.currentTimeMillis();
        System.out.println("选择排序对10000个随机数排序时间: " + (eTime - sTime) + "毫秒");

        arr = Arrays.copyOf(randomArr, randomArr.length);
        sTime = System.currentTimeMillis();
        Sort.heapSort(arr);
        eTime = System.currentTimeMillis();
        System.out.println("堆排序对10000个随机数排序时间: " + (eTime - sTime) + "毫秒");

        arr = Arrays.copyOf(randomArr, randomArr.length);
        sTime = System.currentTimeMillis();
        Sort.mergeSort(arr);
        eTime = System.currentTimeMillis();
        System.out.println("归并排序对10000个随机数排序时间: " + (eTime - sTime) + "毫秒");

        arr = Arrays.copyOf(randomArr, randomArr.length);
        sTime = System.currentTimeMillis();
        Arrays.sort(arr);
        eTime = System.currentTimeMillis();
        System.out.println("Java官方Arrays.sort排序对10000个随机数排序时间: " + (eTime - sTime) + "毫秒");

        arr = Arrays.copyOf(randomArr2, randomArr2.length);
        sTime = System.currentTimeMillis();
        Sort.insertSort(arr);
        eTime = System.currentTimeMillis();
        System.out.println("插入排序对100000个随机数排序时间: " + (eTime - sTime) + "毫秒");

        arr = Arrays.copyOf(randomArr2, randomArr2.length);
        sTime = System.currentTimeMillis();
        Sort.shellSort(arr);
        eTime = System.currentTimeMillis();
        System.out.println("希尔排序对100000个随机数排序时间: " + (eTime - sTime) + "毫秒");

        arr = Arrays.copyOf(randomArr2, randomArr2.length);
        sTime = System.currentTimeMillis();
        Sort.bubbleSort(arr);
        eTime = System.currentTimeMillis();
        System.out.println("冒泡排序对100000个随机数排序时间: " + (eTime - sTime) + "毫秒");

        arr = Arrays.copyOf(randomArr2, randomArr2.length);
        sTime = System.currentTimeMillis();
        Sort.quickSort(arr);
        eTime = System.currentTimeMillis();
        System.out.println("快速排序对100000个随机数排序时间: " + (eTime - sTime) + "毫秒");

        arr = Arrays.copyOf(randomArr2, randomArr2.length);
        sTime = System.currentTimeMillis();
        Sort.selectSort(arr);
        eTime = System.currentTimeMillis();
        System.out.println("选择排序对100000个随机数排序时间: " + (eTime - sTime) + "毫秒");

        arr = Arrays.copyOf(randomArr2, randomArr2.length);
        sTime = System.currentTimeMillis();
        Sort.heapSort(arr);
        eTime = System.currentTimeMillis();
        System.out.println("堆排序对100000个随机数排序时间: " + (eTime - sTime) + "毫秒");

        arr = Arrays.copyOf(randomArr2, randomArr2.length);
        sTime = System.currentTimeMillis();
        Sort.mergeSort(arr);
        eTime = System.currentTimeMillis();
        System.out.println("归并排序对100000个随机数排序时间: " + (eTime - sTime) + "毫秒");

        arr = Arrays.copyOf(randomArr2, randomArr2.length);
        sTime = System.currentTimeMillis();
        Arrays.sort(arr);
        eTime = System.currentTimeMillis();
        System.out.println("Java官方Arrays.sort排序对10000个随机数排序时间: " + (eTime - sTime) + "毫秒");


        arr = Arrays.copyOf(randomArr3, randomArr3.length);
        sTime = System.currentTimeMillis();
        Sort.insertSort(arr);
        eTime = System.currentTimeMillis();
        System.out.println("插入排序对1000000个随机数排序时间: " + (eTime - sTime) + "毫秒");

        arr = Arrays.copyOf(randomArr3, randomArr3.length);
        sTime = System.currentTimeMillis();
        Sort.shellSort(arr);
        eTime = System.currentTimeMillis();
        System.out.println("希尔排序对1000000个随机数排序时间: " + (eTime - sTime) + "毫秒");

        arr = Arrays.copyOf(randomArr3, randomArr3.length);
        sTime = System.currentTimeMillis();
        Sort.bubbleSort(arr);
        eTime = System.currentTimeMillis();
        System.out.println("冒泡排序对1000000个随机数排序时间: " + (eTime - sTime) + "毫秒");

        arr = Arrays.copyOf(randomArr3, randomArr3.length);
        sTime = System.currentTimeMillis();
        Sort.quickSort(arr);
        eTime = System.currentTimeMillis();
        System.out.println("快速排序对1000000个随机数排序时间: " + (eTime - sTime) + "毫秒");

        arr = Arrays.copyOf(randomArr3, randomArr3.length);
        sTime = System.currentTimeMillis();
        Sort.selectSort(arr);
        eTime = System.currentTimeMillis();
        System.out.println("选择排序对1000000个随机数排序时间: " + (eTime - sTime) + "毫秒");

        arr = Arrays.copyOf(randomArr3, randomArr3.length);
        sTime = System.currentTimeMillis();
        Sort.heapSort(arr);
        eTime = System.currentTimeMillis();
        System.out.println("堆排序对1000000个随机数排序时间: " + (eTime - sTime) + "毫秒");

        arr = Arrays.copyOf(randomArr3, randomArr3.length);
        sTime = System.currentTimeMillis();
        Sort.mergeSort(arr);
        eTime = System.currentTimeMillis();
        System.out.println("归并排序对1000000个随机数排序时间: " + (eTime - sTime) + "毫秒");

        arr = Arrays.copyOf(randomArr3, randomArr3.length);
        sTime = System.currentTimeMillis();
        Arrays.sort(arr);
        eTime = System.currentTimeMillis();
        System.out.println("Java官方Arrays.sort排序对10000个随机数排序时间: " + (eTime - sTime) + "毫秒");
    }


    /**
     * 生成指定大小的随机数组
     *
     * @param size
     * @return
     */
    public static int[] genRandomArray(int size) {
        if (size < 1) {
            return null;
        }

        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(2 * size);
        }
        return arr;
    }
}
