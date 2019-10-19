package cn.iisheng.solution.dp;

/**
 * @author iisheng
 * @date 2019/09/26 12:49:38
 */
public class No_1025_DivisorGame {

    public static boolean divisorGame(int N) {
        return (N & 1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(divisorGame(2));
        System.out.println(divisorGame(3));
    }
}
