package cn.iisheng.solution.string;

/**
 * @author iisheng
 * @date 2020/03/08 10:32:39
 */
public class No_1374_GenerateAStringWithCharactersThatHaveOddCounts {

    public static String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        // 奇数
        if (n % 2 == 1) {
            for (int i = 0; i < n; i++) {
                sb.append('a');
            }
        } else {
            // 偶数
            for (int i = 0; i < n - 1; i++) {
                sb.append('a');
            }
            sb.append('b');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateTheString(500));
    }
}
