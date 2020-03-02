package cn.iisheng.solution.dp;

import java.util.Arrays;
import java.util.List;

/**
 * @author iisheng
 * @date 2020/03/02 23:31:05
 */
public class No_0120_Triangle {

    public static void main(String[] args) {
        List arr1 = Arrays.asList(2);
        List arr2 = Arrays.asList(3, 4);
        List arr3 = Arrays.asList(6, 5, 7);
        List arr4 = Arrays.asList(4, 1, 8, 3);
        System.out.println(minimumTotalSpaceN(Arrays.asList(arr1, arr2, arr3, arr4)));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        if (size == 0) {
            return 0;
        }

        int[][] dp = new int[size][size];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                // 左面的边
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    // 右面的边
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    // 中间的
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }

            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (dp[size - 1][i] < min) {
                min = dp[size - 1][i];
            }
        }
        return min;
    }

    public static int minimumTotalSpaceN(List<List<Integer>> triangle) {
        int size = triangle.size();
        if (size == 0) {
            return 0;
        }

        int[] dp = new int[(size * size + size) / 2];
        dp[0] = triangle.get(0).get(0);
        int index = 1;
        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                // 左面的边
                if (j == 0) {
                    dp[index] = dp[index - triangle.get(i - 1).size()] + triangle.get(i).get(j);
                } else if (j == i) {
                    // 右面的边
                    dp[index] = dp[index - triangle.get(i).size()] + triangle.get(i).get(j);
                } else {
                    // 中间的
                    dp[index] = Math.min(dp[index - triangle.get(i - 1).size() - 1], dp[index - triangle.get(i - 1).size()]) + triangle.get(i).get(j);
                }
                index++;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (dp[dp.length - i - 1] < min) {
                min = dp[dp.length - i - 1];
            }
        }
        return min;
    }

}
