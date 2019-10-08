package org.dullnull.solution.array;

/**
 * @author iisheng
 * @date 2019/10/08 17:29:59
 */
public class No_0035_SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public static int search(int[] nums, int target, int i, int j) {

        // 查找数组 中间位子
        int index = i + (j - i) / 2;

        // 比较中间位置的 数字 和 target 大小

        // target 比中间的小 就 向左面 继续找
        // target 比中间的大 就 向右面 继续找
        // == 就返回该位置

        if (target > nums[index] && index < j) {
            if (target < nums[index + 1]) {
                return index + 1;
            }
            if (target == nums[index + 1]) {
                return index + 1;
            }
            return search(nums, target, index + 1, j);
        }

        if (target < nums[index] && index > 0) {
            if (target > nums[index - 1]) {
                return index;
            }
            if (target == nums[index - 1]) {
                return index - 1;
            }
            return search(nums, target, i, index - 1);
        }

        if (target == nums[index]) {
            return index;
        } else if (target > nums[index]) {
            return index + 1;
        } else {
            return index;
        }

    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}