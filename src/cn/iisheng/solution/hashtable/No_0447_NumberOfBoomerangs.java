package cn.iisheng.solution.hashtable;

import java.util.HashMap;

/**
 * @author iisheng
 * @date 2020/03/02 21:24:48
 */
public class No_0447_NumberOfBoomerangs {

    public static void main(String[] args) {
        int[][] points = new int[][]{{7, 8}, {6, 8}, {8, 4}, {3, 1}, {4, 9}, {2, 0}, {9, 2}, {6, 6}};
        System.out.println(numberOfBoomerangs(points));

        int[][] another = new int[][]{{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        System.out.println(numberOfBoomerangs(another));
    }

    public static int numberOfBoomerangs(int[][] points) {
        int len = points.length;
        if (len == 0) {
            return 0;
        }

        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < len; i++) {

            map.clear();
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                Integer dis = getDistance(points[i], points[j]);

                if (!map.containsKey(dis)) {
                    map.put(dis, 1);
                } else {
                    Integer value = map.get(dis);
                    // 组合公式转换为 等差数列？
                    sum += 2 * value;
                    map.put(dis, value + 1);
                }
            }
//            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//                Integer v = entry.getValue();
//                if (v >= 2) {
//                    sum += v * (v - 1);
//                }
//            }

        }
        return sum;
    }

    public static int getDistance(int[] a, int b[]) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}
