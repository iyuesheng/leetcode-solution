package cn.iisheng.solution.dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * @author iisheng
 * @date 2022/08/31 17:58:37
 */
public class No_0046_Permutations {
    
    List<List<Integer>> res = new LinkedList<>();
    
    /**
     * 主函数 输入不重复的数字，返回他们的全排列
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        // 记录 路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }
    
    /**
     * 路径：记录在track中
     * 选择列表：nums中不存在于track中的那些元素
     * 结束条件：nums中元素全都在track中出现
     *
     * @param nums
     * @param track
     */
    public void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            // 做选择
            track.addLast(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new No_0046_Permutations().permute(nums));
    }
}
