package cn.iisheng.solution.string;

import java.util.HashMap;

/**
 * @author iisheng
 * @date 2019/12/01 19:07:26
 */
public class No_0387_FirstUniqueCharacterInAString {


    public static int firstUniqChar(String s) {
        HashMap map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            int count = (int) map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), ++count);
        }
        for (int i = 0; i < s.length(); i++) {
            int count = (int) map.getOrDefault(s.charAt(i), 0);
            if (count == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar2(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int res = s.length();
        for (char c = 'a'; c <= 'z'; c++) {
            int indexOf = s.indexOf(c);
            if (indexOf > -1 && indexOf == s.lastIndexOf(c)) {
                res = Math.min(res, s.indexOf(c));
            } else {
                continue;
            }
        }
        if (res == s.length()) {
            res = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar2("leetcode"));
        System.out.println(firstUniqChar2("loveleetcode"));
    }
}
