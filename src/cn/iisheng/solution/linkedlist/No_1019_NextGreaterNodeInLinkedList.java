package cn.iisheng.solution.linkedlist;

import cn.iisheng.solution.common.ListNode;
import cn.iisheng.solution.utils.ListUtils;

import java.util.*;

/**
 * @author iisheng
 * @date 2020/12/10 16:31:27
 */
public class No_1019_NextGreaterNodeInLinkedList {
    public static void main(String[] args) {
        ListNode head = ListUtils.createLinkedList(new Integer[]{2, 1, 5});
        System.out.println(Arrays.toString(nextLargerNodes(head)));
    }

    public static int[] nextLargerNodes(ListNode head) {
        // 将链表值顺序放入 List中
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        // 结果数组
        int[] ans = new int[list.size()];
        // 栈（只允许在一端进行插入和删除） 栈里面存储的是什么？stack.peek() 是下一次遍历 要给ans[i] 赋值的数值
        Deque<Integer> stack = new ArrayDeque<>();

        // 将 list 从后往前遍历
        for (int i = list.size() - 1; i >= 0; i--) {
            // 什么时候出栈？把下一次赋值的时候 stack.peek() 调整正确即可 即 list.get(i) >= stack.peek()的都移除
            while (!stack.isEmpty() && list.get(i) >= stack.peek()) {
                stack.pop();
            }

            // 添加 stack 非空判断
            if (!stack.isEmpty()) {
                // 获取栈顶元素 赋值给 ans[i]
                ans[i] = stack.peek();
            }

            // 从后往前遍历数组 依次入栈
            stack.push(list.get(i));
        }

        return ans;
    }
}
