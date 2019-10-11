package org.dullnull.solution.dfs;

import org.dullnull.solution.common.TreeNode;

/**
 * @author iisheng
 * @date 2019/10/11 22:20:18
 */
public class No_0112_PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }

        if(root.left==null && root.right==null && root.val==sum){
            return true;
        }

        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }
}
