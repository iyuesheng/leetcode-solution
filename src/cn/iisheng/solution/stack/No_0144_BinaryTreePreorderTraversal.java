package cn.iisheng.solution.stack;

import cn.iisheng.solution.common.TreeNode;
import cn.iisheng.solution.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author iisheng
 * @date 2019/10/21 10:44:53
 */
public class No_0144_BinaryTreePreorderTraversal {

    /**
     * 从根节点开始，访问每一个节点及其孩子。（根 -> 左 -> 右）
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursion(root, result);
        return result;
    }

    public static List<Integer> preorderTraversalWithStack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack();
        // 根节点 最先入栈
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            // 遍历 根节点
            result.add(root.val);
            // 右节点先入栈 后遍历
            if (root.right != null) {
                stack.push(root.right);
            }
            // 左节点后入栈 先遍历
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return result;
    }

    public static void recursion(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        if (root.left != null) {
            recursion(root.left, result);
        }
        if (root.right != null) {
            recursion(root.right, result);
        }
    }

    public static void main(String[] args) {
        TreeNode binaryTree = TreeUtils.createBinaryTree(new Integer[]{1, null, 2, 3});
        System.out.println(preorderTraversalWithStack(binaryTree));
    }
}
