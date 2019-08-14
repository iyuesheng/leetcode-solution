package org.dullnull.solution.tree;

import org.dullnull.solution.common.TreeNode;

/**
 * @author iisheng
 * @date 2019/08/08 17:30:37
 */
public class No_0236_LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        return root;
    }
}
