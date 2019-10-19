package cn.iisheng.solution.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author iisheng
 * @date 2019/10/12 13:36:32
 */
public class No_0215_KthLargestElementInAnArray {

    public static int findKthLargest(int[] nums, int k) {
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = nums[i];
        }

        Arrays.sort(result);
//        System.out.println("初始化数组：" + Arrays.toString(result));

        for (int i = k; i < nums.length; i++) {
            int index = -1;
            for (int j = 0; j < k; j++) {
                if (nums[i] > result[j]) {
                    index++;
                }
            }
            if (index > -1) {
                for (int m = 0; m < index; m++) {
                    result[m] = result[m + 1];
                }
                result[index] = nums[i];
            }
        }

//        System.out.println("计算之后的结果：" + Arrays.toString(result));
        return result[0];
    }

    public static int findKthLargestHeap(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue();
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        System.out.println(findKthLargestHeap(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
