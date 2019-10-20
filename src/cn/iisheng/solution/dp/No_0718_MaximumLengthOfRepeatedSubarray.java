package cn.iisheng.solution.dp;

import java.util.Arrays;

/**
 * @author iisheng
 * @date 2019/10/19 22:35:31
 */
public class No_0718_MaximumLengthOfRepeatedSubarray {

    public static int findLength(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) {
            return 0;
        }

        int[][] dp = new int[A.length][B.length];

        dp[0][0] = A[0] == B[0] ? 1 : 0;

        int result = dp[0][0];

        for (int i = 1; i < B.length; i++) {
            if (A[0] == B[i]) {
                dp[0][i] = 1;
                if (dp[0][i] > result) {
                    result = dp[0][i];
                }
            } else {
                dp[0][i] = 0;
            }
        }

        for (int i = 1; i < A.length; i++) {
            if (A[i] == B[0]) {
                dp[i][0] = 1;
                if (dp[i][0] > result) {
                    result = dp[i][0];
                }
            } else {
                dp[i][0] = 0;
            }
        }

        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < B.length; j++) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (dp[i][j] > result) {
                    result = dp[i][j];
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return result;

    }

    public static int findLengthDpQuickError(int[] A, int[] B) {
        int[] dp = new int[B.length + 1];
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            // 正序遍历 不好用
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    dp[j + 1] = dp[j] + 1;
                    if (dp[j + 1] > max) {
                        max = dp[j + 1];
                    }
                } else {
                    dp[j + 1] = 0;
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return max;
    }

    public static int findLengthDpQuick(int[] A, int[] B) {
        int l1 = A.length;
        int l2 = B.length;
        if (l1 == 0 || l2 == 0) {
            return 0;
        }
        int[] dp = new int[l2 + 1];
        int max = 0;
        for (int i = 0; i < l1; i++) {
            for (int j = l2 - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    dp[j + 1] = dp[j] + 1;
                    if (dp[j + 1] > max) {
                        max = dp[j + 1];
                    }
                } else {
                    dp[j + 1] = 0;
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return max;
    }

    public static int findLengthDpSlow(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    if (max < dp[i + 1][j + 1]) {
                        max = dp[i + 1][j + 1];
                    }
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return max;
    }

    public static void main(String[] args) {
//        System.out.println(findLengthDpQuick(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
//        System.out.println(findLengthDpQuick(new int[]{1, 2, 3, 4, 1}, new int[]{3, 1, 2, 3, 4}));
//        System.out.println(findLengthDpQuick(new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0}));
//        System.out.println(findLengthDpQuick(new int[]{0, 1, 1, 1, 1}, new int[]{1, 0, 1, 0, 1}));
//        System.out.println(findLength(new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 0, 1, 1}));
        System.out.println(findLengthDpQuick(new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 0, 1, 1}));
        System.out.println(findLengthDpQuickError(new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 0, 1, 1}));
    }
}