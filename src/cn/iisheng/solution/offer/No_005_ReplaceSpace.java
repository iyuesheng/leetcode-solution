package cn.iisheng.solution.offer;

/**
 * @author iisheng
 * @date 2022/07/27 20:36:58
 */
public class No_005_ReplaceSpace {
    
    public static String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        char[] result = new char[chars.length * 3];
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c != ' ') {
                result[j] = c;
                j++;
            } else {
                result[j] = '%';
                result[j + 1] = '2';
                result[j + 2] = '0';
                j += 3;
            }
        }
        return new String(result, 0, j);
    }
    
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
}
