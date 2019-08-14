package org.dullnull.solution.dp;

/**
 * @author iisheng
 * @date 2019/06/29 08:21:36
 */
public class No_0005_LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(new No_0005_LongestPalindromicSubstring().longestPalindrome("babad"));
    }


    int len, start, max = 1;

    public String longestPalindrome(String s) {
        len = s.length();
        if (len < 2) return s;
        char[] c = s.toCharArray();
        int i = 0;
        while (i < len) {
            i = extend(c, i);
        }
        return s.substring(start, start + max);
    }

    private int extend(char[] c, int i) {
        int left = i - 1, right = i + 1;
        while (right < len && c[right] == c[i])
            right++;
        int next = right;
        while (left > -1 && right < len && c[left] == c[right]) {
            left--;
            right++;
        }
        if (right - left - 1 > max) {
            start = left + 1;
            max = right - left - 1;
        }
        return next;
    }

    public static String longestPalindrome1(String s) {
        if (s.length() <= 1) {
            return s;
        }

        String res = "";

        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;
            String tempStr = getStr(l, r, s);
            if (tempStr.length() > res.length()) {
                res = tempStr;
            }

            r = i + 1;
            tempStr = getStr(l, r, s);
            if (tempStr.length() > res.length()) {
                res = tempStr;
            }
        }
        return res;
    }

    public static String getStr(int l, int r, String s) {

        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}
