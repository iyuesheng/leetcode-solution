package cn.iisheng.solution.offer;

import java.util.HashMap;

/**
 * @author iisheng
 * @date 2022/07/27 19:37:16
 */
public class No_003_RepeatNumber {
    
    public static int findRepeatNumber(int[] nums) {
        int cap = (int) (nums.length / 0.75 + 1);
        HashMap map = new HashMap(cap);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return nums[i];
            }
            map.put(nums[i], nums[i]);
        }
        return -1;
    }
    
    
    public static int findRepeatNumberV2(int[] nums) {
        int[] arr = new int[100000];
        for (int i : nums) {
            if (arr[i] > 0) {
                return i;
            }
            arr[i] = i + 1;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumberV2(arr));
    }
}
