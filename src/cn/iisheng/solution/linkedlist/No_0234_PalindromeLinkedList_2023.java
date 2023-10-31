package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.utils.ListUtils;

/**
 * @author iisheng
 * @date 2023/10/16 10:26:48
 */
public class No_0234_PalindromeLinkedList_2023 {
    
    public static boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        int index = 0;
        while (temp != null) {
            index++;
            temp = temp.next;
        }
        int right = index % 2 == 0 ? index / 2 : index / 2 + 1;
        temp = head;
        for (int i = 0; i < right; i++) {
            temp = temp.next;
        }
        temp = reverseList(temp);
        for (int i = 0; i < index / 2; i++) {
            if (temp.val == head.val) {
            
            } else {
                return false;
            }
            temp = temp.next;
            head = head.next;
        }
        return true;
    }
    
    public static ListNode reverseList(ListNode head) {
        ListNode result = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = result;
            result = cur;
            cur = temp;
        }
        return result;
    }
    
    public static void main(String[] args) {
        ListNode head = ListUtils.createLinkedList(new Integer[]{1, 1, 2, 1});
        System.out.println(isPalindrome(head));
        ListNode head1 = ListUtils.createLinkedList(new Integer[]{1, 2, 2, 1});
        System.out.println(isPalindrome(head1));
        ListNode head2 = ListUtils.createLinkedList(new Integer[]{1, 2, 1});
        System.out.println(isPalindrome(head2));
    }
}
