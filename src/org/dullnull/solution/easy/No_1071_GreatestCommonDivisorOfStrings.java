package org.dullnull.solution.easy;

/**
 * @author iisheng
 * @date 2019/07/01 23:46:04
 */
public class No_1071_GreatestCommonDivisorOfStrings {

    public static String gcdOfStrings(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        if (l2 == 0) {
            return str1;
        }
        if (l1 < l2) {
            return gcdOfStrings(str2, str1);
        }
        if (!str1.substring(0, l2).equals(str2)) {
            return "";
        }
        return gcdOfStrings(str1.substring(l2, l1), str2);
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC", "ABC"));
    }
}
