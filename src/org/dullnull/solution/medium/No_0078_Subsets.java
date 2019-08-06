package org.dullnull.solution.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author iisheng
 * @date 2019/08/06 11:16:21
 */
public class No_0078_Subsets {

    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        result.add(new ArrayList<>());
        dfs(0, nums, result, new ArrayList<>());

        return result;
    }

    public static void dfs(int idx, int nums[], List<List<Integer>> result, List<Integer> temp) {
        for (int i = idx; i < nums.length; i++) {
            // 加入当前数组
            temp.add(nums[i]);
            result.add(new ArrayList<>(temp));
            // 继续下一个数字
            dfs(i + 1, nums, result, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
