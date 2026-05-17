package ir.hajk1.leetcode;

public class Palindrome3 {

    public static void main(String[] args) {
        Palindrome3 palindrome = new Palindrome3();
        System.out.println("result = " + palindrome.isPalindrome(123));
        System.out.println("result = " + palindrome.isPalindrome(11));
        System.out.println("result = " + palindrome.isPalindrome(-11));
        System.out.println("result = " + palindrome.isPalindrome(1221));

    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x / 10 == 0) {
            return true;
        }
        String str = String.valueOf(x);
        return str.contentEquals(new StringBuilder(str).reverse());
    }
}
