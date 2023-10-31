package cn.iisheng.solution.offer;

import java.util.Arrays;

/**
 * @author iisheng
 * @date 2022/07/27 19:17:48
 */
public class No_000_QuickSort {
    
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quick(arr, 0, arr.length - 1);
    }
    
    public static void quick(int[] arr, int start, int end) {
        if (start < end) {
            int partition = partition(arr, start, end);
            quick(arr, start, partition - 1);
            quick(arr, partition + 1, end);
        }
    }
    
    public static int partition(int[] arr, int start, int end) {
        if (start < end) {
            int temp = arr[start];
            while (start < end) {
                if (arr[end] >= temp) {
                    end--;
                }
                if (start < end) {
                    arr[start] = arr[end];
                }
                
                if (arr[start] < temp) {
                    start++;
                }
                
                if (start < end) {
                    arr[end] = arr[start];
                }
            }
            arr[start] = temp;
            return start;
        }
        throw new RuntimeException("参数非法");
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 1, 2};
        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
