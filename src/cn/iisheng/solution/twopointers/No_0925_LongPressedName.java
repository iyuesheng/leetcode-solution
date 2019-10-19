package cn.iisheng.solution.twopointers;

/**
 * @author iisheng
 * @date 2019/10/09 18:43:02
 */
public class No_0925_LongPressedName {

    public static boolean isLongPressedName(String name, String typed) {

        int slow = 0;
        int fast = 0;

        while (slow < name.length() && fast < typed.length()) {
            if (name.charAt(slow) == typed.charAt(fast)) {
                slow++;
                fast++;
            } else {
                fast++;
            }
        }

        if (slow == name.length()) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isLongPressedName("vtkgn", "vttkgnn"));
        System.out.println(isLongPressedName("kikcxmvzi", "kiikcxxmmvvzz"));
        System.out.println(isLongPressedName("alex", "aaleex"));
        System.out.println(isLongPressedName("saeed", "ssaaedd"));
        System.out.println(isLongPressedName("leelee", "lleeelee"));
    }
}