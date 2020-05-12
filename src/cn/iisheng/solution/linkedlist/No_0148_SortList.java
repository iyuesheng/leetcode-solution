package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.utils.ListUtils;

/**
 * @author iisheng
 * @date 2020/05/11 23:34:41
 */
public class No_0148_SortList {

    /**
     * 利用归并排序的思想
     * 一：将list 拆分成2个 子list
     * 二：对子list继续拆分 直到拆分成 只含有一个元素
     * 三：合并 两个list
     *
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        ListNode one = sortList(head);
        ListNode two = sortList(slow);
        return merge(one, two);
    }

    public static ListNode merge(ListNode one, ListNode two) {
        ListNode head = null;
        ListNode tail = null;
        while (one != null || two != null) {
            ListNode cur = null;
            if (one != null && two != null) {
                if (one.val < two.val) {
                    cur = one;
                    one = one.next;
                } else {
                    cur = two;
                    two = two.next;
                }
            } else if (one != null) {
                cur = one;
                one = one.next;
            } else if (two != null) {
                cur = two;
                two = two.next;
            }
            if (tail == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                tail = tail.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        ListUtils.print(sortList(ListUtils.createLinkedList(new Integer[]{4, 2, 1, 3})));
    }
}
