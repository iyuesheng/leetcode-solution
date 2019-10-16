package org.dullnull.solution.hashtable;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author iisheng
 * @date 2019/10/16 21:24:54
 */
public class No_0001_TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        int length = nums.length;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static int[] twoSum1(int[] nums, int target) {


        HashMap map = new HashMap();
        HashMap two = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                two.put(nums[i], i);
            } else {
                map.put(nums[i], i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            Integer o = (Integer) map.get(sub);
            if (o != null) {
                if (sub == nums[i]) {
                    Integer t = (Integer) two.get(sub);
                    if (t != null) {
                        return new int[]{o, t};
                    }
                } else {
                    return new int[]{i, o};
                }
            }
        }

        return new int[]{};

    }

    public static int[] twoSum2(int[] nums, int target) {

        HashMap map = new HashMap();
        HashMap two = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                two.put(nums[i], i);
            } else {
                map.put(nums[i], i);
            }
        }

        Arrays.sort(nums);

        int i = 0, j = nums.length - 1;

        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                if (nums[i] != nums[j]) {
                    return new int[]{(int) map.get(nums[i]), (int) map.get(nums[j])};
                } else {
                    return new int[]{(int) map.get(nums[i]), (int) two.get(nums[i])};
                }
            }
        }

        return new int[]{};
    }

    public static int[] twoSum3(int[] nums, int target) {
        HashMap map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (map.containsKey(sub) && (int) map.get(sub) != i) {
                return new int[]{i, (int) map.get(sub)};
            }
        }
        return new int[]{};
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum3(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum3(new int[]{3, 3}, 6)));
    }
}
