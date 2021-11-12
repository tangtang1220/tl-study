package com.tangtang.basic.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class Sort {

    /**
     * 选择排序
     *
     * @param arr arr
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int end = arr.length;
        for (int i = 0; i < end; i++) {
            int minValueIndex = i;
            for (int j = (i + 1); j < end; j++) {
                minValueIndex = arr[j] < arr[i] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr arr
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int end = arr.length;
        for (int i = end - 1; i >= 0; i--) {
            for (int second = 1; second <= i; second++) {
                if (arr[second - 1] > arr[second]) {
                    swap(arr, second - 1, second);
                }
            }
        }
    }

    /**
     * 插入排序
     *
     * @param arr arr
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int end = arr.length;
        for (int i = 1; i < end; i++) {
//            int index = i;
//            while ((index > 0 && arr[index] < arr[index - 1])) {
//                swap(arr, index, index - 1);
//                index--;
//            }
            for (int index = i; index > 0 && arr[index] < arr[index - 1]; index--) {
                swap(arr, index, index - 1);
            }
        }
    }

    /**
     * 元素交换
     *
     * @param arr arr
     * @param a   a
     * @param b   b
     */
    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 8, 7, 5};
//        selectSort(arr);
//        bubbleSort(arr);
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
