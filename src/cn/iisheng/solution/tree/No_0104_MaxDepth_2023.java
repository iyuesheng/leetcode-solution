package cn.iisheng.solution.tree;

import cn.iisheng.solution.common.TreeNode;
import cn.iisheng.solution.utils.TreeUtils;

/**
 * @author iisheng
 * @date 2023/10/23 23:35:10
 */
public class No_0104_MaxDepth_2023 {
    
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    
    public static void main(String[] args) {
        TreeNode tree = TreeUtils.createBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(maxDepth(tree));
    }
}
