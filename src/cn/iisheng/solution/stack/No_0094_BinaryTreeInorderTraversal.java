package cn.iisheng.solution.stack;

import cn.iisheng.solution.common.TreeNode;
import cn.iisheng.solution.utils.TreeUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author iisheng
 * @date 2019/10/21 09:46:44
 */
public class No_0094_BinaryTreeInorderTraversal {

    /**
     * 从根节点开始，访问节点的左孩子，然后是该节点，再然后是任何剩余节点。（左 -> 根 -> 右）
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursion(root, list);
        return list;
    }

    public static List<Integer> inorderTraversalWithStack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                // 根先进 左孩子后进 左孩子先出 根后出
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            // 根 出  右孩子 进
            root = root.right;
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
        list.add(root.val);
        if (root.right != null) {
            recursion(root.right, list);
        }
    }

    public static void main(String[] args) {
        TreeNode binaryTree = TreeUtils.createBinaryTree(new Integer[]{1, null, 2, 3});
        System.out.println(inorderTraversalWithStack(binaryTree));
    }
}
