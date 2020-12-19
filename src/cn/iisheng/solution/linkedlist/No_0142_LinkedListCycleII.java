package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;

/**
 * @author iisheng
 * @date 2020/12/19 22:18:44
 */
public class No_0142_LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
    }

}
