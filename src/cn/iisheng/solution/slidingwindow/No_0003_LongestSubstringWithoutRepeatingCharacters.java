package cn.iisheng.solution.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author iisheng
 * @date 2019/12/03 10:12:41
 */
public class No_0003_LongestSubstringWithoutRepeatingCharacters {

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
