package cn.iisheng.solution.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author iisheng
 * @date 2019/12/03 10:12:41
 */
public class No_0003_LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;

        // current index of character
        Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
