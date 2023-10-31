package cn.iisheng.solution.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author iisheng
 * @date 2023/10/11 18:20:08
 */
public class No_0015_3sum_2023 {
    
    public static List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i1 = 0; i1 < nums.length; i1++) {
            int num = nums[i1];
            map.put(num, i1);
        }
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Boolean> map1 = new HashMap<>();
        for (int ii = 0; ii < nums.length; ii++) {
            for (int jj = ii + 1; jj < nums.length; jj++) {
                int kValue = -nums[ii] - nums[jj];
                if (map.containsKey(kValue)) {
                    Integer k = map.get(kValue);
                    if (ii != k && jj != k) {
                        List<Integer> list = getList(nums[ii], nums[jj], kValue);
                        if (!map1.containsKey(list.get(0) + ":" + list.get(1) + "：" + list.get(2))) {
                            map1.put(list.get(0) + ":" + list.get(1) + "：" + list.get(2), true);
                            result.add(list);
                        }
                    }
                }
            }
        }
        return result;
    }
    
    private static List<Integer> getList(int i, int j, int k) {
        List<Integer> result = Arrays.asList(i, j, k);
        Collections.sort(result);
        return result;
    }
    
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (len < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            // nums[i] == nums[i-1] 第二次遍历重复了 不需要再处理了 并且此数组是已经排序过的
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 保证 i j k 不互相相等
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    // 满足条件
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 已经计算过相同的left 没必要再计算了
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // 已经计算过相同的right 没必要再计算了
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    // 因为整个数组已经排序过了
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        // [[-1,-1,2],[-1,0,1]]
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        // [[0,0,0]]
        System.out.println(threeSum(new int[]{0, 0, 0}));
        // [[-4,0,4],[-4,1,3],[-3,-1,4],[-3,0,3],[-3,1,2],[-2,-1,3],[-2,0,2],[-1,-1,2],[-1,0,1]]
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}));
    }
}