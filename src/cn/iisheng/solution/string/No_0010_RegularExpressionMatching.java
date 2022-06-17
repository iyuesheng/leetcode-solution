package cn.iisheng.solution.string;

/**
 * @author iisheng
 * @date 2022/06/17 14:32:58
 */
public class No_0010_RegularExpressionMatching {
    
    
    public static void main(String[] args) {
        System.out.println(isMatchDp("aa", "a"));
        System.out.println(isMatchDp("aa", "a*"));
        System.out.println(isMatchDp("ab", ".*"));
        
        
        System.out.println(isMatchDp("b", "a*b"));
        System.out.println(isMatchDp("ab", "a*b"));
        System.out.println(isMatchDp("aaab", "a*b"));
        
        
        // pattern a*b 可以表示 b 或者 aaab
    }
    
    public static boolean isMatch(String text, String pattern) {
        // 如果text和pattern都是空 返回 true
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }
        // 如果text 非空 pattern 0位 和 text 0位相等，或者 pattern 0位等于 点，首字母匹配
        boolean firstMatch = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
        
        // pattern 长度 大于等于2 && pattern第二位 是 *
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            // *和*前一位去掉，看是否匹配
            return (isMatch(text, pattern.substring(2)) ||
                    // 首字母匹配 && text除首字母剩下的 匹配
                    (firstMatch && isMatch(text.substring(1), pattern)));
        } else {
            // 如果没有*
            
            // 首字母匹配 && 除首字母剩下的匹配
            return firstMatch && isMatch(text.substring(1), pattern.substring(1));
        }
    }
    
    public static boolean isMatchDp(String text, String pattern) {
        // dp 经典 写法 二维数组
        Boolean[][] memo = new Boolean[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern, memo);
    }
    
    public static boolean dp(int i, int j, String text, String pattern, Boolean[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j] == true;
        }
        boolean ans;
        if (j == pattern.length()) {
            ans = i == text.length();
        } else {
            // dp 首次 匹配 赋值
            boolean firstMatch = (i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
            
            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                ans = (dp(i, j + 2, text, pattern, memo) || firstMatch && dp(i + 1, j, text, pattern, memo));
            } else {
                ans = firstMatch && dp(i + 1, j + 1, text, pattern, memo);
            }
        }
        memo[i][j] = ans;
        return ans;
    }
}
