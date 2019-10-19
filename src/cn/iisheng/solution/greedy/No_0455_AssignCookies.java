package cn.iisheng.solution.greedy;

import java.util.Arrays;

/**
 * @author iisheng
 * @date 2019/08/17 10:25:28
 */
public class No_0455_AssignCookies {

    public static int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0, j = 0; i < s.length && j < g.length; i++) {
            // s[i] 饼干能满足 孩子 胃口
            if (s[i] >= g[j]) {
                count++;
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
    }
}
