package cn.iisheng.solution.greedy;

import java.util.Arrays;

/**
 * @author iisheng
 * @date 2019/08/30 12:35:24
 */
public class No_0621_TaskScheduler {

    // 候选集合 task 数组 ["A","A","A","B","B","B"]

    // 贪心策略  将任务分块 每个完整块执行全部任务  剩下一个块 执行部分或者全部任务

    // 解决函数 计算 完整的块 有多少个

    // 可行函数 不完满足完成块 停止

    // 解集合 题解

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] c = new int[26];
        for (char t : tasks) {
            c[t - 'A']++;
        }
        Arrays.sort(c);
        int i = 25;
        while (i >= 0 && c[i] == c[25]) {
            i--;
        }
        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
    }
}
