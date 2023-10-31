package cn.iisheng.solution.offer;

import java.util.Arrays;

/**
 * @author iisheng
 * @date 2022/08/29 22:43:34
 */
public class No_017_PrintNumbers {
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers(100)));
    }
    
    public static int[] printNumbers(int n) {
        if (n <= 0) {
            return new int[0];
        }
        int length = 9;
        while (n > 1) {
            length = length * 10 + 9;
            n--;
        }
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }
}
