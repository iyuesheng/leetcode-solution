package cn.iisheng.solution.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author iisheng
 * @date 2022/09/19 13:56:30
 */
public class No_101_FindMaxNumber {
    
    public static Map<String, Integer> findMaxNumber(int[] nums) {
        
        // 数据不合法直接抛异常
        if (nums == null || nums.length < 3) {
            throw new RuntimeException("数据不合法");
        }
        
        // 结果通过 map 返回 maxNum 是具体的值，count代表 数量
        Map<String, Integer> result = new HashMap();
        // 默认值 -1 代表 未找到
        int maxNum = -1;
        int count = -1;
        
        // 利用二分的 思想 快速找到这个最大值
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            
            int middle = (left + right) / 2;
            
            int middleLeft = middle - 1;
            int middleRight = middle + 1;
            
            // 处理重复数字
            while (middleLeft >= left && nums[middle] == nums[middleLeft]) {
                middleLeft--;
            }
            while (middleRight <= right && nums[middle] == nums[middleRight]) {
                middleRight++;
            }
            
            // 找到最大值的判断方法
            if (nums[middle] > nums[middleLeft] && nums[middle] > nums[middleRight]) {
                maxNum = nums[middle];
                count = middleRight - (middleLeft + 1);
                break;
            } else if (nums[middle] > nums[middleLeft] && nums[middle] < nums[middleRight]) {
                // 左面是递增 右面也是递增 向右面继续找
//                middle = (middleRight + right) / 2;
                
                left = middleRight;
            } else if (nums[middle] < nums[middleLeft] && nums[middle] > nums[middleRight]) {
                // 左面是递减 右面也是递减 向左面继续找
//                middle = (left + middleLeft) / 2;
                right = middleLeft;
            } else {
                // nums[middle] < nums[middleLeft] && nums[middle] < nums[middleRight]
                // 左面递减 右面递增 代表数据不合法 不是中间大的数据 抛出异常
                throw new RuntimeException("数据不合法");
            }
        }
        
        result.put("maxNum", maxNum);
        result.put("count", count);
        
        return result;
    }
    
    
    public static void main(String[] args) {
//        int[] nums = new int[]{1, 3, 3, 3, 4, 5, 6, 7, 8, 8, 8, 8, 8, 9, 10, 10, 11, 11, 12, 23, 33, 33, 10, 2, 2, 2, 2, 2, 2, 1, 1, 1};
        
        int[] nums = new int[]{1, 2, 3, 4, 5, 5, 5, 5, 5, 2, 1, 1};
        System.out.println(findMaxNumber(nums));
//        for (int i=0;i<1000;i++){
//            int lottery = lottery();
//            System.out.println("lottery" + lottery);
//        }
    
    }
}
