package cn.iisheng.solution.stack;

import cn.iisheng.solution.common.TreeNode;
import cn.iisheng.solution.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author iisheng
 * @date 2019/10/21 09:46:44
 */
public class No_0094_BinaryTreeInorderTraversal_2023 {
    
    // 左节点 中间节点 右节点
    public static List<Integer> inorderTraversal(TreeNode root) {
        return inorderTraversal(root, new ArrayList<>());
    }
    
    public static List<Integer> inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        if (root.left != null) {
            inorderTraversal(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            inorderTraversal(root.right, list);
        }
        return list;
    }
    
    
    public static void main(String[] args) {
        TreeNode binaryTree = TreeUtils.createBinaryTree(new Integer[]{1, null, 2, 3});
        System.out.println(inorderTraversal(binaryTree));
    }
}
