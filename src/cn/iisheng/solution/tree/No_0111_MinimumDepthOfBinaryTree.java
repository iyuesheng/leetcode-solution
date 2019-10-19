package cn.iisheng.solution.tree;

import cn.iisheng.solution.common.TreeNode;
import cn.iisheng.solution.utils.TreeUtils;

/**
 * @author iisheng
 * @date 2019/08/10 17:37:40
 */
public class No_0111_MinimumDepthOfBinaryTree {

    public static int minDepth(TreeNode root) {
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

    public static void main(String[] args) {
        TreeNode root = TreeUtils.createBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        int minDepth = minDepth(root);
        System.out.println(minDepth);
    }

}
