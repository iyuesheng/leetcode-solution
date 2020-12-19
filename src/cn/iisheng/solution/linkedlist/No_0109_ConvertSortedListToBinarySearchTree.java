package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.common.TreeNode;
import cn.iisheng.solution.utils.ListUtils;
import cn.iisheng.solution.utils.TreeUtils;

/**
 * @author iisheng
 * @date 2020/12/19 16:42:26
 */
public class No_0109_ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        ListNode head = ListUtils.createLinkedList(new Integer[]{-10, -3, 0, 5, 9});
        TreeNode node = sortedListToBST(head);
        TreeUtils.print(node);
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return toBST(head, null);
    }

    private static TreeNode toBST(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;

        if (head == tail) {
            return null;
        }

        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = toBST(head, slow);
        root.right = toBST(slow.next, tail);

        return root;
    }
}
