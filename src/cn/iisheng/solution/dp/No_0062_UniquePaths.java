package cn.iisheng.solution.dp;

/**
 * @author iisheng
 * @date 2019/09/25 16:17:54
 */
public class No_0062_UniquePaths {

    public static int uniquePaths(int m, int n) {
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        int[][] result = new int[n][m];

        for (int i = 0; i < n; i++) {
            result[i][0] = 1;
        }

        for (int i = 0; i < m; i++) {
            result[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }
        return result[n - 1][m - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));
    }
}
