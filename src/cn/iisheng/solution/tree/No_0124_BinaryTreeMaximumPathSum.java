package cn.iisheng.solution.tree;

import cn.iisheng.solution.common.TreeNode;
import cn.iisheng.solution.utils.TreeUtils;

/**
 * @author iisheng
 * @date 2022/08/31 16:00:55
 */
public class No_0124_BinaryTreeMaximumPathSum {
    
    int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
    
    
    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        int val = node.val + leftGain + rightGain;
        
        maxSum = Math.max(val, maxSum);
        return node.val + Math.max(leftGain, rightGain);
    }
    
    public static void main(String[] args) {
        TreeNode root = TreeUtils.createBinaryTree(new Integer[]{-10, 9, 20, null, null, 15, 7});
        System.out.println(new No_0124_BinaryTreeMaximumPathSum().maxPathSum(root));
    }
}
