package org.dullnull.solution.dfs;

import org.dullnull.solution.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author iisheng
 * @date 2019/10/11 22:20:18
 */
public class No_0113_PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(result, new ArrayList<>(), root, sum);

        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> path, TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        path.add(root.val);

        if (root.left == null && root.right == null && root.val == sum) {
            // 保存满足条件的
            result.add(new ArrayList<>(path));
            // 回溯
            path.remove(path.size() - 1);
            return;
        }

        dfs(result, path, root.left, sum - root.val);
        dfs(result, path, root.right, sum - root.val);

        // 回溯
        path.remove(path.size() - 1);
    }
}
