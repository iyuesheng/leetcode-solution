package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.common.TreeNode;
import cn.iisheng.solution.utils.ListUtils;
import cn.iisheng.solution.utils.TreeUtils;

/**
 * @author iisheng
 * @date 2020/12/19 23:12:44
 */
public class No_1367_LinkedListInBinaryTree {

    public static boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return isSub(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private static boolean isSub(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }

        if (head.val != root.val) {
            return false;
        }

        return isSub(head.next, root.left) || isSub(head.next, root.right);
    }


    public static void main(String[] args) {
        ListNode head = ListUtils.createLinkedList(new Integer[]{4, 2, 8});
        TreeNode root = TreeUtils.createBinaryTree(new Integer[]{1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3});
        System.out.println(isSubPath(head, root));
    }
}
