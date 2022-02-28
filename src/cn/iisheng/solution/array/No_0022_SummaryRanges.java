package cn.iisheng.solution.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author iisheng
 * @date 2022/02/28 15:29:16
 */
public class No_0022_SummaryRanges {

    public static List<String> summaryRanges(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        if (nums.length == 1) {
            result.add(nums[0] + "");
            return result;

        }

        int first = 0;
        int next = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[next] + 1 == nums[next + 1]) {
                next++;
                continue;
            } else {
                if (first == next) {
                    result.add(nums[first] + "");
                } else {
                    result.add(nums[first] + "->" + nums[next]);
                }
                next++;
                first = next;
            }
        }

        if (nums[next - 1] + 1 == nums[next]) {
            result.add(nums[first] + "->" + nums[next]);
        } else {
            result.add(nums[first] + "");
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{-1}));
    }
}
