package cn.iisheng.solution.bitmanipulation;

/**
 * @author iisheng
 * @date 2019/10/19 12:50:05
 */
public class No_0231_PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        // 偶数 继续运算
        if ((n & 1) == 0) {
            return isPowerOfTwo(n >> 1);
        } else {
            // 奇数 返回 false
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(218));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo(16));
    }
}
