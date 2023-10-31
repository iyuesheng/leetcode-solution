package cn.iisheng.solution.offer;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.utils.ListUtils;

import java.util.Arrays;

/**
 * @author iisheng
 * @date 2022/07/27 20:53:31
 */
public class No_006_ReversePrint {
    
    public static int[] reversePrint(ListNode head) {
        ListNode newHead = null;
        int len = 0;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
            len++;
        }
        int[] result = new int[len];
        int i = 0;
        while (newHead != null) {
            result[i] = newHead.val;
            newHead = newHead.next;
            i++;
        }
        return result;
    }
    
    
    public static void main(String[] args) {
        ListNode head = ListUtils.createLinkedList(new Integer[]{1, 3, 2});
        System.out.println(Arrays.toString(reversePrint(head)));
    }
}
