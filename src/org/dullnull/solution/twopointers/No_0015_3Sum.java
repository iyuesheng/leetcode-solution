package org.dullnull.solution.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author iisheng
 * @date 2019/10/16 22:52:00
 */
public class No_0015_3Sum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        if (nums.length < 3) {
            return list;
        }

        Arrays.sort(nums);

        int i = 0, j = nums.length - 2;
        int index = nums.length - 1;
        int target = -nums[index];
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                List temp = new ArrayList();
                temp.add(nums[i]);
                temp.add(nums[j]);
                temp.add(-target);
                if (!list.contains(temp)) {
                    list.add(temp);
                }
                i++;
                j--;
            }
            if (i >= j) {
                i = 0;

                index--;
                j = index - 1;

                target = -nums[index];
            }

        }
        return list;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        if (nums.length < 0 || nums[0] > 0 || nums[nums.length - 1] < 0) {
            return list;
        }

        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) {
                break;
            }

            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }

            int target = 0 - nums[k];
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                if (nums[i] + nums[j] == target) {
                    list.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    while (i < j && nums[j] == nums[j - 1]) {
                        j--;
                    }
                    i++;
                    j--;
                } else if (nums[i] + nums[j] < target) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(threeSum1(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum1(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6}));
    }
}
