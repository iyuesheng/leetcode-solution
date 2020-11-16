package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.utils.ListUtils;

import java.util.*;

/**
 * @author iisheng
 * @date 2020/11/16 08:20:15
 */
public class No_0445_AddTwoNumbersII {

    public static void main(String[] args) {
        ListNode l1 = ListUtils.createLinkedList(new Integer[]{7, 2, 4, 3});
        ListNode l2 = ListUtils.createLinkedList(new Integer[]{5, 6, 4});
        ListUtils.print(addTwoNumbers(l1, l2));
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rl1 = reverse(l1, null);
        ListNode rl2 = reverse(l2, null);

        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int carry = 0;
        while (rl1 != null || rl2 != null || carry != 0) {
            int sum = carry;
            if (rl1 != null) {
                sum += rl1.val;
                rl1 = rl1.next;
            }
            if (rl2 != null) {
                sum += rl2.val;
                rl2 = rl2.next;
            }
            cur.next = new ListNode(sum % 10);
            carry = sum / 10;
            cur = cur.next;
        }
        return reverse(head.next, null);
    }

    private static ListNode reverse(ListNode node, ListNode prev) {
        if (node == null) {
            return null;
        }
        ListNode res = reverse(node.next, node);

        node.next = prev;

        return res == null ? node : res;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        Stack<Integer> stack2 = new Stack<>();
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry == 1) {
            int num1 = 0;
            int num2 = 0;
            if (!stack1.isEmpty()) {
                num1 = stack1.pop();
            }
            if (!stack2.isEmpty()) {
                num2 = stack2.pop();
            }
            int temp = num1 + num2 + carry;
            carry = 0;
            if (temp >= 10) {
                temp -= 10;
                carry = 1;
            }
            if (head == null) {
                head = new ListNode(temp);
            } else {
                ListNode node = new ListNode(temp);
                node.next = head;
                head = node;
            }
        }

        return head;
    }
}
