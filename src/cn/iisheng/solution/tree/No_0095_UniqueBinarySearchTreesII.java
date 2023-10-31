package cn.iisheng.solution.tree;

import cn.iisheng.solution.common.TreeNode;
import cn.iisheng.solution.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author iisheng
 * @date 2022/09/13 14:52:01
 */
public class No_0095_UniqueBinarySearchTreesII {
    
    public TreeNode helper(int start, int end) {
        if (start > end) {
            return null;
        }
        // 这里可以选择start到end的任何一个值做根节点
        // 这里选择他们的中点，实际上，这样构造出来的是一颗平衡二叉搜索树
        int val = (start + end) / 2;
        TreeNode root = new TreeNode(val);
        
        root.left = helper(start, val - 1);
        root.right = helper(val + 1, end);
        
        return root;
    }
    
    public List<TreeNode> generateTrees(int n) {
        return helperV2(1, n);
    }
    
    public List<TreeNode> helperV2(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            // 如果当前子树为空 不加null行吗？
            list.add(null);
            return list;
        }
        
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = helperV2(start, i - 1);
            List<TreeNode> right = helperV2(i + 1, end);
            
            // 固定左孩子，遍历右孩子
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        
        return list;
    }
    
    public static void main(String[] args) {
        List<TreeNode> treeNodes = new No_0095_UniqueBinarySearchTreesII().generateTrees(3);
        for (TreeNode t : treeNodes) {
            TreeUtils.print(t);
        }
    }
}
