package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.utils.ListUtils;

/**
 * @author iisheng
 * @date 2020/11/17 10:42:10
 */
public class No_0147_InsertionSortList {

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;

        ListNode l1 = insertionSortList(head);
        ListNode l2 = insertionSortList(slow);
        return merge(l1, l2);
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = null, tail = null;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                ListNode temp = l1;
                l1 = l2;
                l2 = temp;
            }
            ListNode toInsert = l1;
            l1 = l1.next;
            toInsert.next = null;
            if (head == null) {
                head = tail = toInsert;
            } else {
                tail = tail.next = toInsert;
            }
        }
        if (l1 != null) {
            tail.next = l1;
        } else if (l2 != null) {
            tail.next = l2;
        }

        return head;
    }

    public static ListNode insertionSortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode tmp;
        ListNode prev;
        while (cur != null && cur.next != null) {
            if (cur.val <= cur.next.val) {
                cur = cur.next;
            } else {
                tmp = cur.next;
                // insert the tmp to the part before cur
                cur.next = cur.next.next;
                prev = dummy;
                while (prev.next.val <= tmp.val) {
                    prev = prev.next;
                }
                tmp.next = prev.next;
                prev.next = tmp;
            }
        }
        return dummy.next;
    }

    public static ListNode insertionSortList1(ListNode head) {
        if (head == null) {
            return null;
        }

        // 头节点第一个 元素 我们认为是有序的
        ListNode sort = new ListNode(head.val);
        head = head.next;
        while (head != null) {
            // prev 待插入节点的上一个节点
            // cur 有序链表 sort 的尾指针
            ListNode prev = null, cur = sort;

            // 将当前的head节点，插入到已经排好序的sort里面合适的位置
            while (cur != null && cur.val < head.val) {
                prev = cur;
                cur = cur.next;
            }

            ListNode temp = new ListNode(head.val);

            // 不存在上一个节点 就直接插入到尾节点
            if (prev == null) {
                temp.next = cur;
                sort = temp;
            } else {
                // 插入到指定位置（prev 的后面节点）
                prev.next = temp;
                temp.next = cur;
            }
            // 继续遍历 head
            head = head.next;
        }
        return sort;
    }

    public static void main(String[] args) {
        ListNode head = ListUtils.createLinkedList(new Integer[]{4, 2, 1, 3});
        ListUtils.print(insertionSortList(head));
    }
}
