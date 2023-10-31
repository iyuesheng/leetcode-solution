package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.utils.ListUtils;

/**
 * @author iisheng
 * @date 2020/06/03 16:40:47
 */
public class No_0019_RemoveNthNodeFromEndOfList_2023 {
    
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        if (n == 1 && size == 1) {
            return null;
        }
        temp = new ListNode(-1);
        temp.next = head;
        ListNode result = temp;
        for (int i = 0; i < size - n; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return result.next;
    }
    
    public static void main(String[] args) {
        ListNode head = ListUtils.createLinkedList(new Integer[]{1});
        ListNode remove = removeNthFromEnd(head, 1);
        ListUtils.print(remove);
    }
}
