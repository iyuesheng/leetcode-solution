package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.utils.ListUtils;

/**
 * @author iisheng
 * @date 2020/06/03 16:40:47
 */
public class No_0019_RemoveNthNodeFromEndOfList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode cur = head;

        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }

        if (cur == null) {
            return head.next;
        }

        while (cur.next != null) {
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListUtils.createLinkedList(new Integer[]{1});
        ListNode remove = removeNthFromEnd(head, 1);
        ListUtils.print(remove);
    }
}
