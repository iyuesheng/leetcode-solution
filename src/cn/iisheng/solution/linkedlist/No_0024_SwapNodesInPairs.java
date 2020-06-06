package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.utils.ListUtils;

/**
 * @author iisheng
 * @date 2020/06/04 11:08:26
 */
public class No_0024_SwapNodesInPairs {

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;

        while (pre.next != null && pre.next.next != null) {
            ListNode temp = pre.next.next;
            pre.next.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
            pre = temp.next;
        }
        return dummy.next;
    }

    public static ListNode swapPairsRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        head.next = swapPairsRecursion(head.next.next);
        temp.next = head;
        return temp;
    }

    public static void main(String[] args) {
        ListNode head = ListUtils.createLinkedList(new Integer[]{1, 2, 3, 4});
        ListNode swap = swapPairs(head);
        ListUtils.print(swap);
    }
}
