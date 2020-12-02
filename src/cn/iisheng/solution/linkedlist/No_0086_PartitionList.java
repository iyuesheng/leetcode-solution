package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.utils.ListUtils;

/**
 * @author iisheng
 * @date 2020/11/15 20:55:54
 */
public class No_0086_PartitionList {

    public static ListNode partition(ListNode head, int x) {
        // 定义两个虚拟的头节点 分别代表 较小和较大的链表
        ListNode smallerHead = new ListNode(0), biggerHead = new ListNode(0);
        // 定义两个遍历的（尾）节点
        ListNode smaller = smallerHead, bigger = biggerHead;
        while (head != null) {
            if (head.val < x) {
                // val < x 加入到smaller 链表后面
                smaller.next = head;
                smaller = smaller.next;
            } else {
                // 按照从右往左的顺序执行
                // val >= x 加入到bigger 链表后面
                bigger = bigger.next = head;
            }
            // 继续遍历整个链表
            head = head.next;
        }
        // 将较大的链表放到较小的链表尾部
        // 为什么是biggerHead.next 因为biggerHead是虚拟节点 biggerHead.next才是真正较大链表的第一个节点
        smaller.next = biggerHead.next;
        // bigger目前代表 原来整个链表中 val>=x 且最靠右的节点
        // 但是 这个节点 的右面可能存在 val<x 的节点
        // 所以 需要将bigger.next 设置为 null
        bigger.next = null;
        return smallerHead.next;
    }

    public static void main(String[] args) {
        ListNode head = ListUtils.createLinkedList(new Integer[]{1, 4, 3, 2, 5, 2});
        ListNode partition = partition(head, 3);
        ListUtils.print(partition);
    }
}
