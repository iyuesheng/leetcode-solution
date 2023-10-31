package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.utils.ListUtils;

/**
 * @author iisheng
 * @date 2019/08/10 16:55:14
 */
public class No_0206_ReverseLinkedList_2023 {
    
    public static ListNode reverseList(ListNode head) {
        ListNode result = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = result;
            result = head;
            head = temp;
        }
        return result;
    }
    
    
    public static void main(String[] args) {
        ListNode head = ListUtils.createLinkedList(new Integer[]{1, 2, 3, 4, 5, null});
        ListUtils.print(head);
        ListNode reverseList = reverseList(head);
        ListUtils.print(reverseList);
    }
}