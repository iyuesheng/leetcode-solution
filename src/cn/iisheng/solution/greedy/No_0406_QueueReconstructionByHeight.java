package cn.iisheng.solution.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author iisheng
 * @date 2019/08/17 10:42:51
 */
public class No_0406_QueueReconstructionByHeight {

    public static int[][] reconstructQueue(int[][] people) {
        List<int[]> temp = new ArrayList<>();
        Arrays.sort(people, (o1, o2) -> {
            return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1];
        });
        for (int i = 0; i < people.length; i++) {
            temp.add(people[i][1], people[i]);
        }
        return temp.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        // Input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
        // 排序 [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
        // Output: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] result = reconstructQueue(people);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
