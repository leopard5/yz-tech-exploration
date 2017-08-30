package com.yz.jvm.sort;

public class SortJudgeUtil {
    /**
     * 判断排序是否正确
     *
     * @param oriArr  原数组
     * @param sortArr 排好序的数组
     * @return true排序正确, false排序错误
     */
    public static boolean judgeSort(int[] oriArr, int[] sortArr) {
        boolean validity = false;
        if (oriArr.length != sortArr.length) {
            return validity;
        }

        //检查排序性
        for (int i = 0; i < sortArr.length - 1; i++) {
            if (sortArr[i + 1] < sortArr[i]) {
                return validity;
            }
        }

        //排序数组和原数组验证
        boolean[] record = new boolean[oriArr.length];
        for (int i = 0; i < oriArr.length; i++) {
            for (int j = 0; j < sortArr.length; j++) {
                if (oriArr[i] == sortArr[j] && !record[j]) {
                    record[j] = true;
                    break;
                }
                if (j == sortArr.length - 1) {
                    return validity;
                }
            }
        }
        return !validity;
    }
}
