package cn.iisheng.solution.offer;

import cn.iisheng.solution.common.TreeNode;
import cn.iisheng.solution.utils.TreeUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author iisheng
 * @date 2022/09/13 16:43:27
 */
public class NO_100_BinaryTreeTraverse {
    
    /**
     * 二叉树先序遍历
     * 先遍历根节点、左孩子、最后右孩子
     *
     * @param root
     */
    public static List<Integer> preorder(TreeNode root, List<Integer> result) {
        
        if (root == null) {
            return result;
        }
        result.add(root.val);
        if (root.left != null) {
            preorder(root.left, result);
        }
        if (root.right != null) {
            preorder(root.right, result);
        }
        return result;
    }
    
    /**
     * 先遍历根节点、左孩子、最后右孩子
     *
     * @param root
     * @param result
     * @return
     */
    public static List<Integer> preorderV2(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 根节点最先入栈
        stack.push(root);
        // 当栈非空就循环遍历
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            result.add(temp.val);
            // 右节点先入栈 后出栈
            if (temp.right != null) {
                stack.push(temp.right);
            }
            // 左节点 后入栈 先遍历
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return result;
    }
    
    /**
     * 二叉树中序遍历
     * 先遍历左孩子、根节点、最后右孩子
     *
     * @param root
     */
    public static List<Integer> inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        }
        if (root.left != null) {
            inorder(root.left, result);
        }
        
        result.add(root.val);
        if (root.right != null) {
            inorder(root.right, result);
        }
        return result;
    }
    
    /**
     * 二叉树中序遍历
     * 先遍历左孩子、根节点、最后右孩子
     *
     * @param root
     */
    public static List<Integer> inorderV2(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            // 跟先进 左孩子后进、跟后出 左孩子先出
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            
            // 跟出 右孩子进
            root = root.right;
        }
        return result;
    }
    
    /**
     * 二叉树后序遍历
     * 先遍历左孩子、右孩子、最后根节点
     *
     * @param root
     */
    public static List<Integer> postorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        }
        
        if (root.left != null) {
            postorder(root.left, result);
        }
        if (root.right != null) {
            postorder(root.right, result);
        }
        
        result.add(root.val);
        return result;
    }
    
    /**
     * 二叉树后序遍历
     * 先遍历左孩子、右孩子、最后根节点
     *
     * @param root
     */
    public static List<Integer> postorderV2(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            result.add(0, temp.val);
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }
        }
        return result;
    }
    
    /**
     * 二叉树后序遍历
     * 先遍历左孩子、右孩子、最后根节点
     *
     * @param root
     */
    public static List<Integer> postorderV3(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            result.add(0, temp.val);
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }
        }
        return result;
    }
    
    
    public static List<List<Integer>> levelorder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        levelorderHelper(result, root, 0);
        return result;
    }
    
    private static void levelorderHelper(List<List<Integer>> res, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        // 遍历处理之前先把 列表 创建出来
        if (res.size() <= depth) {
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val);
        // 递归调用 左孩子 右孩子 也就是 开始add 下一层节点
        levelorderHelper(res, root.left, depth + 1);
        levelorderHelper(res, root.right, depth + 1);
    }
    
    /**
     * 二叉树层序遍历
     * 从上至下，一层一层遍历二叉树
     *
     * @param root
     */
    public static List<List<Integer>> levelorderV2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> current = new LinkedList<>();
            
            while (size > 0) {
                TreeNode temp = queue.poll();
                if (temp == null) {
                    continue;
                }
                current.add(temp.val);
                // 左子树和右子树入队
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                size--;
            }
            result.add(current);
        }
        return result;
    }
    
    
    public static void main(String[] args) {
        TreeNode root = TreeUtils.createBinaryTree(new Integer[]{1, 4, 3, 2});
        List<Integer> preorder = preorderV2(root, new LinkedList<>());
        System.out.println(preorder);
        
        List<Integer> inorder = inorderV2(root, new LinkedList<>());
        System.out.println(inorder);
        
        List<Integer> postorder = postorderV2(root, new LinkedList<>());
        System.out.println(postorder);
        
        List<List<Integer>> levelorder = levelorder(root);
        System.out.println(levelorder);
    }
}
