package cn.iisheng.solution.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author iisheng
 * @date 2019/08/06 12:13:14
 */
public class No_0039_CombinationSum {

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(lists);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, candidates, result, new ArrayList<>(), target);
        return result;
    }

    public static void dfs(int idx, int[] candidates, List<List<Integer>> result, List<Integer> temp, int target) {
        // 寻找到目标
        if (target == 0) {
            result.add(new ArrayList<>(temp));
        } else if (target < 0) {
            return;
        } else {
            for (int i = idx; i < candidates.length; i++) {
                // 添加此判断可以加速4ms
                if (candidates[i] <= target) {
                    temp.add(candidates[i]);
                    dfs(i, candidates, result, temp, target - candidates[i]);
                    // dfs 执行完以后 也就是target<0 直接返回 所以应该讲temp最后一个元素删除
                    temp.remove(temp.size() - 1);
                }
            }
        }

    }
}
