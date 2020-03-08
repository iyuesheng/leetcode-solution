package cn.iisheng.solution.string;

/**
 * @author iisheng
 * @date 2020/03/07 22:48:07
 */
public class No_1370_IncreasingDecreasingString {

    public static String sortString(String s) {
        if (s.length() == 1) {
            return s;
        }
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c - 97]++;
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] > 0) {
                    sb.append((char) (i + 97));
                    chars[i]--;
                    index++;
                }
            }

            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i] > 0) {
                    sb.append((char) (i + 97));
                    chars[i]--;
                    index++;
                }
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(sortString("aaaabbbbcccc"));
        System.out.println(sortString("rat"));
        System.out.println(sortString("leetcode"));
        System.out.println(sortString("ggggggg"));
        System.out.println(sortString("spo"));
    }
}
