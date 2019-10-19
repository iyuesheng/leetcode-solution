package cn.iisheng.solution.dfs;

import cn.iisheng.solution.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author iisheng
 * @date 2019/10/14 18:45:38
 */
public class No_0257_BinaryTreePaths {

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, new StringBuilder(), result);

        return result;
    }

    public static void dfs(TreeNode node, StringBuilder sb, List<String> result) {

        if (node.left == null && node.right == null) {
            sb.append(node.val);
            result.add(sb.toString());
            return;
        }
        sb.append(node.val);
        sb.append("->");
        if (node.left != null) {
            dfs(node.left, new StringBuilder(sb), result);
        }
        if (node.right != null) {
            dfs(node.right, new StringBuilder(sb), result);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode five = new TreeNode(5);
        TreeNode seven = new TreeNode(7);
        left.right = five;
        left.left = seven;
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        binaryTreePaths(root);

    }
}
