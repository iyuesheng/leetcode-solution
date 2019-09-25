package org.dullnull.solution.string;

/**
 * @author iisheng
 * @date 2019/09/25 18:52:21
 */
public class No_0392_IsSubsequence {

    public static boolean isSubsequence(String s, String t) {

        if (t.length() == 0 && s.length() == 0) {
            return true;
        }

        if (t.length() == 0) {
            return false;
        }

        int s_index = 0;
        int t_index = 0;

        while (s_index < s.length()) {
            for (int i = t_index; i < t.length(); i++) {
                if (t.charAt(i) == s.charAt(s_index)) {
                    s_index++;
                    t_index++;
                    break;
                }
                if (t_index == t.length() - 1 && s_index < s.length()) {
                    return false;
                }
                t_index++;
            }
            if (t_index > t.length() - 1 && s_index < s.length()) {
                return false;
            }
        }
        return true;
    }

    public boolean isSubsequence1(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc",
                "ahbgdc"));
    }
}
