package com.yz.jvm.sort;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int[] oArr = {1, 4, 13, 2, 3, 4, 0, 99, -2, 7};
        int[] oArr2 = {0, 5, 3, 21, -7, 4, 0, 99, -2};
        int[] oArr3 = {1, 4, 13, 2, 3, 4, 0, 99, -2, 1111};

        //插入排序
        int[] arr = Arrays.copyOf(oArr, oArr.length);
        PrintUtil.printArray(arr);
        PrintUtil.printArray(Sort.insertSort(arr), SortJudgeUtil.judgeSort(oArr, arr));
        arr = Arrays.copyOf(oArr2, oArr2.length);
        PrintUtil.printArray(arr);
        PrintUtil.printArray(Sort.insertSort(arr), SortJudgeUtil.judgeSort(oArr2, arr));
        arr = Arrays.copyOf(oArr3, oArr3.length);
        PrintUtil.printArray(arr);
        PrintUtil.printArray(Sort.insertSort(arr), SortJudgeUtil.judgeSort(oArr3, arr));

        //希尔排序
        arr = Arrays.copyOf(oArr, oArr.length);
        PrintUtil.printArray(arr);
        PrintUtil.printArray(Sort.shellSort(arr), SortJudgeUtil.judgeSort(oArr, arr));
        arr = Arrays.copyOf(oArr2, oArr2.length);
        PrintUtil.printArray(arr);
        PrintUtil.printArray(Sort.shellSort(arr), SortJudgeUtil.judgeSort(oArr2, arr));
        arr = Arrays.copyOf(oArr3, oArr3.length);
        PrintUtil.printArray(arr);
        PrintUtil.printArray(Sort.shellSort(arr), SortJudgeUtil.judgeSort(oArr3, arr));

        //冒泡排序
        arr = Arrays.copyOf(oArr, oArr.length);
        PrintUtil.printArray(arr);
        PrintUtil.printArray(Sort.bubbleSort(arr), SortJudgeUtil.judgeSort(oArr, arr));
        arr = Arrays.copyOf(oArr2, oArr2.length);
        PrintUtil.printArray(arr);
        PrintUtil.printArray(Sort.bubbleSort(arr), SortJudgeUtil.judgeSort(oArr2, arr));
        arr = Arrays.copyOf(oArr3, oArr3.length);
        PrintUtil.printArray(arr);
        PrintUtil.printArray(Sort.bubbleSort(arr), SortJudgeUtil.judgeSort(oArr3, arr));

        //快速排序
        arr = Arrays.copyOf(oArr, oArr.length);
        PrintUtil.printArray(arr);
        PrintUtil.printArray(Sort.quickSort(arr), SortJudgeUtil.judgeSort(oArr, arr));
        arr = Arrays.copyOf(oArr2, oArr2.length);
        PrintUtil.printArray(arr);
        PrintUtil.printArray(Sort.quickSort(arr), SortJudgeUtil.judgeSort(oArr2, arr));
        arr = Arrays.copyOf(oArr3, oArr3.length);
        PrintUtil.printArray(arr);
        PrintUtil.printArray(Sort.quickSort(arr), SortJudgeUtil.judgeSort(oArr3, arr));

        //选择排序
        arr = Arrays.copyOf(oArr, oArr.length);
        PrintUtil.printArray(arr);
        PrintUtil.printArray(Sort.selectSort(arr), SortJudgeUtil.judgeSort(oArr, arr));
        arr = Arrays.copyOf(oArr2, oArr2.length);
        PrintUtil.printArray(arr);
        PrintUtil.printArray(Sort.selectSort(arr), SortJudgeUtil.judgeSort(oArr2, arr));
        arr = Arrays.copyOf(oArr3, oArr3.length);
        PrintUtil.printArray(arr);
        PrintUtil.printArray(Sort.selectSort(arr), SortJudgeUtil.judgeSort(oArr3, arr));

        //堆排序
        arr = Arrays.copyOf(oArr, oArr.length);
        PrintUtil.printArray(arr);
        PrintUtil.printArray(Sort.heapSort(arr), SortJudgeUtil.judgeSort(oArr, arr));
        arr = Arrays.copyOf(oArr2, oArr2.length);
        PrintUtil.printArray(arr);
        PrintUtil.printArray(Sort.heapSort(arr), SortJudgeUtil.judgeSort(oArr2, arr));
        arr = Arrays.copyOf(oArr3, oArr3.length);
        PrintUtil.printArray(arr);
        PrintUtil.printArray(Sort.heapSort(arr), SortJudgeUtil.judgeSort(oArr3, arr));

        //归并排序
        arr = Arrays.copyOf(oArr, oArr.length);
        PrintUtil.printArray(arr);
        PrintUtil.printArray(Sort.mergeSort(arr), SortJudgeUtil.judgeSort(oArr, arr));
        arr = Arrays.copyOf(oArr2, oArr2.length);
        PrintUtil.printArray(arr);
        PrintUtil.printArray(Sort.mergeSort(arr), SortJudgeUtil.judgeSort(oArr2, arr));
        arr = Arrays.copyOf(oArr3, oArr3.length);
        PrintUtil.printArray(arr);
        PrintUtil.printArray(Sort.mergeSort(arr), SortJudgeUtil.judgeSort(oArr3, arr));


        //排序算法性能测试
        PerformanceTest.testPerformance();



    }
}
