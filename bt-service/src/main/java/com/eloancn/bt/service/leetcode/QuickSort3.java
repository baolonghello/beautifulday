package com.eloancn.bt.service.leetcode;

import java.util.Arrays;

/**
 * @ Description   :  QuickSort
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2021/1/29$ 3:56 下午$
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2021/1/29$ 3:56 下午$
 * @ UpdateRemark  :  update detail
 * @ Version       :  1.0
 */
public class QuickSort3 {


    public static void main(String[] args) {
        //给出无序数组
        int arr[] = {72, 6, 57, 88, 60, 42, 83, 73, 48, 85};
        QuickSort3.doQuickSort(arr, 0, arr.length - 1);
        //QuickSort3.doSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void doQuickSort(int[] arr, int start, int end) {
        if (start < end) {
            int index = doStep(arr, start, end);
            doQuickSort(arr, start, index - 1);
            doQuickSort(arr, index + 1, end);
        }
    }

    public static int doStep(int[] arr, int start, int end) {

        int target = arr[start];
        int index = start;
        while (start < end) {
            while (start < end) {
                if (arr[end] < target) {
                    swap(arr, start, end);
                    index = end;
                    break;
                } else {
                    end--;
                }
            }
            while (start < end) {
                if (arr[start] > target) {
                    swap(arr, start, end);
                    index = start;
                    break;
                } else {
                    start++;
                }
            }
        }
        return index;
    }

    public static void swap(int[] arr, int start, int end) {
        int step = arr[start];
        arr[start] = arr[end];
        arr[end] = step;
    }

    /**
     * 冒泡
     * @param arr
     */
    public static void doSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

}
