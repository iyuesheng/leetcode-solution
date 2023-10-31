package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;

/**
 * @author iisheng
 * @date 2019/10/09 18:05:49
 */
public class No_0141_LinkedListCycle_2023 {
    
    public static boolean hasCycle(ListNode head) {
        ListNode temp = head;
        while (head != null && temp.next != null) {
            head = head.next;
            temp = temp.next.next;
            if (head == temp) {
                return true;
            }
        }
        return false;
    }
    
}
