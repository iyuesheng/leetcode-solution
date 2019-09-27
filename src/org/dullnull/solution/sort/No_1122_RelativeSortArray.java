package org.dullnull.solution.sort;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author iisheng
 * @date 2019/09/26 23:17:57
 */
public class No_1122_RelativeSortArray {

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {

        HashMap map = new HashMap(1000);
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        // 常规快速排序


        return arr1;
    }

    public int[] relativeSortArray3(int[] arr1, int[] arr2) {
        int[] tmp = new int[1001];

        for (int n : arr1) {
            tmp[n]++;
        }
        int i = 0;
        for (int n : arr2) {
            while (tmp[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        for (int j = 0; j < tmp.length; j++) {
            while (tmp[j]-- > 0) {
                arr1[i++] = j;
            }
        }
        return arr1;
    }

    public static int[] relativeSortArray2(int[] arr1, int[] arr2) {

        int[] sortedArr1 = new int[1001];
        int[] result = new int[arr1.length];
        int idx = 0;

        for (int i = 0; i < arr1.length; i++) {
            sortedArr1[arr1[i]] += 1;
        }

        for (int i = 0; i < arr2.length; i++) {
            while (sortedArr1[arr2[i]] > 0) {
                sortedArr1[arr2[i]] -= 1;
                result[idx] = arr2[i];
                idx += 1;
            }
        }

        for (int i = 0; i < sortedArr1.length; i++) {
            while (sortedArr1[i] > 0) {
                sortedArr1[i] -= 1;
                result[idx] = i;
                idx += 1;
            }
        }

        return result;
    }

    public static int[] relativeSortArray1(int[] arr1, int[] arr2) {

        HashMap map = new HashMap(1000);
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        // 常规冒泡排序
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length - i - 1; j++) {
                // 如果 arr1[j] > arr1[j+1] 交换
                Integer num_j = (Integer) map.get(arr1[j]);
                Integer num_j1 = (Integer) map.get(arr1[j + 1]);
                // 如果 不在 后面特殊 数组里面 按照 大小比较
                if ((num_j == null && num_j1 == null && arr1[j + 1] < arr1[j])
                        // 不在数组 中 的 算 小
                        || (num_j == null && num_j1 != null)
                        // 按照在 数组中的位置 比较大小
                        || num_j != null && num_j1 != null && num_j1 < num_j) {
                    swap(arr1, j, j + 1);
                }
            }
        }
        return arr1;
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                relativeSortArray2(
                        new int[]{2, 3, 1, 3, 2, 4, 6, 19, 7, 2, 19},
                        new int[]{2, 1, 4, 3, 9, 6})));
    }
}
