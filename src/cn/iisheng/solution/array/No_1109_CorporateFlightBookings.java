package cn.iisheng.solution.array;

import java.util.Arrays;

/**
 * @author iisheng
 * @date 2020/03/17 23:15:36
 */
public class No_1109_CorporateFlightBookings {

    public static int[] corpFlightBookings(
            int[][] bookings, int n) {

        int[] answer = new int[n];

        // 遍历bookings 计算航班i+1 对航班i 变化的预订数
        for (int[] b : bookings) {
            // 增加的预订数
            answer[b[0] - 1] += b[2];
            // 防止数组越界
            if (b[1] < n) {
                // 减少的预订数量
                answer[b[1]] -= b[2];
            }
        }

        // 航班i的预订数等于,i-1的预订数，加i时刻变化的预定数
        for (int i = 1; i < n; i++) {
            answer[i] += answer[i - 1];
        }
        return answer;
    }

    public int[] corpFlightBookings3(
            int[][] bookings, int n) {

        int[] answer = new int[n];

        // 遍历整个bookings数组
        for (int[] b : bookings) {
            // 内层循环把每个航班预订数加上
            for (int i = b[0] - 1;
                 i <= b[1] - 1; i++) {
                answer[i] += b[2];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5)));
    }
}
