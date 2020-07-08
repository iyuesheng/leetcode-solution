package cn.iisheng.solution.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author iisheng
 * @date 2020/07/08 21:58:03
 */
public class No_0646_MaximumLengthOfPairChain {

    public static int findLongestChain(int[][] pairs) {
        int length = pairs.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return 1;
        }
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));

        int min = pairs[0][1], result = 1;
        for (int i = 1; i < length; i++) {
            if (pairs[i][0] > min) {
                result++;
                min = pairs[i][1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] pairs = new int[][]{{1, 2}, {2, 3}, {3, 4}};
        System.out.println(findLongestChain(pairs));
    }
}
