package cn.iisheng.solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author iisheng
 * @date 2021/02/17 17:07:24
 */
public class No_0118_PascalsTriangle {

    public static void main(String[] args) {
        List<List<Integer>> list = generate(5);
        System.out.println(list);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            // 当前行 数组
            Integer[] current = new Integer[i + 1];
            // 首位 放1
            current[0] = 1;
            // 末位 放1
            int last = i + 1 - 1;
            // 末位下标 大于0 才行
            if (last > 0) {
                current[last] = 1;
            }
            if (i > 0) {
                List<Integer> lastArr = list.get(i - 1);
                for (int j = 1; j < i / 2 + 1; j++) {
                    int value = lastArr.get(j) + lastArr.get(j - 1);
                    current[j] = value;
                    current[i - j] = value;
                }
            }
            list.add(Arrays.asList(current));
        }
        return list;
    }
}
