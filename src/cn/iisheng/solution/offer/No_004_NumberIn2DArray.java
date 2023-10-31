package cn.iisheng.solution.offer;

/**
 * @author iisheng
 * @date 2022/07/27 20:11:55
 */
public class No_004_NumberIn2DArray {
    
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 从右上角或者左下角开始
        if (null == matrix || matrix.length == 0) {
            return false;
        }
        
        // 最小0 二维数组纵向坐标
        int i = matrix.length - 1;
        // 最大 matrix[0].length-1 横向坐标
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        
        return false;
    }
    
    public static boolean query(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 20;
        System.out.println(findNumberIn2DArray(matrix, target));
    }
    
}
