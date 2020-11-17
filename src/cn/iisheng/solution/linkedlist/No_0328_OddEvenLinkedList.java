package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.utils.ListUtils;

/**
 * @author iisheng
 * @date 2020/11/16 22:32:08
 */
public class No_0328_OddEvenLinkedList {

    public static ListNode oddEvenList(ListNode head) {
        if (head != null) {
            ListNode odd = head, even = odd.next, evenHead = even;
            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListUtils.createLinkedList(new Integer[]{1, 2, 3, 4, 5});
        ListUtils.print(oddEvenList(head));
    }
}
