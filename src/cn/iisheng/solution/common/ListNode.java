package cn.iisheng.solution.common;

/**
 * @author iisheng
 * @date 2019/08/14 14:29:58
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "val=" + val;
    }
}