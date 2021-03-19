package cn.iisheng.solution.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author iisheng
 * @date 2021/03/18 14:52:43
 */
public class No_0006_ZigZagConversion {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }

    public static String convert1(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    ret.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return ret.toString();
    }

    public static String convert2(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }

            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

    public static String convert(String s, int numRows) {
        if (s == null) {
            return null;
        }

        int length = s.length();
        if (length == 0 || numRows == 1) {
            return s;
        }

        int dataLength = length / 2 + 1;
        char[][] data = new char[numRows][dataLength];
        // 循环遍历 字符串 s
        int current = 0;
        boolean isVertical = true;
        int i = 0, j = 0;
        while (current < length) {
            if (isVertical) {
                for (int k = 0; k < numRows && current < length; k++) {
                    data[i][j] = s.charAt(current);
                    current++;
                    i++;
                }
                isVertical = false;
                i--;
            } else {
                for (int k = 0; k < numRows - 1 && current < length; k++) {
                    i--;
                    j++;
                    data[i][j] = s.charAt(current);
                    current++;
                }
                isVertical = true;
                current--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < numRows; k++) {
            for (int g = 0; g < dataLength; g++) {
                if (data[k][g] != '\0') {
                    sb.append(data[k][g]);
                }
            }
        }

        return sb.toString();
    }
}
