package cn.iisheng.solution.array;

import java.util.Arrays;

/**
 * @author iisheng
 * @date 2020/03/17 23:15:36
 */
public class No_1109_CorporateFlightBookings {

    public static int[] corpFlightBookings(int[][] bookings, int n) {
        // 初始化一个结果数据
        int[] result = new int[n];
        // 遍历预订记录
        for (int[] booking : bookings) {
            // ① 当遍历到一个预定记录 [i,j,k]的时候
            // ② result[i-1] 要 加 k
            result[booking[0] - 1] += booking[2];
            // ③ result[j+1] 要 减 k (j+1)<n 不然数组越界
            if (booking[1] < n) {
                result[booking[1]] -= booking[2];
            }
        }

        for (int index = 1; index < n; index++) {
            // 比如 在 预定记录 [i,j,k]的时候

            // 如果 index = i + 1, 并且 index < j + 1
            // 因为result[i] 已经 加过 k （从0变成k）
            // result[i+1] = result[i] + result[i+1] = k + 0 =k

            // 如果 index = j + 1
            // 因为result[j] 已经 加过 k（通过 result[index] += result[index - 1]）
            // 又因为 result[j+1] 已经 减了 k 通过③
            // 所以 result[j+1] = result[j] + result[j+1] = k + (-k) = 0
            result[index] += result[index - 1];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5)));
    }
}
