package cn.iisheng.solution.sort;

import java.util.Arrays;

/**
 * @author iisheng
 * @date 2019/12/03 23:55:27
 */
public class No_1030_MatrixCellsInDistanceOrder {

    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] array = new int[R * C][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                array[i * C + j] = new int[]{i, j};
            }
        }

        Arrays.sort(array, (o1, o2) -> {
            int one = Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0);
            int two = Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0);
            if (one > two) {
                return 1;
            } else if(one==two){
                return 0;
            }else {
                return -1;
            }
        });

        return array;
    }

    public static void main(String[] args) {
        allCellsDistOrder(36, 27, 18, 6);

    }
}
