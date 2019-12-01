package cn.iisheng.solution.string;

/**
 * @author iisheng
 * @date 2019/12/01 19:53:07
 */
public class No_0383_RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] counts = new int[26];
        for (char ch : magazine.toCharArray()) {
            ++counts[ch - 'a'];
        }

        for (char ch : ransomNote.toCharArray()) {
            --counts[ch - 'a'];
            if (counts[ch - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean canConstruct1(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] counts = new int[26];

        for (char ch : ransomNote.toCharArray()) {
            int indexOf = magazine.indexOf(ch, counts[ch - 'a']);
            if (indexOf < 0) {
                return false;
            } else {
                counts[ch - 'a'] = indexOf + 1;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct1("aa", "aab"));
    }
}
