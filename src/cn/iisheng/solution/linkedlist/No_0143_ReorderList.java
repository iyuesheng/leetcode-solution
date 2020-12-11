package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.utils.ListUtils;

/**
 * @author iisheng
 * @date 2020/12/10 19:20:47
 */
public class No_0143_ReorderList {

    /**
     * 1. 找到链表中间节点
     * 2. 反转中间节点后面的子链表
     * 3. 排序（可以用前后两个链表合并）
     *
     * @param head
     */
    public static void reorderList(ListNode head) {
        if(head==null||head.next==null){
            return;
        }

        // 找到链表中间节点
        ListNode p1 = head, p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        // 链表反转
        ListNode preMiddle = p1;
        ListNode preCurrent = p1.next;
        while (preCurrent.next != null) {
            ListNode current = preCurrent.next;
            preCurrent.next = current.next;
            current.next = preMiddle.next;
            preMiddle.next = current;
        }

        // 排序（合并链表）

        p1 = head;
        p2 = preMiddle.next;
        while (p1 != preMiddle) {
            preMiddle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMiddle.next;
        }

    }

    public static void main(String[] args) {
        ListNode head = ListUtils.createLinkedList(new Integer[]{1, 4, 2, 3});
        reorderList(head);
        ListUtils.print(head);
    }
}
