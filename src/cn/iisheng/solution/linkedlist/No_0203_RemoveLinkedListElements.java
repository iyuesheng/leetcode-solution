package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.utils.ListUtils;

/**
 * @author iisheng
 * @date 2020/11/13 08:11:23
 */
public class No_0203_RemoveLinkedListElements {

    public static ListNode removeElements(ListNode head, int val) {
        ListNode resultHead = new ListNode(0);
        ListNode tail = resultHead;
        while (head != null) {
            if (head.val != val) {
                tail.next = new ListNode(head.val);
                tail = tail.next;
                head = head.next;
            } else {
                head = head.next;
            }
        }
        return resultHead.next;
    }

    public static ListNode remove(ListNode head, int val) {
        ListNode dumpy = new ListNode(0, head);
        ListNode current = dumpy;

        while (current != null && current.next != null) {
            while (current.next != null && current.next.val == val) {
                current.next = current.next.next;
            }

            current = current.next;
        }

        return dumpy.next;
    }

    public static ListNode remove2(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        ListNode th = head;

        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        if (th.val == val) {
            th = th.next;
        }

        return th;
    }

    public static void main(String[] args) {
        ListNode head = ListUtils.createLinkedList(new Integer[]{1, 2, 6, 3, 4, 5, 6});
        ListNode node = remove2(head, 6);
        ListUtils.print(node);
    }
}
