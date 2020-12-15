package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.utils.ListUtils;

/**
 * @author iisheng
 * @date 2020/12/15 15:37:06
 */
public class No_0025_ReverseNodesInKGroup {

    /**
     * 0 ms
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup4(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) return head;
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    /**
     * 反转区间 [a, b) 的元素，注意是左闭右开
     */
    public static ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;
        // while 终止的条件改一下就行了
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }

    public static ListNode reverse2(ListNode begin, ListNode end) {
        ListNode curr = begin.next;
        ListNode next, first;
        ListNode prev = begin;
        first = curr;
        while (curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev;
        first.next = curr;
        return first;
    }


    /**
     * 1 ms
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup3(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;

            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }


    public static ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode tail = dummy, prev = dummy, temp;
        int count;
        while (true) {
            count = k;
            while (count > 0 && tail != null) {
                count--;
                tail = tail.next;
            }
            if (tail == null) {
                // Has reached the end
                break;
            }


            // for next cycle
            head = prev.next;
            // prev-->temp-->...--->....--->tail-->....
            // Delete @temp and insert to the next position of @tail
            // prev-->...-->...-->tail-->head-->...
            // Assign @temp to the next node of @prev
            // prev-->temp-->...-->tail-->...-->...
            // Keep doing until @tail is the next node of @prev
            while (prev.next != tail) {
                // Assign
                temp = prev.next;
                // Delete
                prev.next = temp.next;

                temp.next = tail.next;
                //Insert
                tail.next = temp;
            }

            tail = head;
            prev = head;

        }
        return dummy.next;

    }


    /**
     * 0 ms
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head;
        int count = 0;

        // find the k+1 node
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }

        // if k+1 node is found
        if (count == k) {
            // reverse list with k+1 node as head
            curr = reverseKGroup(curr, k);
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            // reverse current k-group:
            while (count-- > 0) {
                // tmp - next head in direct part
                ListNode tmp = head.next;
                // preappending "direct" head to the reversed list
                head.next = curr;
                // move head of reversed part to a new node
                curr = head;
                // move "direct" head to the next node in direct part
                head = tmp;
            }
            head = curr;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode head = ListUtils.createLinkedList(new Integer[]{0, 1, 2, 3, 4, 5, 6});
        ListNode reverse = reverse2(head, head.next.next.next.next);
        ListUtils.print(reverse);
//        ListUtils.print(reverseKGroup(head, 2));
    }
}
