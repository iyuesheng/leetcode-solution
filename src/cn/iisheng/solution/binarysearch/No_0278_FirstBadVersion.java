package cn.iisheng.solution.binarysearch;

/**
 * @author iisheng
 * @date 2019/10/16 14:14:01
 */
public class No_0278_FirstBadVersion {

    public static int firstBadVersion(int n) {
        int l = 0;
        int r = n;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (isBadVersion(m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
//        return binarySearch(0, n);
    }

    public static int binarySearch(int left, int right) {
        int mid = left + ((right - left) >> 1);
        if (!isBadVersion(mid)) {
            return binarySearch(mid + 1, right);
        } else {
            return binarySearch(left, mid);
        }
    }

    public int d(int n) {
        int l = 1;
        while (l < n) {
            int mid = l + ((n - l) >> 1);
            if (isBadVersion(mid)) {
                n = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }


    public static int bs(int left, int right) {
        while (true) {
            int mid = left + ((right - left) >> 1);
            if (isBadVersion(mid)) {
                if (mid == 1) {
                    return mid;
                }
                if (mid - 1 > 0) {
                    if (!isBadVersion(mid - 1)) {
                        return mid;
                    } else {
                        right = mid - 1;
                    }
                }

            } else {
                left = mid + 1;
            }
        }
    }

    public static boolean isBadVersion(int version) {
        return true;
    }

}
