package ir.hajk1.leetcode;

public class Palindrome2 {

    public static void main(String[] args) {
        Palindrome2 palindrome = new Palindrome2();
        System.out.println("result = " + palindrome.isPalindrome(10));
        System.out.println("result = " + palindrome.isPalindrome(123));
        System.out.println("result = " + palindrome.isPalindrome(121));
        System.out.println("result = " + palindrome.isPalindrome(1221));
        System.out.println("result = " + palindrome.isPalindrome(-1221));

    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x / 10 == 0) {
            return true;
        }
        int numberODigits = (int) (Math.log10(x) + 1);
        for (int i = 0; i < numberODigits / 2; i++) {
            int left = (int) (x / Math.pow(10, numberODigits - i - 1)) % 10;
            int right = (int) (x / Math.pow(10, i)) % 10;
            if (left != right) {
                return false;
            }
        }
        return true;
    }
}
