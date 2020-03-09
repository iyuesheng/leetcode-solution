package cn.iisheng.solution.tree;

import cn.iisheng.solution.common.TreeNode;
import cn.iisheng.solution.utils.TreeUtils;

/**
 * @author iisheng
 * @date 2020/03/08 17:37:25
 */
public class No_0538_ConvertBSTToGreaterTree {

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.createBinaryTree(new Integer[]{5, 2, 13});
        TreeNode result = convertBST(treeNode);
        TreeUtils.print(result);
    }

    static int sum = 0;

    public static TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            int value = root.val;
            root.val += sum;
            sum += value;
            convertBST(root.left);
        }
        return root;
    }
}
