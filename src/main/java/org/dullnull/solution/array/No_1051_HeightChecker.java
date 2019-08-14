package org.dullnull.solution.array;

import java.util.Arrays;

/**
 * @author iisheng
 * @date 2019/07/03 23:46:07
 */
public class No_1051_HeightChecker {
    public static void main(String[] args) {
        System.out.println(heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
    }


    public static int heightChecker(int[] heights) {
        // [1,1,4,2,1,3]
        // [1,1,1,2,3,4]
        int[] arr = heights.clone();
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }
}
