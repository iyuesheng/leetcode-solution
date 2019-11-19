package cn.iisheng.solution.dfs;

import cn.iisheng.solution.common.TreeNode;
import cn.iisheng.solution.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author iisheng
 * @date 2019/10/11 22:20:18
 */
public class No_0437_PathSumIII {

    static int count = 0;

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int temp = dfs(root, sum);
        if (temp > 0) {
            count += temp;
        }
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return count;
    }

    public static int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.val == sum) {
            return 1 + dfs(root.left, sum - root.val) + dfs(root.right, sum - root.val);
        } else {
            return dfs(root.left, sum - root.val) + dfs(root.right, sum - root.val);
        }
    }

    public int pathSum1(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<>();
        helper(root, sum, path);
        return count;
    }

    private void helper(TreeNode root, int sum, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        equalTo(path, sum);
        helper(root.left, sum, path);
        helper(root.right, sum, path);
        path.remove(path.size() - 1);
    }

    private void equalTo(List<Integer> path, int sum) {
        int total = sum;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum -= path.get(i);
            if (sum == 0) {
                count++;
            }
        }
    }

    public int pathSum2(TreeNode root, int sum) {
        if (root == null) return 0;
        int depth = findDepth(root);
        int[] path = new int[depth];
        return helper(root, path, sum, 0);
    }

    private int helper(TreeNode cur, int[] path, int sum, int level) {
        if (cur == null) return 0;
        path[level] = cur.val;
        int count = 0, path_sum = 0;
        for (int i = level; i >= 0; i--) {
            path_sum += path[i];
            if (path_sum == sum) {
                count++;
            }
        }
        count += helper(cur.left, path, sum, level + 1);
        count += helper(cur.right, path, sum, level + 1);
        return count;
    }

    private int findDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return 1 + Math.max(findDepth(root.left), findDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.createBinaryTree(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
        System.out.println(pathSum(root, 8));
    }
}
