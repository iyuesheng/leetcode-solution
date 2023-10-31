package cn.iisheng.solution.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author iisheng
 * @date 2023/10/09 15:51:48
 */
public class No_0128_Longest_Consecutive_Sequence_2023 {
    
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int cur = 1;
            while (set.contains(num + 1)) {
                cur++;
                num++;
            }
            max = Math.max(max, cur);
        }
        return max;
    }
    
    public static void main(String[] args) {
        // 期望 3
        System.out.println(longestConsecutive(new int[]{1, 0, -1}));
        // 期望 4
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        // 期望 9
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        // 期望 3
        System.out.println(longestConsecutive(new int[]{0, -1, 2, 3, 4}));
        // 期望 5
        System.out.println(longestConsecutive(new int[]{4, 0, -4, -2, 2, 5, 2, 0, -8, -8, -8, -8, -1, 7, 4, 5, 5, -4, 6, 6, -3}));
    }
}
