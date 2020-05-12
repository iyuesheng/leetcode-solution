package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.utils.ListUtils;

/**
 * @author iisheng
 * @date 2020/05/12 23:38:10
 */
public class No_0082_RemoveDuplicatesfromSortedListII {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode dump = new ListNode(0);
        ListNode tail = dump;
        boolean isDuplicates = false;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
                isDuplicates = true;
            } else {
                if (!isDuplicates) {
                    tail.next = current;
                    tail = tail.next;
                }
                current = current.next;
                if (!isDuplicates) {
                    tail.next = null;
                }
                isDuplicates = false;
            }
        }
        if (!isDuplicates) {
            tail.next = current;
            tail = tail.next;
            if (tail != null) {
                tail.next = null;
            }
        }
        return dump.next;
    }

    public static void main(String[] args) {
        ListNode head = ListUtils.createLinkedList(new Integer[]{1, 2, 3, 3, 4, 4, 5});
        ListUtils.print(deleteDuplicates(head));
    }
}
