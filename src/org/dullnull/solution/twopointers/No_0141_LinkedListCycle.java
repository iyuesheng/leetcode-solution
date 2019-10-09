package org.dullnull.solution.twopointers;

import org.dullnull.solution.common.ListNode;

/**
 * @author iisheng
 * @date 2019/10/09 18:05:49
 */
public class No_0141_LinkedListCycle {

    public boolean hasCycle(ListNode head) {
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

}
