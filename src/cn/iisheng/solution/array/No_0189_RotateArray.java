package cn.iisheng.solution.array;

import java.util.Arrays;

/**
 * @author iisheng
 * @date 2020/03/03 11:34:26
 */
public class No_0189_RotateArray {
    public static void main(String[] args) {
        rotate1(new int[]{1, 2, 3, 4, 5, 6}, 2);
    }

    public static void rotate1(int[] nums, int k) {
        System.out.println(Arrays.toString(nums));
        int len = nums.length;
        if (len == 0) {
            return;
        }
        k = k % len;
        if (k == 0) {
            return;
        }
        int[] t = new int[k];
        for (int i = len - k; i < len; i++) {
            t[i - (len - k)] = nums[i];
        }
        for (int i = len - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = t[i];
        }
        System.out.println(Arrays.toString(nums));
    }

    public void rotate2(int[] nums, int k) {
        if (nums.length <= 1 || k % nums.length == 0)
            return;

        k = nums.length - k % nums.length;

        int outter = gcd(nums.length, k);
        int inner = nums.length / outter;

        for (int i = 0; i < outter; i++) {
            int t = nums[i];
            int ind_new = 0;
            int ind_old = 0;
            for (int j = 0; j < inner - 1; j++) {
                ind_old = (i + k * j) % nums.length;
                ind_new = (i + k * (j + 1)) % nums.length;
                nums[ind_old] = nums[ind_new];
            }
            nums[ind_new] = t;
        }
    }

    private int gcd(int num1, int num2) {
        while (num1 != num2) {
            if (num1 > num2)
                num1 = num1 - num2;
            else
                num2 = num2 - num1;
        }
        return num2;
    }

    public static void rotate(int[] nums, int k) {
        System.out.println(Arrays.toString(nums));
        if (nums.length == 0) {
            return;
        }
        k = k % nums.length;
        int[] result = new int[nums.length];
        for (int i = 0; i < k; i++) {
            result[i] = nums[nums.length - k + i];
        }
        for (int i = 0; i < nums.length - k; i++) {
            result[i + k] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
        System.out.println(Arrays.toString(nums));
    }

    public void reverseArr(int[] num, int startPos, int endPos) {
        int i = startPos;
        int j = endPos - 1;
        while (i < j) {
            swap(num, i, j);
            i++;
            j--;
        }
    }


    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public void rotate3(int[] nums, int k) {
        int rotation = k % nums.length;
        reverseArr(nums, 0, nums.length - rotation);
        reverseArr(nums, nums.length - rotation, nums.length);
        reverseArr(nums, 0, nums.length);
    }
}
