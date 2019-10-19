package cn.iisheng.solution.dp;

/**
 * @author iisheng
 * @date 2019/09/26 12:42:46
 */
public class No_0746_MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {
        int[] result = new int[cost.length + 1];
        result[0] = 0;
        result[1] = 0;
        result[2] = Math.min(cost[0], cost[1]);
        for (int i = 2; i <= cost.length; i++) {
            result[i] = Math.min(result[i - 1] + cost[i - 1], result[i - 2] + cost[i - 2]);
        }
        return result[cost.length];
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
