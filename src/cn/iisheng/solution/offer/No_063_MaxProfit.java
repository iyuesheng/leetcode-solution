package cn.iisheng.solution.offer;

/**
 * @author iisheng
 * @date 2022/08/25 16:12:52
 */
public class No_063_MaxProfit {
    
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        
        int max = 0;
        for (int i = 0; i < len; i++) {
            int start = prices[i];
            for (int j = i + 1; j < len; j++) {
                if (prices[j] - start > max) {
                    max = prices[j] - start;
                }
            }
        }
        
        return max;
    }
    
    public static int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        
        int max = 0;
        int left = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[left]) {
                max = prices[i] - prices[left] > max ? prices[i] - prices[left] : max;
            } else {
                left = i;
            }
        }
        return max;
    }
    
    public static int maxProfitII(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        
        int max = 0;
        int total = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            } else {
                total = total + max;
            }
        }
        return max;
    }
    
    
    // 找数组最小值 再找数组最大值 并且 最大值 在最小值右面
    public static void main(String[] args) {
        int[] arr = new int[]{10, 8, 20, 30, 40, 5, 15};
//        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        
        System.out.println(maxProfitII(arr));
    }
}
