package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.utils.ListUtils;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author iisheng
 * @date 2020/12/02 15:01:06
 */
public class No_0023_MergeKSortedLists {

    public static ListNode mergeKLists3(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);
    }

    public static ListNode partition(ListNode[] lists, int s, int e) {
        if (s == e) {
            return lists[s];
        }
        if (s < e) {
            int q = (s + e) / 2;
            ListNode l1 = partition(lists, s, q);
            ListNode l2 = partition(lists, q + 1, e);
            return merge(l1, l2);
        } else {
            return null;
        }
    }

    // This function is from Merge Two Sorted Lists.
    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    public static ListNode mergeKLists2(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode result = dummyHead;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            result.next = node;
            result = result.next;

            if (node.next != null) {
                pq.add(node.next);
            }
        }

        return dummyHead.next;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0), head = new ListNode(0), prev;
        dummy.next = heap.peek();
        while (!heap.isEmpty()) {
            prev = head;
            head = heap.poll();
            prev.next = head;
            if (head.next != null) {
                heap.offer(head.next);
            }
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode head1 = ListUtils.createLinkedList(new Integer[]{1, 4, 5});
        ListNode head2 = ListUtils.createLinkedList(new Integer[]{1, 3, 4});
        ListNode head3 = ListUtils.createLinkedList(new Integer[]{2, 6});
        ListNode[] lists = new ListNode[]{head1, head2, head3};
        ListUtils.print(mergeKLists3(lists));
    }
}
