package cn.iisheng.solution.dp;

/**
 * @author iisheng
 * @date 2019/09/25 15:51:25
 */
public class No_0121_BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0 || length == 1) {
            return 0;
        }
        int[] minValue = new int[length];
        minValue[0] = prices[0];
        minValue[1] = Math.min(prices[0], prices[1]);
        for (int i = 2; i < length; i++) {
            minValue[i] = Math.min(minValue[i - 1], prices[i]);
        }
        int result = 0;
        for (int i = 0; i < minValue.length; i++) {
            int profit = prices[i] - minValue[i];
            if (profit > result) {
                result = profit;
            }
        }
        return Math.max(0, result);
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
