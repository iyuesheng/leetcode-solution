package org.dullnull.solution.linkedlist;

import org.dullnull.solution.common.ListNode;

/**
 * @author iisheng
 * @date 2019/08/10 16:55:14
 */
public class No_0206_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}