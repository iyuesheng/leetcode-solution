package cn.iisheng.solution.twopointers;

import java.util.Arrays;

/**
 * @author iisheng
 * @date 2019/12/02 22:26:03
 */
public class No_0283_MoveZeroes {


    public static void moveZeroes1(int[] nums) {
        int lastNonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != lastNonZeroIndex) {
                    int temp = nums[i];
                    nums[i] = nums[lastNonZeroIndex];
                    nums[lastNonZeroIndex] = temp;
                }
                lastNonZeroIndex++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return;
        }
        int zeroSlowIndex = -1;
        int zeroFastIndex = -1;
        int nonZeroIndex = -1;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                if (zeroSlowIndex == -1) {
                    zeroFastIndex = i;
                    zeroSlowIndex = i;
                } else {
                    zeroFastIndex++;
                }
            } else {
                if (nonZeroIndex == -1) {
                    nonZeroIndex = i;
                }
                if (zeroFastIndex != -1) {
                    nums[zeroSlowIndex] = nums[i];
                    nums[i] = 0;
                    zeroSlowIndex++;
                    zeroFastIndex++;
                }
            }
        }
    }

    public static void main(String[] args) {
        moveZeroes1(new int[]{1, 3, 12, 0, 0});
    }
}
