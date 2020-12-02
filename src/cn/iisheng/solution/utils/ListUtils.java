package cn.iisheng.solution.utils;

import cn.iisheng.solution.common.ListNode;

/**
 * @author iisheng
 * @date 2019/08/14 18:18:32
 */
public class ListUtils {
    /**
     * 默认创建链表共用方法
     *
     * @param values 待插入数据数组
     * @return 链表头节点
     */
    public static ListNode createLinkedList(Integer[] values) {
        return tailCreateLinkedList(values);
    }

    /**
     * 尾插法创建单链表 第一个元素作为链表头，剩下的元素插入到头节点后面
     * 链表元素顺序 和 数组数据一致
     *
     * @param values
     * @return
     */
    public static ListNode tailCreateLinkedList(Integer[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        ListNode head = null, tail = null;
        for (Integer value : values) {
            // 需要判断 head 节点是否为空 分别进行不同处理
            if (head == null) {
                head = new ListNode(value);
                tail = head;
            } else {
                ListNode cur = new ListNode(value);
                tail.next = cur;
                tail = tail.next;
            }
        }
        return head;
    }

    /**
     * 使用 dummy node 虚拟节点 优化后的 tailCreateLinkedList() 方法
     * 不需要在循环的时候 判断 head节点是否为空了
     *
     * @param values
     * @return
     */
    public static ListNode tailCreateLinkedListWithDummyNode(Integer[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        for (Integer value : values) {
            // 逻辑统一 新节点都插入到 尾节点 下一个
            ListNode cur = new ListNode(value);
            tail.next = cur;
            tail = tail.next;
        }
        return dummy.next;
    }


    /**
     * 头插法创建单链表
     * 链表元素顺序与数组顺序相反
     *
     * @param values
     * @return
     */
    public static ListNode headCreateLinkedList(Integer[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        // 使用数组第0个元素作为头节点，不必要判断头节点是否为空的情况了
        ListNode head = new ListNode(values[0]);
        for (int i = 1; i < values.length; i++) {
            ListNode cur = new ListNode(values[i]);
            // 新元素插入到 head节点前面
            cur.next = head;
            head = cur;
        }
        return head;
    }


    /**
     * 按照链表节点顺序打印节点中的值
     *
     * @param head
     */
    public static void print(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
