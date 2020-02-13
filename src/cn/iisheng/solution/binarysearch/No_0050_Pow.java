package cn.iisheng.solution.binarysearch;

/**
 * @author iisheng
 * @date 2020/02/12 10:24:02
 */
public class No_0050_Pow {

    public static void main(String[] args) {
        System.out.println(myPowBit(2.00000, 10));
        System.out.println(myPowBit(2.10000, 3));
        System.out.println(myPowBit(2.00000, -2));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE >>> 1);
        System.out.println(Integer.MIN_VALUE / 2);
        System.out.println(-2 >> 1);
        System.out.println(-2 / 2);
    }

    public static double myPow(double x, int n) {
        // n is Integer.MIN_VALUE
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        // 2^0 =1
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        // n is evan 2^4 = (2*2)^2
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            // n is odd 2^5 = ((2^2)^2)*2
            return myPow(x * x, n / 2) * x;
        }
    }

    public static double myPowBit(double x, int n) {
        // n is Integer.MIN_VALUE
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n << 1;
        }
        // 2^0 =1
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        // n is evan 2^4 = (2*2)^2
        if ((n & 1) == 0) {
            return myPow(x * x, n / 2);
        } else {
            // n is odd 2^5 = ((2^2)^2)*2
            return myPow(x * x, n / 2) * x;
        }
    }
}
