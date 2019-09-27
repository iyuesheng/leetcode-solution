package org.dullnull.solution.sort;

import java.util.Arrays;

/**
 * @author iisheng
 * @date 2019/09/21 23:52:16
 */
public class No_0169_MajorityElement {

    public static int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static int majorityElement1(int[] nums) {
        int major = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            int count = 0;
            for (int num : nums) {
                if ((num & mask) != 0) {
                    count++;
                }
            }

            if (count > nums.length / 2) {
                major |= mask;
            }
        }
        return major;
    }

    public static int majorityElement2(int[] nums) {
        return divc(nums, 0, nums.length - 1);
    }


    public static int majorityElement3(int[] nums) {
        int count = 0;
        int major = nums[0];
        for (int num : nums) {
            if (num == major) {
                count += 1;
            } else if (--count == 0) {
                count = 1;
                major = num;
            }
        }
        return major;
    }

    private static int divc(int[] nums, int L, int R) {
        if (L == R) // 只有一个元素, 直接返回
            return nums[L];
        int mid = L + (R - L) / 2;
        int LS = divc(nums, L, mid);
        int RS = divc(nums, mid + 1, R);
        if (LS == RS) // 两边的众数相同，直接返回即可
            return LS;
        int c1 = 0, c2 = 0;
        for (int i = L; i <= R; i++) {
            if (nums[i] == LS) c1++;
            if (nums[i] == RS) c2++;
        }
        return c1 > c2 ? LS : RS;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement3(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
