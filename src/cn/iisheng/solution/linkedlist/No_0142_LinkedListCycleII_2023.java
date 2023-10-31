package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;

/**
 * @author iisheng
 * @date 2020/12/19 22:18:44
 */
public class No_0142_LinkedListCycleII_2023 {
    
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
    
}
