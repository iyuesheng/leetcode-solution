package cn.iisheng.solution.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author iisheng
 * @date 2019/10/16 21:24:54
 */
public class No_0001_TwoSum_2023 {
    
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int search = target - num;
            if (map1.containsKey(search)) {
                return new int[]{i, map1.get(search)};
            } else {
                map1.put(num, i);
            }
        }
        return new int[]{};
    }
    
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map1.containsKey(num)) {
                map2.put(num, i);
            } else {
                map1.put(num, i);
            }
        }
        for (int num : nums) {
            int search = target - num;
            if (search == num && map2.containsKey(search)) {
                return new int[]{getNum(map1, map2, num), map2.get(search)};
            }
            if (search != num && map1.containsKey(search)) {
                return new int[]{getNum(map1, map2, num), map1.get(search)};
            }
        }
        return new int[]{};
    }
    
    private static Integer getNum(Map<Integer, Integer> map1, Map<Integer, Integer> map2, Integer target) {
        if (map1.containsKey(target)) {
            return map1.get(target);
        }
        if (map2.containsKey(target)) {
            return map2.get(target);
        }
        return 0;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum2(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum2(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum2(new int[]{3, 2, 4}, 6)));
    }
}
