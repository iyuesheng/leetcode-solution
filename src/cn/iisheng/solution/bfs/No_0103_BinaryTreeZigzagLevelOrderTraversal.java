package cn.iisheng.solution.bfs;

import cn.iisheng.solution.common.TreeNode;
import cn.iisheng.solution.utils.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author iisheng
 * @date 2019/11/19 22:15:58
 */
public class No_0103_BinaryTreeZigzagLevelOrderTraversal {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        // 如果root为空直接返回
        if (root == null) {
            return res;
        }

        // 利用队列的先进先出 按层把 节点 分别入队列
        LinkedList<TreeNode> queue = new LinkedList();
        // 根节点 首先入队列
        queue.offer(root);

        // 标志 该层 是按照 从左往右的顺序添加 还是 从右往左
        boolean isLeftToRight = true;

        // 遍历队列元素 直到队列为空
        while (!queue.isEmpty()) {
            // 定义临时 LinkedList 存放 当前 层 节点的值
            LinkedList<Integer> temp = new LinkedList<>();
            int size = queue.size();

            while (size > 0) {
                // 从队列头取出头节点
                TreeNode current = queue.poll();
                // 根据不同的规则 插入 LinkedList 的方向不同
                if (isLeftToRight) {
                    temp.add(current.val);
                } else {
                    temp.addFirst(current.val);
                }

                // 左孩子入队列
                if (current.left != null) {
                    queue.offer(current.left);
                }
                // 右孩子入队列
                if (current.right != null) {
                    queue.offer(current.right);
                }
                size--;
            }
            isLeftToRight = !isLeftToRight;
            // 将当前层 加入 结果集中
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode binaryTree = TreeUtils.createBinaryTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(zigzagLevelOrder(binaryTree));
    }
}
