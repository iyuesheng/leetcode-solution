package org.dullnull.solution.string;

/**
 * @author iisheng
 * @date 2019/07/12 23:00:03
 */
public class No_0014_LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        } else {
            String result = strs[0];
            for (int i = 1; i < strs.length; i++) {
                result = commonPrefix(result, strs[i]);
            }
            return result;
        }
    }

    public static String commonPrefix(String str1, String str2) {
        char[] arrStr1 = str1.toCharArray();
        char[] arrStr2 = str2.toCharArray();
        int index = 0;
        for (int i = 0; i < arrStr1.length && i < arrStr2.length; i++) {
            if (arrStr1[i] == arrStr2[i]) {
                index++;
            } else {
                break;
            }
        }
        return new String(arrStr1, 0, index);
    }
}
