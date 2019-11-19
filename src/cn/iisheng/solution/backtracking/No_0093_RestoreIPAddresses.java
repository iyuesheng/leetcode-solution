package cn.iisheng.solution.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @author iisheng
 * @date 2019/10/29 00:42:33
 */
public class No_0093_RestoreIPAddresses {


    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>();
        dfs(res, s, "", 0, 4);
        return res;
    }

    public static void dfs(List<String> res, String s, String cur, int idx, int point) {
        int num = 0;
        if (point == 0) {
            if (idx == s.length())
                res.add(cur.substring(0, cur.length() - 1));
            return;
        }
        for (int i = idx; i < idx + 3 && i < s.length(); i++) {
            num = num * 10 + Character.getNumericValue(s.charAt(i));
            if (num > 255) continue;
            dfs(res, s, cur + num + ".", i + 1, point - 1);
            if (i == idx && s.charAt(i) == '0') break;
        }
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }
}
