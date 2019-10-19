package org.dullnull.solution.string;

/**
 * @author iisheng
 * @date 2019/10/19 13:03:44
 */
public class No_0443_StringCompression {

    public static int compress(char[] chars) {
        if (chars.length == 0) {
            return 0;
        }

        int count = 1;
        int index = 1;
        int realIndex = 0;
        while (index < chars.length) {
            if (chars[index - 1] == chars[index]) {
                count++;
                index++;
            } else {
                chars[realIndex] = chars[index - 1];
                realIndex++;
                if (count > 1) {
                    char[] countStr = (count + "").toCharArray();
                    for (int i = 0; i < countStr.length; i++) {
                        chars[realIndex] = countStr[i];
                        realIndex++;
                    }
                    count = 1;
                }
                index++;
            }
        }

        chars[realIndex] = chars[index - 1];
        realIndex++;

        if (count > 1) {
            char[] countStr = (count + "").toCharArray();
            for (int i = 0; i < countStr.length; i++) {
                chars[realIndex] = countStr[i];
                realIndex++;
            }
        }

        return realIndex;
    }

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        System.out.println(compress(new char[]{'a'}));
        System.out.println(compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
        System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
    }
}