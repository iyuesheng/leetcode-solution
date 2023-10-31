package cn.iisheng.solution.offer;

/**
 * @author iisheng
 * @date 2022/08/06 18:23:04
 */
public class No_011_MinArray {
    
    public static int minArray(int[] numbers) {
        int first = numbers[0];
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > min) {
                min = numbers[i];
            } else if (numbers[i] == min) {
                // 什么也不做
            } else {
                return numbers[i];
            }
        }
        return first > min ? min : first;
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 2, 0, 1};
        System.out.println(minArray(arr));
    }
}
