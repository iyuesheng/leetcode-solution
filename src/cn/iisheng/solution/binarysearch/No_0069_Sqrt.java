package cn.iisheng.solution.binarysearch;

/**
 * @author iisheng
 * @date 2020/02/13 11:19:25
 */
public class No_0069_Sqrt {

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        double left = 1;
        double right = x;

        while (left < right) {
            double mid = left + Math.floor((right - left) / 2);
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) left - 1;
    }
}
