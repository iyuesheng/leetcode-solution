package cn.iisheng.solution.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author iisheng
 * @date 2019/10/07 12:47:36
 */
public class No_0020_ValidParentheses {

    public static boolean isValid(String s) {

        Map map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            // 空栈 入栈
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }
            // 如果匹配 出栈
            if (stack.peek().equals(map.get(s.charAt(i)))) {
                stack.pop();
            } else {
                // 不匹配 入栈
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("()[]{}"));
    }
}
