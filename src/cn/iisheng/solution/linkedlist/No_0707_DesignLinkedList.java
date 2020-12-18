package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;

/**
 * @author iisheng
 * @date 2020/12/17 10:41:30
 */
public class No_0707_DesignLinkedList {


    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
        myLinkedList.get(1);              // return 2
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        myLinkedList.get(1);              // return 3
    }

    static class MyLinkedList {

        private ListNode head;

        private ListNode tail;

        private int size;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            head = null;
            tail = null;
            size = 0;
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index >= size) {
                return -1;
            }

            ListNode cur = head;
            int i = 0;
            while (cur != null && i < index) {
                cur = cur.next;
                i++;
            }
            if (cur != null) {
                return cur.val;
            } else {
                return -1;
            }
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            if (head == null) {
                head = tail = new ListNode(val);
            } else {
                ListNode newHead = new ListNode(val);
                newHead.next = head;
                head = newHead;
            }
            size++;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            if (tail == null) {
                head = tail = new ListNode(val);
            } else {
                ListNode newTail = new ListNode(val);
                tail.next = newTail;
                tail = newTail;
            }
            size++;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index == 0) {
                addAtHead(val);
                return;
            }
            if (index == size) {
                addAtTail(val);
                return;
            }
            ListNode cur = head;
            int i = 0;
            while (cur != null && i < index - 1) {
                cur = cur.next;
                i++;
            }
            // cur 是 第index个节点前一个节点
            if (cur != null && cur.next != null) {
                ListNode newCur = new ListNode(val);
                newCur.next = cur.next;
                cur.next = newCur;
            }
            size++;
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index >= size) {
                return;
            }

            if (index == 0) {
                deleteAtHead();
            }

            ListNode cur = head;
            int i = 0;
            while (cur != null && i < index - 1) {
                cur = cur.next;
                i++;
            }
            // cur 是 index 节点的上一个节点
            if (cur != null && cur.next != null) {
                ListNode next = cur.next.next;
                cur.next = next;
                if (cur.next == null) {
                    tail = cur;
                }
            }

            size--;
        }

        private void deleteAtHead() {
            head = head.next;
            size--;
        }

        public void print() {
            ListNode cur = head;
            while (cur != null) {
                System.out.print(cur.val + " ");
                cur = cur.next;
            }
            System.out.println();
        }
    }
}
