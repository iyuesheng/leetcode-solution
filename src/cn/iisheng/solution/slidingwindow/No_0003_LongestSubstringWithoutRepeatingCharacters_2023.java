package cn.iisheng.solution.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author iisheng
 * @date 2023/10/13 10:23:08
 */
public class No_0003_LongestSubstringWithoutRepeatingCharacters_2023 {
    
    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (left <= right && right < s.length()) {
            // map不存在 说明 可以继续滑动
            if (!map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), right - left);
                right++;
            } else {
                // map存在说明遇到重复字符
                int cur = right - left;
                if (cur > max) {
                    max = cur;
                }
                left = left + map.get(s.charAt(right)) + 1;
                map.clear();
                right = left;
            }
        }
        int cur = right - left;
        if (cur > max) {
            max = cur;
        }
        return max;
    }
    
    public static void main(String[] args) {
        // 3
        System.out.println(lengthOfLongestSubstring("abcabcbb") == 3);
        // 1
        System.out.println(lengthOfLongestSubstring("bbbbb") == 1);
        // 3
        System.out.println(lengthOfLongestSubstring("pwwkew") == 3);
        // 3
        System.out.println(lengthOfLongestSubstring("dvdf") == 3);
        // 1
        System.out.println(lengthOfLongestSubstring("aa") == 1);
        // 5
        System.out.println(lengthOfLongestSubstring("ckilbkd") == 5);
        // 2
        System.out.println(lengthOfLongestSubstring("aab") == 2);
        // 5
        System.out.println(lengthOfLongestSubstring("nfpdmpi") == 5);
        // 5
        System.out.println(lengthOfLongestSubstring("tmmzuxt") == 5);
        // 7
        System.out.println(lengthOfLongestSubstring("bpfbhmipx") == 7);
    }
}
