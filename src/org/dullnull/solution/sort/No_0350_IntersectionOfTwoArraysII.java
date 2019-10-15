package org.dullnull.solution.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author iisheng
 * @date 2019/10/15 22:07:11
 */
public class No_0350_IntersectionOfTwoArraysII {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] result = new int[list.size()];
        for (int m = 0; m < list.size(); m++) {
            result[m] = list.get(m);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}
