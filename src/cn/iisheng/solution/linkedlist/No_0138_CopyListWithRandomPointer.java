package cn.iisheng.solution.linkedlist;


import java.util.HashMap;

/**
 * @author iisheng
 * @date 2020/12/19 21:50:00
 */
public class No_0138_CopyListWithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    HashMap<Node, Node> visitedHash = new HashMap();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }

        Node node = new Node(head.val);
        this.visitedHash.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }

}
