package cn.iisheng.solution.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author iisheng
 * @date 2022/10/13 11:07:11
 */

public class Test {
    public static int findStrLength(String s) {
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            // map 存在 这个key
            if (map.containsKey(s.charAt(i))) {
                left = map.get(s.charAt(i));
                map.remove(s.charAt(left));
                left++;
            }
            
            // map 不存在这个key
            map.put(s.charAt(i), i);
            right++;
            
            if (right - left > max) {
                max = right - left;
            }
        }
        
        return max;
    }
    
    
    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        while (right < s.length()) {
            char c = s.charAt(right);
            while (map.containsKey(c)) {
                map.remove(s.charAt(left));
                left++;
            }
            map.put(c, 1);
            right++;
            if (right - left > max) {
                max = right - left;
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        String s = "bbtablud";
        System.out.println(lengthOfLongestSubstring(s));
        
    }
}
