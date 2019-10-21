package cn.iisheng.solution.bfs;

import cn.iisheng.solution.common.TreeNode;
import cn.iisheng.solution.utils.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author iisheng
 * @date 2019/10/21 13:51:55
 */
public class No_0102_BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        levelOrderHelper(res, root, 0);
        return res;
    }

    public void levelOrderHelper(List<List<Integer>> res, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (res.size() <= depth) {
            // 当前层的第一个节点，需要new一个list来存当前层
            res.add(new ArrayList<>());
        }
        // dept层把当前的节点加入
        res.get(depth).add(root.val);
        // 递归遍历下一层
        levelOrderHelper(res, root.left, depth + 1);
        levelOrderHelper(res, root.right, depth + 1);

    }


    public static List<List<Integer>> levelOrderWithQueue(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentRes = new LinkedList<>();
            // 当前队列的大小就是上一层节点个数，依次出队
            while (size > 0) {
                TreeNode current = queue.poll();
                if (current == null) {
                    continue;
                }
                currentRes.add(current.val);
                // 左子树和右子树入队
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                size--;
            }
            res.add(currentRes);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode binaryTree = TreeUtils.createBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(levelOrderWithQueue(binaryTree));
    }
}
