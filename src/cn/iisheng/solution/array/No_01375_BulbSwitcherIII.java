package cn.iisheng.solution.array;

/**
 * @author iisheng
 * @date 2020/03/08 10:59:20
 */
public class No_01375_BulbSwitcherIII {

    public static int numTimesAllBlue(int[] light) {
        int length = light.length;
        boolean[] array = new boolean[length + 1];
        array[0] = true;
        int count = 0;
        // 记录 index位置之前的灯都是 黄色的
        int index = 0;
        int max = -1;
        for (int i = 0; i < length; i++) {
            array[light[i]] = true;
            if (light[i] > max) {
                max = light[i];
            }
            for (int j = index; j <= max; j++) {
                if (array[j]) {
                    index = j;
                } else {
                    break;
                }
            }
            if (index >= max) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numTimesAllBlue(new int[]{2, 1, 3, 5, 4}));
        System.out.println(numTimesAllBlue(new int[]{3, 2, 4, 1, 5}));
        System.out.println(numTimesAllBlue(new int[]{4, 1, 2, 3}));
        System.out.println(numTimesAllBlue(new int[]{2, 1, 4, 3, 6, 5}));
        System.out.println(numTimesAllBlue(new int[]{1, 2, 3, 4, 5, 6}));
    }
}
