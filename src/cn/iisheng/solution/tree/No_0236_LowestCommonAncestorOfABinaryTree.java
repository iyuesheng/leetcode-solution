package cn.iisheng.solution.tree;

import cn.iisheng.solution.common.TreeNode;
import cn.iisheng.solution.utils.TreeUtils;

/**
 * @author iisheng
 * @date 2019/08/08 17:30:37
 */
public class No_0236_LowestCommonAncestorOfABinaryTree {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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

    public static void main(String[] args) {
        TreeNode root = TreeUtils.createBinaryTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        TreeNode p = TreeUtils.getFirstNode(root, 5);
        TreeNode q = TreeUtils.getFirstNode(root, 1);
        TreeNode ancestor = lowestCommonAncestor(root, p, q);
        System.out.println(ancestor.val);
    }
}
