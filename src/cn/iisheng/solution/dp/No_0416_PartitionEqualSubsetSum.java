package cn.iisheng.solution.dp;

import java.util.Arrays;

/**
 * @author iisheng
 * @date 2020/03/07 12:42:31
 */
public class No_0416_PartitionEqualSubsetSum {

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 3, 8, 5}));
    }

    public static boolean canPartition1(int[] nums) {
        // 数组 nums 的长度
        final int length = nums.length;
        // 如果长度为1 返回false
        if (length == 1) {
            return false;
        }
        // 数组中所有元素的和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 和是奇数 返回 false
        if ((sum & 1) == 1) {
            return false;
        }

        // 如果 和 是偶数
        // 问题就转化成 我们能不能在数组中 取任意个元素 组成 sum/2
        // 如果能凑成 sum/2 因为所有元素和是 sum 剩下的元素 也是 sum/2 即求得了题目解
        int target = sum >> 1;

        // 定义布尔类型dp数组 代表 取数组中任意个元素 能否 凑成和为target
        boolean[] dp = new boolean[target + 1];

        // dp[0] 设为true 因为 可以使用2个空集合凑成 target=0
        dp[0] = true;

        Arrays.sort(nums);

        // 遍历nums中所有的元素
        for (int j = length - 1; j >= 0; j--) {
            int num = nums[j];
            // 计算 i 在[num, target]之间 的dp[i]的值
            for (int i = target; i >= num; --i) {
                // 如果 dp[i-num] 为true 再取数组中的 num 即可凑成 和为i的组合
                // 如果 dp[i] 之前已经是 true 当然还要继续保持 所以 用 或
                dp[i] = dp[i] || dp[i - num];
                // 如果 得到结果 结果 返回 不需要继续循环了
                if (dp[target] == true) {
                    return true;
                }
            }
        }
        return dp[target];
    }


    // 先做dp 后做dfs
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }

        int target = sum /= 2;


        // 在整个数组中选择元素 看能不能 组成 和 为 target
        return dfs(0, target, nums);
    }


    /**
     * 从数组的index 位置 到 数组最后一位 查找是否有满足条件的结果
     *
     * @param index
     * @param target
     * @param nums
     * @return
     */
    public static boolean dfs(int index, int target, int[] nums) {
        // target 为 0 可以由2个空数组 组成 返回 true
        if (target == 0) {
            return true;
        }
        // 没有满足题意的结果 返回 false
        if (target < 0 || index >= nums.length) {
            return false;
        }
        // 如果能 找到 元素和为  target - nums[index]的组合，那么再取 nums[index]也就找到了 和为 target 的组合
        if (dfs(index + 1, target - nums[index], nums)) {
            return true;
        }
        int i = index + 1;
        // 在遍历过程中 如果 nums[index] == nums[index+1] 就可以 直接跳过 index
        while (i < nums.length && nums[index] == nums[i]) {
            i++;
        }
        return dfs(i, target, nums);
    }
}
