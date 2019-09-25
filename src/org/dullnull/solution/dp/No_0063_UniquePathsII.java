package org.dullnull.solution.dp;

/**
 * @author iisheng
 * @date 2019/09/25 16:44:12
 */
public class No_0063_UniquePathsII {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[][] result = new int[n][m];

        boolean hasObstacle = false;
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == 1) {
                hasObstacle = true;
            }
            result[i][0] = hasObstacle ? 0 : 1;
        }

        hasObstacle = false;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] == 1) {
                hasObstacle = true;
            }
            result[0][i] = hasObstacle ? 0 : 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int left = obstacleGrid[i][j] == 1 ? 0 : result[i - 1][j];
                int up = obstacleGrid[i][j] == 1 ? 0 : result[i][j - 1];
                result[i][j] = left + up;
            }
        }
        return result[n - 1][m - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{1, 0}}));
    }
}
