package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;

import java.util.HashMap;

/**
 * @author iisheng
 * @date 2020/12/19 23:40:41
 */
public class No_1171_RemoveZeroSumConsecutiveNodesfromLinkedList {
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap();
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy;
        int sum = 0;
        while (cur != null) {
            sum += cur.val;
            map.put(sum, cur);
            cur = cur.next;
        }

        sum = 0;
        cur = dummy;
        while (cur != null) {
            sum += cur.val;
            cur.next = map.get(sum).next;
            cur = cur.next;
        }

        return dummy.next;
    }

}
