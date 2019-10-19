package cn.iisheng.solution.dp;

/**
 * @author iisheng
 * @date 2019/10/13 19:59:45
 */
public class No_0096_UniqueBinarySearchTrees {

    public static int numTrees(int n) {
        return (int) CatalanNumber(n);
    }

    public static double CatalanNumber(int n) {
        if (n == 1) {
            return 1;
        } else {
            return CatalanNumber(n - 1) * 2 * (2 * n - 1) / (n + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(numTrees(2));
        System.out.println(numTrees(4));
        System.out.println(numTrees(5));
        System.out.println(numTrees(19));

    }
}
