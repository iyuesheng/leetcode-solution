package org.dullnull.solution.dfs;

import org.dullnull.solution.common.TreeNode;

/**
 * @author iisheng
 * @date 2019/10/11 22:20:18
 */
public class No_0113_PathSumIII {

    private static int count = 0;

    public static int com(TreeNode root, int sum) {
        if (root != null) {
            if (root.val == sum) {
                return 1 + com(root.left, 0) + com(root.right, 0);
            } else {
                return com(root.left, sum - root.val) + com(root.right, sum - root.val);
            }
        }

        return 0;
    }

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return count;
        }
        int tmp = com(root, sum);
        if (tmp != 0) {
            count += tmp;
        }
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return count;

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        two.right = three;
        root.right = two;
        System.out.println(pathSum(root, 3));
    }
}
