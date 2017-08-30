package com.yz.jvm.sort;

public class Sort {

    /**
     * 直接插入排序
     *
     * @param arr
     * @return
     */
    public static int[] insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        int tmp = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j + 1] < arr[j]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                } else {
                    break;
                }
            }
        }
        return arr;
    }


    /**
     * 希尔排序
     *
     * @param arr
     * @return
     */
    public static int[] shellSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        int d = arr.length / 2;
        int tmp = 0;
        while (d > 0) {
            for (int i = 0; i < d; i++) {
                for (int j = i + d; j < arr.length; j += d) {
                    for (int k = j - d; k >= 0; k -= d) {
                        if (arr[k + d] < arr[k]) {
                            tmp = arr[k + d];
                            arr[k + d] = arr[k];
                            arr[k] = tmp;
                        } else {
                            break;
                        }
                    }
                }
            }
            d /= 2;
        }
        return arr;
    }

    /**
     * 冒泡排序
     *
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        int tmp = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    /**
     * 快速排序
     *
     * @param arr
     * @return
     */
    public static int[] quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        return quick(arr, 0, arr.length - 1);
    }

    private static int[] quick(int[] arr, int start, int end) {
        if (start >= end) {
            return arr;
        }
        int mid = adjust(arr, start, end);
        quick(arr, start, mid - 1);
        quick(arr, mid + 1, end);
        return arr;
    }

    private static int adjust(int[] arr, int start, int end) {
        int x = arr[start];
        while (start < end) {
            while (start < end && arr[end] > x) {
                end--;
            }
            if (start < end) {
                arr[start] = arr[end];
                start++;
            }
            while (start < end && arr[start] < x) {
                start++;
            }
            if (start < end) {
                arr[end] = arr[start];
                end--;
            }
        }
        arr[start] = x;
        return start;
    }


    /**
     * 选择排序
     *
     * @param arr
     * @return
     */
    public static int[] selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        int x, sel;
        for (int i = 0; i < arr.length; i++) {
            x = arr[i];
            sel = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < x) {
                    x = arr[j];
                    sel = j;
                }
            }
            arr[sel] = arr[i];
            arr[i] = x;
        }
        return arr;
    }


    /**
     * 堆排序
     *
     * @param arr
     * @return
     */
    public static int[] heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        initHeap(arr, arr.length);
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
        return arr;
    }

    private static void initHeap(int[] arr, int len) {
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, len);
        }
    }

    private static void adjustHeap(int[] arr, int start, int len) {
        if (2 * start + 1 >= len) {
            return;
        }

        int key = 2 * start + 1;
        if (2 * start + 2 < len && arr[2 * start + 2] > arr[key]) {
            key++;
        }

        if (arr[start] < arr[key]) {
            swap(arr, start, key);
        }
        adjustHeap(arr, key, len);
    }

    private static void swap(int[] arr, int i, int i1) {
        int tmp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = tmp;
    }

    /**
     * 归并排序
     *
     * @param arr
     * @return
     */
    public static int[] mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        innerMergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void innerMergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            innerMergeSort(arr, start, mid);
            innerMergeSort(arr, mid + 1, end);
            mergeArray(arr, start, mid, end);
        }
    }

    private static void mergeArray(int[] arr, int start, int mid, int end) {
        int[] left = new int[mid - start + 1];
        int[] right = new int[end - mid];

        for (int i = start, j = 0; i <= mid; i++, j++) {
            left[j] = arr[i];
        }

        for (int i = mid + 1, j = 0; i <= end; i++, j++) {
            right[j] = arr[i];
        }

        int lIndex = 0, rIndex = 0, index = start;
        for (int i = start; i <= end; i++) {
            if (lIndex >= left.length || rIndex >= right.length) {
                index = i;
                break;
            }
            if (left[lIndex] <= right[rIndex]) {
                arr[i] = left[lIndex++];
            } else {
                arr[i] = right[rIndex++];
            }
        }

        if (lIndex >= left.length) {
            for (int i = index; i <= end; i++) {
                arr[i] = right[rIndex++];
            }
        } else if (rIndex >= right.length) {
            for (int i = index; i <= end; i++) {
                arr[i] = left[lIndex++];
            }
        }
    }
}
