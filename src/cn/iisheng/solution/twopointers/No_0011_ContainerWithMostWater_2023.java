package cn.iisheng.solution.twopointers;

/**
 * @author iisheng
 * @date 2023/10/11 10:32:22
 */
public class No_0011_ContainerWithMostWater_2023 {
    
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < height.length && left < right) {
            // 面积 = 高 * 宽
            int area = Math.min(height[left], height[right]) * Math.abs(right - left);
            if (area > max) {
                max = area;
            }
            // 哪个小移动哪个
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        // 49
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        // 1
        System.out.println(maxArea(new int[]{1, 1}));
        // 17
        System.out.println(maxArea(new int[]{2, 3, 4, 5, 18, 17, 6}));
        // 49
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 25, 7}));
        // 24
        System.out.println(maxArea(new int[]{1, 3, 2, 5, 25, 24, 5}));
    }
}
