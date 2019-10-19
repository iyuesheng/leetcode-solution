package cn.iisheng.solution.greedy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author iisheng
 * @date 2019/10/19 20:21:26
 */
public class No_0135_Candy {

    public static int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        }
        if (ratings.length == 1) {
            return 1;
        }
        // 初始值 第0个小孩 给1个糖果
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        if (ratings[0] > ratings[1]) {
            candies[0] = 2;
        }
        int i;
        for (i = 1; i < ratings.length - 1; i++) {
            // 给第i个分配糖果
            // 如果比i-1 评分高
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = 2;
            } else {
                candies[i] = 1;
            }

            for (int m = i; m > 0; m--) {
                if (ratings[m - 1] > ratings[m]) {
                    if (candies[m] >= candies[m - 1]) {
                        candies[m - 1] = candies[m] + 1;
                    }
                } else {
                    break;
                }
            }

            for (int m = i; m > 0; m--) {
                if (ratings[m - 1] < ratings[m]) {
                    if (candies[m] <= candies[m - 1]) {
                        candies[m] = candies[m - 1] + 1;
                    }
                } else {
                    break;
                }
            }

        }
        if (ratings[i] > ratings[i - 1]) {
            candies[i] = candies[i - 1] + 1;
        } else {
            candies[i] = 1;
        }

        int sum = 0;
        for (int m = 0; m < candies.length; m++) {
            sum += candies[m];
        }

        return sum;
    }


    /**
     * 失败的方法 hashMap 一个key 一个value
     *
     * @param ratings
     * @return
     */
    public static int candy1(int[] ratings) {

        int length = ratings.length;

        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return 1;
        }

        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0; i < length; i++) {
            map.put(ratings[i], i);
        }

        Arrays.sort(ratings);

        int[] candies = new int[length];

        int sum = 0;

        for (int i = 0; i < length; i++) {

            int index = map.get(ratings[i]);
            // 中间位置
            if (index > 0 && index < length - 1) {
                if (candies[index - 1] == 0 && candies[index + 1] == 0) {
                    candies[index] = 1;
                } else {
                    candies[index] = Math.max(candies[index - 1], candies[index + 1]) + 1;
                }
            }
            // 首位
            if (index == 0) {
                candies[index] = candies[index + 1] + 1;
            }
            // 末位
            if (index == length - 1) {
                candies[index] = candies[index - 1] + 1;
            }

            sum += candies[index];
        }

        System.out.println(Arrays.toString(candies));
        return sum;
    }


    public static int candy2(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        }
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }
        int result = candies[ratings.length - 1];

        for (int i = ratings.length - 2; i >= 0; i--) {
            int temp = 1;
            if (ratings[i] > ratings[i + 1]) {
                temp = candies[i + 1] + 1;
            }
            candies[i] = Math.max(candies[i], temp);
            result += candies[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(candy2(new int[]{1, 0, 2}));
        System.out.println(candy2(new int[]{1, 2, 2}));
        System.out.println(candy2(new int[]{1, 6, 10, 8, 7, 3, 2}));
    }
}
