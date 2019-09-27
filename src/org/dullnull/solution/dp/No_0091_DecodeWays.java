package org.dullnull.solution.dp;

/**
 * @author iisheng
 * @date 2019/09/26 17:10:21
 */
public class No_0091_DecodeWays {

    public static int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }

        int[] result = new int[s.length()];

        result[0] = 1;

        if (s.length() == 1) {
            return result[0];
        }

        if (s.charAt(1) == '0' && s.charAt(0) > '2') {
            return 0;
        }

        if ((s.charAt(0) == '1' && s.charAt(1) != '0') || (s.charAt(0) == '2' && s.charAt(1) <= '6' && s.charAt(1) != '0')) {
            result[1] = 2;
        } else {
            result[1] = 1;
        }
        for (int i = 2; i < s.length(); i++) {
            int num = Character.getNumericValue(s.charAt(i - 1));
            int num_i = Character.getNumericValue(s.charAt(i));

            if ((num == 0 || num > 2) && num_i == 0) {
                return 0;
            }

            if (num_i == 0) {
                result[i] = result[i - 2];
                continue;
            }

            if (num == 1 || (num == 2 && num_i <= 6)) {
                result[i] = result[i - 1] + result[i - 2];
            } else {
                result[i] = result[i - 1];
            }
        }
        return result[s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("301"));
        System.out.println(numDecodings("230"));
    }
}
