package cn.iisheng.solution.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author iisheng
 * @date 2020/03/08 17:27:48
 */
public class No_1376_TimeNeededToInformAllEmployees {

    public static void main(String[] args) {
        System.out.println(numOfMinutes(8, 0, new int[]{-1, 5, 0, 6, 7, 0, 0, 0}, new int[]{89, 0, 0, 0, 0, 523, 241, 519}));
        System.out.println(numOfMinutes1(8, 0, new int[]{-1, 5, 0, 6, 7, 0, 0, 0}, new int[]{89, 0, 0, 0, 0, 523, 241, 519}));
    }

    public static int numOfMinutes(int n, int h, int[] manager, int[] times) {
        int[] count = new int[n];
        for (int x : manager) {
            if (x != -1) ++count[x];
        }
        int[][] children = new int[n][];
        for (int i = 0; i < n; ++i) {
            children[i] = new int[count[i]];
            count[i] = 0;
        }
        for (int i = 0; i < n; ++i) {
            int m = manager[i];
            if (m != -1) children[m][count[m]++] = i;
        }
        return get(children, times, h);
    }

    private static int get(int[][] children, int[] times, int t) {
        int ans = 0;
        if (children[t].length > 0) {
            for (int x : children[t]) ans = Math.max(ans, get(children, times, x));
            ans += times[t];
        }
        return ans;
    }

    public static int numOfMinutes1(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                graph[manager[i]].add(i);
            }
        }
        return dfs(graph, headID, informTime);
    }

    private static int dfs(List<Integer>[] graph, int src, int[] informTime) {
        int max = 0;
        for (int v : graph[src]) {
            max = Math.max(max, dfs(graph, v, informTime));
        }
        return max + informTime[src];
    }
}
