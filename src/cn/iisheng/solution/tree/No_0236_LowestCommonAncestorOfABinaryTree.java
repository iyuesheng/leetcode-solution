package cn.iisheng.solution.tree;

import cn.iisheng.solution.common.TreeNode;
import cn.iisheng.solution.utils.TreeUtils;

/**
 * @author iisheng
 * @date 2019/08/08 17:30:37
 */
public class No_0236_LowestCommonAncestorOfABinaryTree {

    /**
     * 问题解析
     * <p>
     * 情况1：根节点为空，直接返回NULL
     * <p>
     * 情况2：p或q中有一个为空，返回非空的那个
     * <p>
     * 情况3：p或q其中一个是另一个的祖先结点，返回是祖先结点的那个
     * <p>
     * 情况4：p和q分别位于他们最近公共结点的两侧
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
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
