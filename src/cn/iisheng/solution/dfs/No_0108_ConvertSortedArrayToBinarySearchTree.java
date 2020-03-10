package cn.iisheng.solution.dfs;

import cn.iisheng.solution.common.TreeNode;
import cn.iisheng.solution.utils.TreeUtils;

/**
 * @author iisheng
 * @date 2020/03/10 23:10:05
 */
public class No_0108_ConvertSortedArrayToBinarySearchTree {

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return dfs(nums, 0, nums.length - 1);
    }

    public static TreeNode dfs(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, start, mid - 1);
        root.right = dfs(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        TreeUtils.print(sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }
}
