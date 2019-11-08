package cn.iisheng.solution.utils;

import cn.iisheng.solution.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author iisheng
 * @date 2019/08/14 16:03:04
 */
public class TreeUtils {

    public static TreeNode createBinaryTree(Integer[] values) {

        if (values == null || values.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 0;

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (++index == values.length) {
                break;
            }

            if (values[index] != null) {
                node.left = new TreeNode(values[index]);
                nodeQueue.add(node.left);
            }

            if (++index == values.length) {
                break;
            }

            if (values[index] != null) {
                node.right = new TreeNode(values[index]);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static TreeNode getFirstNode(TreeNode root, int val) {

        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        TreeNode left = getFirstNode(root.left, val);
        if (left != null) {
            return left;
        }

        TreeNode right = getFirstNode(root.right, val);
        if (right != null) {
            return right;
        }

        return null;
    }


    public static void print(TreeNode root) {
        TreeNode node = root;
        LinkedList<TreeNode> list = new LinkedList();
        list.add(node);

        while (!list.isEmpty()) {
            node = list.poll();
            System.out.print(node.val + " ");

            if (node.left != null) {
                list.offer(node.left);
            }
            if (node.right != null) {
                list.offer(node.right);
            }
        }

        System.out.println();
    }

}
