package cn.iisheng.solution.tree;

import cn.iisheng.solution.common.TreeNode;
import cn.iisheng.solution.utils.TreeUtils;

/**
 * @author iisheng
 * @date 2019/11/08 19:34:55
 */
public class No_0226_InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.createBinaryTree(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        TreeUtils.print(root);
        TreeNode result = invertTree(root);
        TreeUtils.print(result);
    }
}
