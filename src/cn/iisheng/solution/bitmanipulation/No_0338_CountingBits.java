package cn.iisheng.solution.bitmanipulation;

import java.util.Arrays;

/**
 * @author iisheng
 * @date 2022/03/01 16:34:03
 */
public class No_0338_CountingBits {

    public static int[] countBits(int n) {
        int[] arr = new int[n + 1];

        // 一个整数的二进制有多少个1，可以转化为 一个整数的最后 一位数字 + 这个整数/2 有多少个1
        for (int i = 1; i <= n; i++) {
            arr[i] = (i % 2) + arr[i / 2];
        }

        return arr;
    }

    public static int[] dpCountBits(int n) {
        int[] arr = new int[n + 1];

        // 2: 10, 2 * 1
        // 5: 101, 2 * 2 + 1
        // 10: 1010, 2 * 5


        // Let dp[i] be number of 1s for integer i. Assume dp[0 ... i-1] holds
        // We have dp[i] = dp[i/2] if i is even, or dp[i] = dp[i/2] + 1 if i is odd
        // Base case dp[0] = 0
        for (int i = 0; i <= n; i++) {
            arr[i] = arr[i / 2];
            if (i % 2 == 1) {
                arr[i]++;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dpCountBits(5)));
    }
}
