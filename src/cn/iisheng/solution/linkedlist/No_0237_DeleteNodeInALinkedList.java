package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.utils.ListUtils;

/**
 * @author iisheng
 * @date 2020/03/04 23:05:24
 */
public class No_0237_DeleteNodeInALinkedList {
    public static void main(String[] args) {
        ListNode node = ListUtils.createLinkedList(new Integer[]{4, 5, 1, 9});
        ListUtils.print(node);
        deleteNode(node);
        ListUtils.print(node);
    }

    public static void deleteNode(ListNode node) {
        while (node != null) {
            node.val = node.next.val;
            if (node.next != null && node.next.next == null) {
                node.next = null;
                break;
            }
            node = node.next;
        }
    }
}
