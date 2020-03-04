package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.utils.ListUtils;

/**
 * @author iisheng
 * @date 2020/03/04 23:14:51
 */
public class No_0876_MiddleOfTheLinkedList {

    public static void main(String[] args) {
        ListNode linkedList = ListUtils.createLinkedList(new Integer[]{1, 2, 3, 4, 5, null});
        ListUtils.print(linkedList);
        linkedList = middleNode(linkedList);
        ListUtils.print(linkedList);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode once = head;
        ListNode twice = head;
        while (true) {
            twice = twice.next;
            if (twice == null) {
                return once;
            }
            twice = twice.next;
            if (twice == null) {
                return once.next;
            }
            once = once.next;
        }
    }
}
