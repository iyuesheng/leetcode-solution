package cn.iisheng.solution.twopointers;

/**
 * @author iisheng
 * @date 2023/10/10 17:57:31
 */
public class No_0283_MoveZeroes_2023 {
    
    public static void moveZeroes(int[] nums) {
        int last = nums.length - 1;
        for (int i = 0; i < nums.length && i <= last; i++) {
            int num = nums[i];
            if (num == 0) {
                for (int j = i + 1; j <= last; j++) {
                    nums[j - 1] = nums[j];
                }
                nums[last] = 0;
                last--;
                i--;
            }
        }
        System.out.println(1);
    }
    
    public static void main(String[] args) {
        // 0 1 2 0 3
        moveZeroes(new int[]{0, 0, 1});
        // 1 2 3 0 0
    }
}
