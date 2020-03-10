package cn.iisheng.solution.array;

import java.util.Arrays;

/**
 * @author iisheng
 * @date 2020/03/09 23:25:03
 */
public class No_1304_FindNUniqueIntegersSumUpToZero {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(5)));
        System.out.println(Arrays.toString(sumZero(1)));
        System.out.println(Arrays.toString(sumZero(2)));
    }

    public static int[] sumZero(int n) {
        int[] arr = new int[n];
        // 奇数
        if (n % 2 == 1) {
            arr[n - 1] = 0;
            n = n - 1;
        }
        for (int i = 0; i < n / 2; i++) {
            arr[i] = -(i + 1);
            arr[n - 1 - i] = i + 1;
        }
        return arr;
    }
}
