package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.utils.ListUtils;

/**
 * @author iisheng
 * @date 2019/08/10 16:55:14
 */
public class No_0206_ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        // 整体思路
        // 定义一个 新的头节点
        // 遍历 原链表 一个一个 加到新的头节点的前面 即可 实现 反转

        // 定义一个新的头节点
        ListNode newHead = null;

        // 从头到尾遍历原链表 所有节点
        while (head != null) {
            // 定义一个临时节点 存放 head 节点 之后的 链表数据
            ListNode temp = head.next;
            // 将当前 节点（原链表遍历到的一个节点） 放到 新的头节点的前面
            head.next = newHead;
            // 将head 节点 赋值 给 newHead，newHead节点做反转后的头节点
            newHead = head;
            // 将temp 链表 赋值给 head 继续完成遍历
            head = temp;
        }
        return newHead;
    }

    public static ListNode reverseList1(ListNode head) {
        // 递归写法 基于循环写法的改变
        return recursion(head, null);
    }

    public static ListNode recursion(ListNode head, ListNode newHead) {
        // 相当于循环到原链表的最后一个节点
        if (head == null) {
            return newHead;
        } else {
            // 相当于 while 循环内部的逻辑

            // 定义一个临时节点 存放 head 节点 之后的 链表数据
            ListNode temp = head.next;
            // 将当前 节点（原链表递归到的一个节点） 放到 新的头节点的前面
            head.next = newHead;
            // 将head 节点 赋值 给 newHead，newHead节点做反转后的头节点
            newHead = head;
            // 将temp 链表 赋值给 head 继续完成递归
            head = temp;
            return recursion(head, newHead);
        }
    }


    public static void main(String[] args) {
        ListNode head = ListUtils.createLinkedList(new Integer[]{1, 2, 3, 4, 5, null});
        ListUtils.print(head);
        ListNode reverseList = reverseList1(head);
        ListUtils.print(reverseList);
    }
}