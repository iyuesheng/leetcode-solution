package cn.iisheng.solution.offer;

/**
 * @author iisheng
 * @date 2022/08/06 10:21:44
 */
public class No_010_NumWays {
    
    public static int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        
        // f(n) = SUM [f(n-1), f(n-2)]
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
            if (arr[i] > 1000000007) {
                arr[i] = arr[i] % 1000000007;
            }
        }
        return arr[n];
    }
    
    public static void main(String[] args) {
        System.out.println(numWays(3));
    }
}
