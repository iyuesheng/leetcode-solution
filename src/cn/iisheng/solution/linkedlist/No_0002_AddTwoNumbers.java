package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;

import java.util.*;

/**
 * @author iisheng
 * @date 2019/10/19 11:21:33
 */
public class No_0002_AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<Integer> queue1 = new ArrayDeque<>();
        while (l1 != null) {
            queue1.add(l1.val);
            l1 = l1.next;
        }
        Queue<Integer> queue2 = new ArrayDeque<>();
        while (l2 != null) {
            queue2.add(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        List<Integer> list = new ArrayList<>();
        while (!queue1.isEmpty() || !queue2.isEmpty() || carry == 1) {
            int num1 = 0;
            int num2 = 0;
            if (!queue1.isEmpty()) {
                num1 = queue1.poll();
            }
            if (!queue2.isEmpty()) {
                num2 = queue2.poll();
            }
            int temp = num1 + num2 + carry;
            carry = 0;
            if (temp >= 10) {
                temp -= 10;
                carry = 1;
            }
            list.add(temp);
        }

        if (list.size() == 0) {
            return null;
        }

        ListNode head = new ListNode(list.get(0));
        ListNode tail = head;
        for (int i = 1; i < list.size(); i++) {
            ListNode node = new ListNode(list.get(i));
            tail.next = node;
            tail = tail.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l111 = new ListNode(3);
        l11.next = l111;
        l1.next = l11;

        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l222 = new ListNode(4);
        l22.next = l222;
        l2.next = l22;


        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}
