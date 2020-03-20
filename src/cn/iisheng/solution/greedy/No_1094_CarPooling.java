package cn.iisheng.solution.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author iisheng
 * @date 2020/03/19 09:13:43
 */
public class No_1094_CarPooling {

    public static void main(String[] args) {
        System.out.println(carPooling2(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4));
    }

    public static boolean carPooling(int[][] trips, int capacity) {
        int[] result = new int[1000];
        for (int[] trip : trips) {
            result[trip[1]] += trip[0];
            if (trip[2] + 1 < 1000) {
                result[trip[2]] -= trip[0];
            }
        }

        for (int i = 1; i < 1000; i++) {
            result[i] += result[i - 1];
            if (result[i] > capacity) {
                return false;
            }
        }
        return true;

    }

    public static boolean carPooling1(int[][] trips, int capacity) {
        Map<Integer, Integer> start = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();
        int max = trips[0][2], min = trips[0][1];
        for (int[] trip : trips) {
            start.put(trip[1], start.getOrDefault(trip[1], 0) + trip[0]);
            end.put(trip[2], end.getOrDefault(trip[2], 0) + trip[0]);
            min = Math.min(min, trip[1]);
            max = Math.max(max, trip[2]);
        }
        int cur = 0;

        for (int i = min; i <= max; i++) {
            if (end.containsKey(i)) {
                cur -= end.get(i);
            }
            if (start.containsKey(i)) {
                cur += start.get(i);
            }
            if (cur > capacity) {
                return false;
            }
        }
        return true;
    }

    public static boolean carPooling2(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] trip : trips) {
            map.put(trip[1], map.getOrDefault(trip[1], 0) + trip[0]);
            map.put(trip[2], map.getOrDefault(trip[2], 0) - trip[0]);
        }
        int cur = 0;


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            cur += value;
            if (cur > capacity) {
                return false;
            }
        }
        return true;
    }

    public static boolean carPooling3(int[][] trips, int capacity) {
        int[] result = new int[1000 + 1];
        for (int[] trip : trips) {
            result[trip[1]] += trip[0];
            result[trip[2]] -= trip[0];
        }

        int currCapacity = 0;
        for (int i = 0; i < result.length; ++i) {
            currCapacity += result[i];
            if (currCapacity > capacity) {
                return false;
            }
        }
        return true;

    }

    public static boolean carPooling4(int[][] trips, int capacity) {
        int maxDest = 0;
        for (int[] trip : trips) {
            maxDest = Math.max(maxDest, trip[2]);
        }

        int[] costs = new int[maxDest + 1];
        for (int[] trip : trips) {
            costs[trip[1]] += trip[0];
            costs[trip[2]] -= trip[0];
        }

        int passengersCount = 0;
        for (int cost : costs) {
            passengersCount += cost;
            if (passengersCount > capacity) {
                return false;
            }
        }

        return true;
    }
}
