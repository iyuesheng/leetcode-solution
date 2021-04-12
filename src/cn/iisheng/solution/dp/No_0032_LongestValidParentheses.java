package cn.iisheng.solution.dp;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author iisheng
 * @date 2021/04/12 14:58:57
 */
public class No_0032_LongestValidParentheses {

    public static int longestValidParentheses1(String s) {
        int res = 0, left = 0, right = 0, n = s.length();
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(') {
                ++left;
            } else {
                ++right;
            }
            if (left == right) {
                res = Math.max(res, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt(i) == '(') {
                ++left;
            } else {
                ++right;
            }
            if (left == right) {
                res = Math.max(res, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return res;
    }

    public static int longestValidParentheses2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int maxResult = 0;
        int dp[] = new int[s.length()];
        dp[0] = 0;

        for (int i = 1; i < s.length(); i++) {
            dp[i] = 0;
            if (s.charAt(i) == ')') {
                int leftBound = i - dp[i - 1] - 1;
                if (leftBound >= 0 && s.charAt(leftBound) == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if (leftBound - 1 >= 0) {
                        dp[i] += dp[leftBound - 1];
                    }
                }
            }
            maxResult = Math.max(maxResult, dp[i]);
        }
        return maxResult;
    }

    public static int longestValidParentheses3(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses3("()(()"));
    }
}