package cn.iisheng.solution.dfs;

import cn.iisheng.solution.common.TreeNode;
import cn.iisheng.solution.utils.TreeUtils;

/**
 * @author iisheng
 * @date 2019/10/11 22:20:18
 */
public class No_0112_PathSum {

    public static boolean hasPathSum(TreeNode root, int sum) {
        // 如果当前结点 是 空返回 false
        if (root == null) {
            return false;
        }

        // 递归的从根结点 到 当前结点
        // 如果当前结点是 叶子结点 并且 val == sum 返回 true
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        } else {
            // 如果不是叶子结点 看 左孩子 或者 右孩子 的值 能不能等于 sum-root.val
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.createBinaryTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        System.out.println(hasPathSum(root, 22));
    }


}
