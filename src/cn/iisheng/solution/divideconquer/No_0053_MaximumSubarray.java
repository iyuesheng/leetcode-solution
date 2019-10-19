package cn.iisheng.solution.divideconquer;

/**
 * @author iisheng
 * @date 2019/09/21 22:58:22
 */
public class No_0053_MaximumSubarray {

    /**
     * 思路
     * 分解：将数组分为2个 子数组
     * 解决：两个子数组的 最大和 可以直接求得， 包含中间点 的 最大和 经过特殊计算一下
     * 合并：返回两个子数组 最大和 中 最大的一个 或者 返回 包含中间点 的最大和
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        return calcMaxSubarray(nums, 0, (nums.length - 1) / 2, nums.length - 1);
    }

    /**
     * 计算最大子数组
     *
     * @param array
     * @param left
     * @param mid
     * @param right
     * @return
     */
    public static int calcMaxSubarray(int[] array, int left, int mid, int right) {
        // left >= right 跳出递归
        if (left >= right) {
            return array[left];
        }

        // 左面子数组 最大值
        int leftMax = calcMaxSubarray(array, left, (left + mid) / 2, mid);
        // 右面子数组 最大值
        int rightMax = calcMaxSubarray(array, mid + 1, (mid + 1 + right) / 2, right);
        // 包含中间点的 两个子数组 的最大值 初始值 设为 中点的值
        int midMax = array[mid], temp = midMax;

        for (int i = mid - 1; i >= left; i--) {
            temp += array[i];
            midMax = Math.max(temp, midMax);
        }

        temp = midMax;

        for (int i = mid + 1; i <= right; i++) {
            temp += array[i];
            midMax = Math.max(temp, midMax);
        }

        return Math.max(midMax, Math.max(leftMax, rightMax));
    }

    public static void main(String[] args) {
        int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(array));
    }
}
