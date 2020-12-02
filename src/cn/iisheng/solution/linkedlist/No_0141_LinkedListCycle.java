package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.utils.ListUtils;

/**
 * @author iisheng
 * @date 2019/10/09 18:05:49
 */
public class No_0141_LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (true) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
    }

    public static void main(String[] args) {
        ListNode head = ListUtils.headCreateLinkedList(new Integer[]{3, 2, 0, -4});
        ListUtils.print(head);
    }

}
