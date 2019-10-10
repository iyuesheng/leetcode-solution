package org.dullnull.solution.linkedlist;

import org.dullnull.solution.common.ListNode;

/**
 * @author iisheng
 * @date 2019/10/10 21:10:39
 */
public class No_0160_IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // 定义两个 跟headA headB 相同的 辅助 链表
        // 同时遍历 2个辅助链表，直到 其中一个 为空，剩下的就是 另一个链表多出来的 长度
        // 从多出来的长度 开始 遍历 headA 和 headB 中 长度较长的 从头开始遍历另一个链表
        // 到 节点相同 返回 否则返回 null
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null) {
            headA = headA.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            headB = headB.next;
            p2 = p2.next;
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

}
