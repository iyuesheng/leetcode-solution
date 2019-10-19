package cn.iisheng.solution.twopointers;

/**
 * @author iisheng
 * @date 2019/10/16 15:58:36
 */
public class No_0011_ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int area = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int temp = (j - i) * Math.min(height[i], height[j]);

                if (temp > area) {
                    area = temp;
                }
            }
        }

        return area;
    }

    public static int maxArea11(int[] height) {
        int area = 0;
        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            int temp = (j - i) * Math.min(height[i], height[j]);
            if (temp > area) {
                area = temp;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return area;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea11(new int[]{1, 2, 4, 3}));
        System.out.println(maxArea(new int[]{1, 3, 2, 5, 25, 24, 5}));
        System.out.println(maxArea(new int[]{5, 2, 12, 1, 5, 3, 4, 11, 9, 4}));
    }
}
