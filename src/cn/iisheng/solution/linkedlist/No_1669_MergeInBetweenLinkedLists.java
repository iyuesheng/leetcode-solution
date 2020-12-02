package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.utils.ListUtils;

/**
 * @author iisheng
 * @date 2020/12/02 07:48:30
 */
public class No_1669_MergeInBetweenLinkedLists {


    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // 假设第a个节点 叫做 A节点 第b个节点叫做 B节点
        // 根据题意 找到 A节点前面节点的指针 定义为 nodeAPre
        // 再找到第b个节点指针 nodeB
        // 然后遍历得到list2的尾节点 tail2
        // 最后 nodeAPre.next = list2   tail2.next = nodeB.next

        ListNode head1 = list1;
        ListNode last = null;
        // A节点前面节点的指针
        ListNode nodeAPre = null;
        // B节点
        ListNode nodeB = null;
        // 遍历的游标 为了查找 A、B节点位置
        int cur = 0;

        while (head1 != null) {
            if (a == cur) {
                nodeAPre = last;
            }
            if (b == cur) {
                nodeB = head1;
            }
            cur++;
            if (nodeAPre == null) {
                last = head1;
            }
            head1 = head1.next;
            if (nodeAPre != null && nodeB != null) {
                break;
            }
        }


        // 定义tail2 是list2的头节点
        ListNode tail2 = list2;
        while (tail2.next != null) {
            // 遍历到list2的尾节点赋值给tail2
            tail2 = tail2.next;
        }

        // 节点A前面的节点 指向list2
        nodeAPre.next = list2;
        // list2的尾部节点 指向 B节点的next
        tail2.next = nodeB.next;
        return list1;
    }

    public static void main(String[] args) {
        ListNode list1 = ListUtils.createLinkedList(new Integer[]{0, 1, 2, 3, 4, 5});
        ListNode list2 = ListUtils.createLinkedList(new Integer[]{1000000, 1000001, 1000002});
        ListUtils.print(mergeInBetween(list1, 3, 4, list2));
    }
}
