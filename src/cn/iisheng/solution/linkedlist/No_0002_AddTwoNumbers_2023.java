package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author iisheng
 * @date 2019/10/19 11:21:33
 */
public class No_0002_AddTwoNumbers_2023 {
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode tail = result;
        ListNode t1 = l1;
        Queue<Integer> queue = new LinkedList<>();
        while (t1 != null) {
            queue.add(t1.val);
            t1 = t1.next;
        }
        ListNode t2 = l2;
        Queue<Integer> queue2 = new LinkedList<>();
        while (t2 != null) {
            queue2.add(t2.val);
            t2 = t2.next;
        }
        boolean need = false;
        while (!queue2.isEmpty() && !queue.isEmpty()) {
            Integer q1 = queue2.poll();
            Integer q2 = queue.poll();
            int sum = Objects.nonNull(q2) && Objects.nonNull(q1) ? q1 + q2 : 0;
            if (need) {
                sum = sum + 1;
            }
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            need = sum >= 10;
        }
        while (!queue.isEmpty()) {
            int sum = queue.poll();
            if (need) {
                sum = sum + 1;
            }
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            need = sum >= 10;
        }
        while (!queue2.isEmpty()) {
            int sum = queue2.poll();
            if (need) {
                sum = sum + 1;
            }
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            need = sum >= 10;
        }
        if (need) {
            tail.next = new ListNode(1);
            tail = tail.next;
        }
        return result.next;
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l11 = new ListNode(9);
//        ListNode l111 = new ListNode(3);
//        l11.next = l111;
        l1.next = l11;
        
        ListNode l2 = new ListNode(9);
//        ListNode l22 = new ListNode(6);
//        ListNode l222 = new ListNode(4);
//        l22.next = l222;
//        l2.next = l22;
        
        
        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
        
    }
}
