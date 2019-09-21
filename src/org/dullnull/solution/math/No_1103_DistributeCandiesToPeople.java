package org.dullnull.solution.math;

import java.util.Arrays;

/**
 * @author iisheng
 * @date 2019/07/14 10:56:39
 */
public class No_1103_DistributeCandiesToPeople {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(distributeCandies(10, 3)));
    }

    public static int[] distributeCandies(int candies, int num_people) {
        int[] arr = new int[num_people];
        int current = 0;
        int count = 0;
        for (int i = 0; count < candies; i++) {
            current++;
            if (i == num_people) {
                i -= num_people;
            }
            if (candies - count > current) {
                arr[i] = arr[i] + current;
            } else {
                arr[i] = arr[i] + candies - count;
            }
            count += current;
        }
        return arr;
    }
}
