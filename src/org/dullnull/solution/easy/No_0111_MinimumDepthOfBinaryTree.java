package org.dullnull.solution.easy;

/**
 * @author iisheng
 * @date 2019/08/10 17:37:40
 */
public class No_0111_MinimumDepthOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left != null && root.right == null) {
            return 1 + minDepth(root.left);
        }
        if (root.right != null && root.left == null) {
            return 1 + minDepth(root.right);
        }
        return 1 + Math.min(minDepth(root.right), minDepth(root.left));
    }

}
