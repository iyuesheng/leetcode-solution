package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.utils.ListUtils;

/**
 * @author iisheng
 * @date 2019/08/10 16:55:14
 */
public class No_0206_ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        // 定义一个新 头结点 代表反转后的链表的头结点
        ListNode newHead = null;
        while (head != null) {
            // 定义一个结点变量 代表 head 的next结点
            ListNode next = head.next;
            // 将head 的next 指向 新的头结点
            head.next = newHead;
            // 将新头结点 指向 head  相当于将 一个个遍历的结点 一个个 插入 新链表的头结点上
            newHead = head;
            // 将head 指向下一个 结点
            head = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = ListUtils.createLinkedList(new Integer[]{1, 2, 3, 4, 5, null});
        ListUtils.print(head);
        ListNode reverseList = reverseList(head);
        ListUtils.print(reverseList);
    }
}