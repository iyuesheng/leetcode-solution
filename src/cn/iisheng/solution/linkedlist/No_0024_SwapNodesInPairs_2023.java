package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.utils.ListUtils;

/**
 * @author iisheng
 * @date 2020/06/04 11:08:26
 */
public class No_0024_SwapNodesInPairs_2023 {
    
    public static ListNode swapPairs(ListNode head) {
        if(head==null|| head.next==null){
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
    
    public static void main(String[] args) {
        ListNode head = ListUtils.createLinkedList(new Integer[]{1, 2, 3, 4});
        ListNode swap = swapPairs(head);
        ListUtils.print(swap);
    }
}
