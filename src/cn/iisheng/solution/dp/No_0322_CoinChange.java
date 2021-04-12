package cn.iisheng.solution.dp;

import java.util.Arrays;

/**
 * @author iisheng
 * @date 2021/04/09 16:59:56
 */
public class No_0322_CoinChange {


    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange(new int[]{2}, 3));

    }

    public static int coinChange(int[] coins, int amount) {
        // 动态规划
        // f(amount) = 最小值 f(amount-coins[0]),f(amount-coins[1],...,f(amount-coins[coins.length-1]) + 1
        int[] dp = new int[amount + 1];
        int max = amount + 1;
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
