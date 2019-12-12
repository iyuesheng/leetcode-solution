package cn.iisheng.solution.math;

/**
 * @author iisheng
 * @date 2019/12/12 10:40:17
 */
public class No_0258_AddDigits {

    public static int addDigits(int num) {
        int result = 0;
        if (num < 10) {
            return num;
        }
        while (num >= 10) {
            result = 0;
            while (num > 0) {
                result = result + num % 10;
                num = num / 10;
            }
            num = result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
        System.out.println(addDigits(8));
    }
}
