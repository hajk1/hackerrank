package ir.hajk1.leetcode;

/**
 * DivideTwoIntegers Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator. The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be
 * truncated to -2. Return the quotient after dividing dividend by divisor. Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1,
 * and if the quotient is strictly less than -231, then return -231.
 */
public class DivideTwoIntegers {

    public static void main(String[] args) {
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        System.out.println(divideTwoIntegers.divide(-2147483648
            , -1));
        System.out.println(divideTwoIntegers.divide(-2147483648
            , 2));//-1073741824 expexted but is 0
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }
        int result = 0;
        boolean negate = (dividend < 0) ^ (divisor < 0);
        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);

        while (longDividend >= longDivisor) {
            result++;
            longDividend -= longDivisor;
        }
        if (negate) {
            return Math.negateExact(result);
        } else {
            return result;
        }
    }
}




