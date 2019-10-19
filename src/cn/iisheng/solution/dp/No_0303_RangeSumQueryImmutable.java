package cn.iisheng.solution.dp;

/**
 * @author iisheng
 * @date 2019/09/26 13:44:10
 */
public class No_0303_RangeSumQueryImmutable {

    /**
     * 第一次 直接使 计算n个数的和
     */
//    private int[] nums;

    /**
     * 使用二维数组 存储 计算结果 然后 直接取
     */
//    private int[][] result;

//    public No_0303_RangeSumQueryImmutable(int[] nums) {
//        this.nums = nums;
//        int len = nums.length;
//        result = new int[len][];
//        for (int i = 0; i < len; i++) {
//            result[i] = new int[len - i];
//            for (int j = i; j < len; j++) {
//                if (i == j) {
//                    result[i][j - i] = nums[j];
//                } else {
//                    result[i][j - i] = result[i][j - i - 1] + nums[j];
//                }
//            }
//        }
//    }


//    public int sumRange(int i, int j) {
//        return result[i][j - i];
//    }
//
//    public int sumRange1(int i, int j) {
//        int sum = 0;
//        for (; i <= j; i++) {
//            sum += nums[i];
//        }
//        return sum;
//    }

    /**
     * 前面效果都不好 看了 solution 使用缓存 计算 2个位置的差值
     */
    private int[] sums;

    public No_0303_RangeSumQueryImmutable(int[] nums) {
        sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }

    public static void main(String[] args) {
        System.out.println(new No_0303_RangeSumQueryImmutable(
                new int[]{-2, 0, 3, -5, 2, -1}).sumRange(2, 2));

        System.out.println(new No_0303_RangeSumQueryImmutable(
                new int[]{-2, 0, 3, -5, 2, -1}).sumRange(2, 5));

        System.out.println(new No_0303_RangeSumQueryImmutable(
                new int[]{-2, 0, 3, -5, 2, -1}).sumRange(0, 5));
    }
}
