package org.dullnull.solution.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author iisheng
 * @date 2019/08/02 06:49:26
 */
public class No_1002_FindCommonCharacters {

    public static void main(String[] args) {
        List<String> list = commonChars(new String[]{"cool", "lock", "cook"});
        list.forEach(str -> System.out.print(str));
    }

    public static List<String> commonChars(String[] A) {
        int n = A.length;
        // 记录 A[i] 所有2个字母 出现的次数
        int[][] array = new int[n][26];

        // 填充数据
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                array[i][A[i].charAt(j) - 'a'] = array[i][A[i].charAt(j) - 'a'] + 1;
            }
        }

        List<String> result = new ArrayList<>();

        // 遍历 每个字母 所有A[i] 出现的 最小次数
        for (int j = 0; j < 26; j++) {
            int min = 100;
            for (int i = 0; i < n; i++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                }
            }
            if (min > 0) {
                for (int k = 0; k < min; k++) {
                    result.add(Character.toString((char) ('a' + j)));
                }
            }
        }
        // 输入到结果中
        return result;
    }
}