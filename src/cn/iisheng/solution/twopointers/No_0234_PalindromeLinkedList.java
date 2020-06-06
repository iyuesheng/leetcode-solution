package cn.iisheng.solution.twopointers;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.utils.ListUtils;

/**
 * @author iisheng
 * @date 2019/08/10 16:39:57
 */
public class No_0234_PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode head = ListUtils.createLinkedList(new Integer[]{1, 2, 2, 1});
        System.out.println(isPalindromeRecursion(head));
    }

    public static boolean isPalindromeRecursion(ListNode head) {
        return (head == null || head.next == null) ? true : (isPal(head, head) != null);
    }

    public static ListNode isPal(ListNode head, ListNode tail) {
        if (tail == null) {
            return head;
        }
        head = isPal(head, tail.next);
        if (head == null || head.val != tail.val) {
            return null;
        }
        return head.next == null ? head : head.next;
    }


    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        ListNode right = reverse(slow);
        ListNode left = head;

        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;

    }

    public static ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
