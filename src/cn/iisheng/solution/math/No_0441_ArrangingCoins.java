package cn.iisheng.solution.math;

/**
 * @author iisheng
 * @date 2019/12/12 11:35:08
 */
public class No_0441_ArrangingCoins {

    public static int arrangeCoins(int n) {
        int i = 1;
        while (n >= i) {
            n = n - i;
            i++;
        }
        return i-1;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));
        System.out.println(arrangeCoins(8));
    }
}
