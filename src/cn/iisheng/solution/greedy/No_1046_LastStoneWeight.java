package cn.iisheng.solution.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author iisheng
 * @date 2019/06/28 08:39:44
 */
public class No_1046_LastStoneWeight {

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue((Comparator<Integer>) (o1, o2) -> o2 - o1);

        for (int stone : stones) {
            priorityQueue.add(stone);
        }
        while (priorityQueue.size() > 1) {
            int a = priorityQueue.poll();
            int b = priorityQueue.poll();
            priorityQueue.add(a - b);
        }
        return priorityQueue.poll();
    }
}
