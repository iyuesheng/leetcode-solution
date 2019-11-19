package cn.iisheng.solution.dfs;

import cn.iisheng.solution.common.TreeNode;
import cn.iisheng.solution.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author iisheng
 * @date 2019/10/11 22:20:18
 */
public class No_0113_PathSumII {

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(result, root, sum, new ArrayList<>());

        return result;
    }

    public static void dfs(List<List<Integer>> result, TreeNode root, int sum, List<Integer> temp) {
        if (root == null) {
            return;
        }
        // 每一次 调用 都将 root.val 加入 temp 列表中
        temp.add(root.val);
        if (root.left == null && root.right == null) {
            // 满足条件 将整个列表 放入 result 中
            if (root.val == sum) {
                result.add(new ArrayList<>(temp));
            }
        } else {
            // 左孩子 不空就继续调用左孩子
            if (root.left != null) {
                dfs(result, root.left, sum - root.val, temp);
                // 调用结束后 将这次调用 添加到数组中的元素 移出
                temp.remove(temp.size() - 1);
            }
            // 右孩子 不空就继续调用右孩子
            if (root.right != null) {
                dfs(result, root.right, sum - root.val, temp);
                // 调用结束后 将这次调用 添加到数组中的元素 移出
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.createBinaryTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        System.out.println(pathSum(root, 22));
    }


}
