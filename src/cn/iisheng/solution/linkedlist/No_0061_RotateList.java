package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.utils.ListUtils;

/**
 * @author iisheng
 * @date 2020/06/03 16:01:26
 */
public class No_0061_RotateList {

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        int length = 1;
        while (cur.next != null) {
            length++;
            cur = cur.next;
        }

        int m = length - k % length;

        cur.next = head;

        for (int i = 0; i < m; i++) {
            cur = cur.next;
        }

        ListNode newHead = cur.next;
        cur.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = ListUtils.createLinkedList(new Integer[]{1, 2, 3});
        rotateRight(head, 1);
        ListUtils.print(head);
    }
}
