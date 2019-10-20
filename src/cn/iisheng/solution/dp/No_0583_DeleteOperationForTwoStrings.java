package cn.iisheng.solution.dp;

import java.util.Arrays;

/**
 * @author iisheng
 * @date 2019/10/20 19:05:02
 */
public class No_0583_DeleteOperationForTwoStrings {

    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == 0) {
            return len2;
        }
        if (len2 == 0) {
            return len1;
        }

        // 二维数组可用 一位数组 + 临时一位数组 替换掉
        int[][] dp = new int[len1][len2];
        dp[0][0] = word1.charAt(0) == word2.charAt(0) ? 1 : 0;

        for (int i = 1; i < len1; i++) {
            if (dp[i - 1][0] == 1 || word1.charAt(i) == word2.charAt(0)) {
                dp[i][0] = 1;
            }
        }

        for (int j = 1; j < len2; j++) {
            if (dp[0][j - 1] == 1 || word1.charAt(0) == word2.charAt(j)) {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                // 此处赋值语句可优化
                // dp[i - 1][j - 1] + 1 >=  Math.max(dp[i - 1][j], dp[i][j - 1])
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
//        for (int i = 0; i < dp.length; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

        return len1 - dp[len1 - 1][len2 - 1] + len2 - dp[len1 - 1][len2 - 1];
    }

    public static int minDistanceDpSlow(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == 0) {
            return len2;
        }
        if (len2 == 0) {
            return len1;
        }
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + 1);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return len1 - dp[len1][len2] + len2 - dp[len1][len2];
    }

    public static int minDistanceDpQuick(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[] dp = new int[len2 + 1];

        for (int i = 0; i < len1; i++) {
            int[] temp = new int[len2 + 1];
            for (int j = 0; j < len2; j++) {
                temp[j + 1] = Math.max(dp[j + 1], temp[j]);
                if (word1.charAt(i) == word2.charAt(j)) {
                    temp[j + 1] = Math.max(temp[j + 1], dp[j] + 1);
                }
            }
            dp = temp;
            System.out.println(Arrays.toString(dp));
        }

        return len1 - dp[len2] + len2 - dp[len2];
    }

    public static int minDistanceDpQuick2(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        // 使用一维数组
        int[] dp = new int[len2 + 1];

        for (int i = 0; i < len1; i++) {
            // 借用临时数组temp，将二维dp数组降维
            int[] temp = new int[len2 + 1];
            for (int j = 0; j < len2; j++) {
                // 优化基本解法的 赋值逻辑
                if (word1.charAt(i) == word2.charAt(j)) {
                    temp[j + 1] = Math.max(temp[j + 1], dp[j] + 1);
                } else {
                    temp[j + 1] = Math.max(dp[j + 1], temp[j]);
                }
            }
            dp = temp;
        }

        return len1 - dp[len2] + len2 - dp[len2];
    }

    public static void main(String[] args) {
        System.out.println(minDistanceDpSlow("sea", "eat"));
        System.out.println(minDistanceDpQuick("sea", "eat"));

        System.out.println(minDistanceDpSlow("a", "ab"));
        System.out.println(minDistanceDpQuick("a", "ab"));
    }
}