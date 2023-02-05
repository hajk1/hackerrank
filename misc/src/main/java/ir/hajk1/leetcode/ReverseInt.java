package ir.hajk1.leetcode;

/*
Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1],
then return 0.
 */
public class ReverseInt {
    public static void main(String[] args) {
        var x = new ReverseInt();
        System.out.println(x.reverse(123));
        System.out.println(x.reverse(-123));
        System.out.println(x.reverse(120));
        System.out.println(x.reverse(1534236469));
    }

    public int reverse(int x) {
        var r = String.valueOf(Math.abs(x));
        var is_negative = x < 0;
        var chars = r.toCharArray();
        var len = chars.length;
        var resChars = new char[len];
        for (int i = len; i > 0; i--) {
            resChars[len - i] = chars[i - 1];
        }
        try {
            var result = Integer.parseInt(new String(resChars));
            return is_negative ? result * -1 : result;
        } catch (NumberFormatException ignored) {
        }
        return 0;
    }
}
