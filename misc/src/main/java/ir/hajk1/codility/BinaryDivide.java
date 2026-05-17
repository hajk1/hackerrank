package ir.hajk1.codility;

import java.util.Arrays;

public class BinaryDivide {

    /**
     *
     * @param s
     * @return
     */
    static int solution(String s) {
        s = s.replaceAll("^0+", "");
        int count = 0;
        char[] chars = s.toCharArray();
        while (!isZero(chars)) {
            if (isEvenNumber(chars)) {
                chars = binaryDivideByTwo(chars);
            } else {
                chars = binaryMinusOne(chars);
            }
            count++;
        }
        return count;
    }

    public static char[] binaryMinusOne(char[] chars) {
        chars[chars.length - 1] = '0';
        return chars;
    }

    public static char[] binaryDivideByTwo(char[] s) {
        return Arrays.copyOfRange(s, 0, s.length - 1);
//        return IntStream.range(0, s.length-1).mapToObj(i ->s[i]).toArray();
    }

    private static boolean isZero(char[] s) {
        if (s.length == 1) {
            return (s[0] == '0');
        }
        return false;
    }

    private static boolean isEvenNumber(char[] input) {
        return input[input.length - 1] == '0';
    }


}
