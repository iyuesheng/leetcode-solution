package cn.iisheng.solution.greedy;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author iisheng
 * @date 2020/03/19 09:13:43
 */
public class No_1094_CarPooling {

    public static void main(String[] args) {
        System.out.println(carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4));
    }

    public boolean carPooling1(
            int[][] trips, int capacity) {
        // 使用TreeMap 是为了让元素根据key排序
        TreeMap<Integer, Integer> map =
                new TreeMap<>();
        for (int[] t : trips) {
            int v = map.getOrDefault(t[1], 0) + t[0];
            // 上车乘客数量
            map.put(t[1], v);
            v = map.getOrDefault(t[2], 0) - t[0];
            // 下车乘客数量
            map.put(t[2], v);
        }

        int cur = 0;

        for (Map.Entry<Integer, Integer> entry
                : map.entrySet()) {
            Integer value = entry.getValue();
            // 当前数量=之前数量+变化的数量
            cur += value;

            if (cur > capacity) {
                return false;
            }
        }
        return true;
    }

    public  static  boolean carPooling(
            int[][] trips, int capacity) {

        // 最远行程 数组长度
        int max = 0;
        for (int[] t : trips) {
            max = Math.max(max, t[2]);
        }

        // 所有要乘车的乘客数量
        int[] passengers = new int[max + 1];
        for (int[] t : trips) {
            passengers[t[1]] += t[0];
            passengers[t[2]] -= t[0];
        }

        int cur = 0;
        for (int passenger : passengers) {
            // 当前数量 = 之前数量 + 变化的数量
            cur += passenger;
            if (cur > capacity) {
                return false;
            }
        }

        return true;
    }
}
