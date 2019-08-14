package org.dullnull.solution.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author iisheng
 * @date 2019/08/07 15:38:18
 */
public class No_0849_MaximizeDistanceToClosestPerson {

    public static int maxDistToClosest(int[] seats) {
        int max = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                list.add(i);
            }
            int l = list.size();
            if (l >= 2 && i >= 1) {
                int tmp = list.get(l - 1) - list.get(l - 2);
                if (tmp > max) {
                    max = tmp;
                }
            }
        }
        max /= 2;
        if (seats[0] == 0) {
            max = Math.max(max, list.get(0) - 0);
        }
        if (seats[seats.length - 1] == 0) {
            max = Math.max(max, seats.length - 1 - list.get(list.size() - 1));
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxDistToClosest(new int[]{0, 0, 0, 1}));
    }
}
