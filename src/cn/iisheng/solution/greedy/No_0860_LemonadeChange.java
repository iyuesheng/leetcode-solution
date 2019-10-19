package cn.iisheng.solution.greedy;

/**
 * @author iisheng
 * @date 2019/08/16 17:06:39
 */
public class No_0860_LemonadeChange {

    public static boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) {
            return true;
        }

        int count5 = 0;
        int count10 = 0;
        int count20 = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                count5++;
            } else if (bills[i] == 10) {
                if (count5 >= 1) {
                    count5--;
                    count10++;
                } else {
                    return false;
                }
            } else if (bills[i] == 20) {
                if (count10 >= 1 && count5 >= 1) {
                    count20++;
                    count10--;
                    count5--;
                    continue;
                } else if (count10 == 0) {
                    if (count5 >= 3) {
                        count5 -= 3;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5,5,10,10,20}));
    }
}

