package cn.iisheng.solution.dfs;

import cn.iisheng.solution.common.TreeNode;
import cn.iisheng.solution.utils.TreeUtils;

/**
 * @author iisheng
 * @date 2019/10/23 13:59:24
 */
public class No_0098_ValidateBinarySearchTree {

    public static boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 如果树为空 就是一棵 BST
     * 如果树的根节点的值 小于等于左节点的值  或者 根节点的值 大于等于右节点的值 就不是 一棵 BST
     * 如果根节点 满足 条件 那么就看 2个 孩子节点 是否也满足条件
     *
     * @param root
     * @param min
     * @param max
     * @return
     */
    public static boolean isValid(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        } else if (root.val <= min || root.val >= max) {
            return false;
        } else {
            return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.createBinaryTree(new Integer[]{10, 5, 15, null, null, 6, 20});
        System.out.println(isValidBST(root));
    }
}
