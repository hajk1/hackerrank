package ir.hajk1.leetcode;

public class Palindrome {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x / 10 == 0)
            return true;
        int tmp = x;
        int reverse = 0;
        do {
            reverse = (reverse * 10) + (x % 10);
            x = x / 10;
        } while (x > 0);

        return tmp == reverse;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println("result = " + palindrome.isPalindrome(123));

    }
}
