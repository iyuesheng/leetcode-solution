package cn.iisheng.solution.twopointers;

import java.util.Arrays;

/**
 * @author iisheng
 * @date 2019/10/09 19:17:09
 */
public class No_0532_KDiffPairsInAnArray {
    public static int findPairs(int[] nums, int k) {

        int slow = 0;
        int fast = 1;

        Arrays.sort(nums);

        int num = 0;

        while (fast < nums.length) {
            if (slow >= fast) {
                fast = slow + 1;
                continue;
            }
            if (nums[fast] - nums[slow] == k) {
                System.out.println("slow = " + slow + " fast=" + fast);
                num++;
                while (slow + 1 < nums.length) {
                    if (nums[slow] == nums[slow + 1]) {
                        slow++;
                    } else {
                        break;
                    }
                }
                slow++;
                fast++;
            } else {
                if (nums[slow] + k < nums[fast]) {
                    slow++;
                } else {
                    fast++;
                }
            }
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(findPairs(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println(findPairs(new int[]{1, 3, 1, 5, 4}, 0));
//        System.out.println(findPairs(new int[]{1, 2, 3, 4, 5}, 2));
//        System.out.println(findPairs(new int[]{1, 1, 1, 1, 1}, 0));
//        System.out.println(findPairs(new int[]{6, 2, 9, 3, 9, 6, 7, 7, 6, 4}, 3));
    }
}
