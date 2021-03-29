package cn.iisheng.solution.string;

/**
 * @author iisheng
 * @date 2021/03/26 16:17:07
 */
public class No_0008_StringToInteger {

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));

        System.out.println(myAtoi("2147483646"));

        System.out.println(myAtoi("  +  413"));
    }

    public static int myAtoi(String s) {
        Boolean negative = null;
        int sum = 0;
        // 遍历到了 整数 没有
        boolean digit = false;
        for (char c : s.toCharArray()) {
            if (!digit) {
                if (c == '-') {
                    if (negative == null) {
                        negative = true;
                    } else {
                        return 0;
                    }
                } else if (c == '+') {
                    if (negative == null) {
                        negative = false;
                    } else {
                        return 0;
                    }
                } else if (c == ' ' && negative == null) {
                    continue;
                } else if (isDigit(c)) {
                    digit = true;
                    // 这块需要判断 是否 溢出
                    sum = calculate(negative == null ? false : negative, sum, c);
                } else {
                    // 其他字符 返回 0
                    return 0;
                }
            } else {
                if (isDigit(c)) {
                    digit = true;
                    // 这块需要判断 是否 溢出
                    sum = calculate(negative == null ? false : negative, sum, c);
                } else {
                    return sum;
                }
            }
        }

        return sum;
    }

    private static int calculate(boolean negative, int sum, char c) {
        int radix = 10;
        int cur = Character.digit(c, radix);
        int max;
        int last;

        if (!negative) {
            max = Integer.MAX_VALUE / radix;
            last = Integer.MAX_VALUE % radix;
        } else {
            max = Integer.MIN_VALUE / radix;
            last = Integer.MIN_VALUE % radix;
        }
        // 正数
        if (!negative) {
            if (max < sum || (max == sum && last <= cur)) {
                return Integer.MAX_VALUE;
            } else {
                int result = sum * radix;
                result += cur;
                return result;
            }
        } else {
            // 负数
            if (max > sum || (max == sum && cur + last >= 0)) {
                return Integer.MIN_VALUE;
            } else {
                int result = sum * radix;
                result -= cur;
                return result;
            }
        }
    }

    private static boolean isDigit(char c) {
        if (c == '0') {
            return true;
        }
        if (c == '1') {
            return true;
        }
        if (c == '2') {
            return true;
        }
        if (c == '3') {
            return true;
        }
        if (c == '4') {
            return true;
        }
        if (c == '5') {
            return true;
        }
        if (c == '6') {
            return true;
        }
        if (c == '7') {
            return true;
        }
        if (c == '8') {
            return true;
        }
        if (c == '9') {
            return true;
        }
        return false;
    }
}
