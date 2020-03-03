package cn.iisheng.solution.divideconquer;

/**
 * @author iisheng
 * @date 2020/03/03 22:33:52
 */
public class No_0004_MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8}));
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // nums1 为 空数组  只计算 nums2 的中位数
        if (nums1.length == 0) {
            // 偶数
            return median(nums2);
        }
        // nums2 为 空数组  只计算 nums1 的中位数
        if (nums2.length == 0) {
            return median(nums1);
        }

        // 两个数组都不是空数组
        int i = 0, j = 0;
        int prev = Math.min(nums1[0], nums2[0]);
        int beforePrev = prev;

        while (i + j < (nums1.length + nums2.length) / 2 + 1) {
            beforePrev = prev;
            if (i == nums1.length) {
                prev = nums2[j];
                j++;
                continue;
            }
            if (j == nums2.length) {
                prev = nums1[i];
                i++;
                continue;
            }
            if (nums1[i] <= nums2[j]) {
                prev = nums1[i];
                i++;
            } else {
                prev = nums2[j];
                j++;
            }
        }

        if ((nums1.length + nums2.length) % 2 == 0) {
            return (beforePrev + prev) / 2.0;
        } else {
            return prev;
        }
    }

    private static double median(int[] nums) {
        // 偶数
        if (nums.length % 2 == 0) {
            return (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.0;
        } else {
            // 奇数
            return nums[nums.length / 2];
        }
    }
}
