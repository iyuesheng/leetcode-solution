package cn.iisheng.solution.stack;

import cn.iisheng.solution.common.TreeNode;
import cn.iisheng.solution.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author iisheng
 * @date 2019/10/21 13:03:53
 */
public class No_0145_BinaryTreePostorderTraversal {

    /**
     * 从根节点开始，访问节点的孩子，然后是该节点。（左 -> 右 -> 根）
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursion(root, result);
        return result;
    }

    public static List<Integer> postorderTraversalWithStack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack();
        // 根先进
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            // 插在list第0位
            result.add(0, root.val);
            // 左孩子 先进 后出 最后插在 第0位
            if (root.left != null) {
                stack.push(root.left);
            }
            // 右孩子 后进 先出 先插在第0位
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        return result;
    }

    public static void recursion(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            recursion(root.left, list);
        }
        if (root.right != null) {
            recursion(root.right, list);
        }
        list.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode binaryTree = TreeUtils.createBinaryTree(new Integer[]{1, null, 2, 3});
        System.out.println(postorderTraversalWithStack(binaryTree));
    }
}
