package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.utils.ListUtils;

import java.util.Stack;

/**
 * @author iisheng
 * @date 2020/11/15 21:22:39
 */
public class No_1290_ConvertBinaryNumberInALinkedListToInteger {

    public static void main(String[] args) {
        ListNode head = ListUtils.createLinkedList(new Integer[]{1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0});
        System.out.println(getDecimalValue5(head));
    }

    public static int getDecimalValue(ListNode head) {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }

        int index = 0;
        int sum = 0;
        while (head != null) {
            int value = (int) (head.val * (Math.pow(2, count - index - 1)));
            sum += value;
            head = head.next;
            index++;
        }

        return sum;
    }

    public static int result = 0;
    public static int idx = 0;

    public static int getDecimalValue1(ListNode head) {
        if (head == null) {
            idx = 0;
            return 0;
        }
        int add = getDecimalValue1(head.next);
        return head.val * (int) Math.pow(2, idx++) + add;
    }

    public static int getDecimalValue2(ListNode head) {
        int num = head.val;
        while (head.next != null) {
            num = num * 2 + head.next.val;
            head = head.next;
        }
        return num;
    }

    public static int getDecimalValue3(ListNode head) {
        // Using Bit Manipulation
        int num = head.val;
        while (head.next != null) {
            num = (num << 1) ^ head.next.val;
            head = head.next;
        }
        return num;
    }

    public static int getDecimalValue4(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int res = 0, count = 0;
        while (!stack.isEmpty()) {
            res += stack.pop() << count;
            count++;
        }
        return res;
    }

    public static int getDecimalValue5(ListNode head) {
        int res = 0;

        while (head != null) {
            res <<= 1;
            res += head.val;
            head = head.next;
        }

        return res;

    }
}
