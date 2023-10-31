package cn.iisheng.solution.hashtable;

/**
 * @author iisheng
 * @date 2023/10/09 22:56:25
 */
public class No_0136_SingleNumber_2023 {
    
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 1}));
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(singleNumber(new int[]{1}));
    }
}
