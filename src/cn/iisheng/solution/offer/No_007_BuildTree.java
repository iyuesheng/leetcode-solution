package cn.iisheng.solution.offer;

import cn.iisheng.solution.common.TreeNode;

import java.util.HashMap;

/**
 * @author iisheng
 * @date 2022/08/30 14:18:17
 */
public class No_007_BuildTree {
    
    HashMap<Integer, Integer> map = new HashMap();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        int length = preorder.length;
        for (int i = 0; i < length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, length - 1, 0, length - 1);
    }
    
    /**
     * 重建二叉树思路
     * 1. 根据先序遍历 可知道 root节点 是preorder[0]
     * 2. 找到root节点之后，通过遍历中序遍历，可知道，中序遍历中，哪些节点是左子树上的节点，哪个节点是root节点，哪些是右子树上的节点
     * 3. 循环分治步骤2
     */
    public TreeNode build(int[] preorder, int[] inorder, int pre_left, int pre_right, int in_left, int in_right) {
        if (pre_left > pre_right) {
            return null;
        }
        if (in_left > in_right) {
            return null;
        }
        int rootIndex = pre_left;
        int rootValue = preorder[rootIndex];
        
        TreeNode root = new TreeNode(rootValue);
        int inOrderRootIndex = map.get(rootValue);
        
        
        int leftSize = inOrderRootIndex - in_left;
        
        if (leftSize > 0) {
            root.left = build(preorder, inorder, pre_left + 1, pre_left + leftSize, in_left, inOrderRootIndex - 1);
        }
        root.right = build(preorder, inorder, pre_left + leftSize + 1, pre_right, inOrderRootIndex + 1, in_right);
        return root;
    }
    
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

//        int[] preorder = {1, 2};
//        int[] inorder = {1, 2};

//        int[] preorder = {1, 2, 3};
//        int[] inorder = {3, 2, 1};
        TreeNode treeNode = new No_007_BuildTree().buildTree(preorder, inorder);
    }
}
