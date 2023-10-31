package cn.iisheng.solution.offer;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author iisheng
 * @date 2022/09/22 17:10:13
 */
public class No_102_NextGreaterElements {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return res;
    }
}