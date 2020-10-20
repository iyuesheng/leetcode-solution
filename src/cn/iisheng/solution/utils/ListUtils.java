package cn.iisheng.solution.utils;

import cn.iisheng.solution.common.ListNode;

/**
 * @author iisheng
 * @date 2019/08/14 18:18:32
 */
public class ListUtils {

    /**
     * 尾插法创建单链表
     * @param values
     * @return
     */
    public static ListNode createLinkedList(Integer[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        ListNode tail = head;
        for (int i = 1; i < values.length; i++) {
            if (values[i] != null) {
                ListNode cur = new ListNode(values[i]);
                tail.next = cur;
                tail = tail.next;
            }
        }
        return head;
    }


    /**
     * 头插法创建单链表
     * @param values
     * @return
     */
    public static ListNode headCreateLinkedList(Integer[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        for (int i = 1; i < values.length; i++) {
            if (values[i] != null) {
                ListNode cur = new ListNode(values[i]);
                cur.next = head;
                head = cur;
            }
        }
        return head;
    }


    public static void print(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
