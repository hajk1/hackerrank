package ir.hajk1.leetcode;

public class MyAtoi {
    public int myAtoi(String s) {
        s = s.trim();
        byte sign = 1;
        if (s.length() == 0)
            return 0;
        char st = s.charAt(0);
        if (!Character.isDigit(st)) {
            if (st != '-' && st != '+')
                return 0;
            if (st == '-')
                sign = -1;
            s = s.substring(1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (Character.isDigit(tmp)) {
                sb.append(tmp);
            } else {
                break;
            }

        }
        int tenPower = 0;
        long result = 0;
        s = sb.toString();
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                result += (Character.getNumericValue(ch) * Math.pow(10, tenPower++));
            }
        }
        if (sign > 0)
            return (int) Math.min(Integer.MAX_VALUE, result);
        else
            return (int) Math.max(Integer.MIN_VALUE, result * sign);
    }
}
