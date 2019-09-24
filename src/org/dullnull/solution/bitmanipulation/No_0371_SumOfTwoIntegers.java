package org.dullnull.solution.bitmanipulation;

/**
 * @author iisheng
 * @date 2019/09/23 20:17:09
 */
public class No_0371_SumOfTwoIntegers {

    /**
     * XOR 性质 不进位加法
     *
     * @param a
     * @param b
     * @return
     */
    public static int getSum(int a, int b) {
        // b为0 直接 返回 a
        if (b == 0) {
            return a;
        }
        // 异或运算 a b 不同就是 结果， a b 相同 需要计算进位
        int sum = a ^ b;
        // 进位
        int carry = (a & b) << 1;
        return getSum(sum, carry);
    }

    public static void main(String[] args) {
        System.out.println(getSum(2, 2));
    }
}
