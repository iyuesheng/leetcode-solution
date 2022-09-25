package cn.iisheng.solution.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author iisheng
 * @date 2019/12/03 10:12:41
 */
public class No_0003_LongestSubstringWithoutRepeatingCharacters {
    
    public static int lengthOfLongestSubstringV1(String s) {
        // 窗口左边界、右边界
        int left = 0, right = 0;
        // 结果最大值
        int max = 0;
        // 窗口使用数组 缓存 该字符是否存在窗口内
        int[] window = new int[128];
        // 滑动结束标识 right达到最大值
        while (right < s.length()) {
            char c = s.charAt(right);
            // 当窗口内存在该字符，需要将左面的字符一次移除
            while (window[c] > 0) {
                window[s.charAt(left)]--;
                left++;
            }
            right++;
            window[c] = 1;
            // 所有滑动过程要记住当前滑动的最大窗口值
            max = Math.max(max, right - left);
        }
        return max;
    }
    
    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        
        if (length == 0) {
            return 0;
        }
        
        HashMap<Character, Integer> map = new HashMap(length * 4 / 3 + 1);
        int max = 0;
        int pos = 0;
        
        for (int i = 0; i < length; i++) {
            if (map.containsKey(s.charAt(i))) {
                pos = Math.max(pos, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - pos + 1);
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
