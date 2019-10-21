package cn.iisheng.solution.stack;

import java.util.Stack;

/**
 * @author iisheng
 * @date 2019/10/20 21:43:53
 */
public class No_0084_LargestRectangleInHistogram {

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0, n = heights.length;
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                int area = heights[st.pop()] * (st.isEmpty() ? i : i - st.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int area = heights[st.pop()] * (st.isEmpty() ? n : n - st.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

}
