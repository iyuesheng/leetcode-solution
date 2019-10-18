package org.dullnull.solution.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author iisheng
 * @date 2019/10/18 13:16:26
 */
public class No_0041_FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int num = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                continue;
            } else {
                if (nums[i] < num) {
                    continue;
                } else if (nums[i] == num) {
                    num++;
                } else {
                    return num;
                }
            }
        }
        return num;
    }

    public static int firstMissingPositive1(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        HashMap set = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            set.put(nums[i], 1);
        }

        int i = 1;

        for (; i <= nums.length; i++) {
            if (!set.containsKey(i)) {
                return i;
            }
        }

        return i;
    }

    public static int firstMissingPositive2(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        HashSet set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int i = 1;

        for (; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return i;
    }


    public static int firstMissingPositive3(int[] nums) {
        int n = nums.length, tmp;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[tmp - 1] = tmp;
            }
        }
        for (int i = 0; i < n; i++)
            if (nums[i] != i + 1) return i + 1;
        return n + 1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive1(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive1(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive1(new int[]{7, 8, 9, 11, 12}));
        System.out.println(firstMissingPositive1(new int[]{0, 2, 2, 1, 1}));
    }
}
