package cn.iisheng.solution.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author iisheng
 * @date 2020/03/05 23:54:53
 */
public class No_0448_FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] array = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            array[nums[i - 1]] = nums[i - 1];
        }

        for (int i = 1; i <= nums.length; i++) {
            if (array[i] != i) {
                list.add(i);
            }
        }
        return list;
    }
}
