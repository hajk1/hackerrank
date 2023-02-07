package ir.hajk1.leetcode;

/*
Given a string s, return the longest palindromic substring in s.
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
 */
public class PalindromeSubStr {
    public static void main(String[] args) {
        var palin = new PalindromeSubStr();
        System.out.println("palin.longestPalindrome() = " + palin.longestPalindrome("babad"));
        System.out.println("palin.longestPalindrome() = " + palin.longestPalindrome("a"));
        System.out.println("palin.longestPalindrome() = " + palin.longestPalindrome("bb"));
        System.out.println("palin.longestPalindrome() = " + palin.longestPalindrome("1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"));
        System.out.println("palin.longestPalindrome() = " + palin.longestPalindrome("aacabdkacaa"));
    }

    public String longestPalindrome(String s) {
        String result = "";
        if (s.length() == 1)
            return s;
        for (int i = 0; i < s.length(); i++) {
            int j = s.length() - 1;
            while (j >= i) {
                if (s.charAt(i) == s.charAt(j)) {
                    if ((j - i) > result.length() - 1) {
                        String s1 = s.substring(i, j + 1);
                        if (isPalindrome(s1)) {
                            result = s1;
                        }
                    }
                }
                j--;
            }

        }
        return result;
    }

    private boolean isPalindrome(String s1) {
        for (int i = 0; i < s1.length() / 2; i++) {
            if (s1.charAt(i) != s1.charAt(s1.length() - i - 1))
                return false;
        }
        return true;
    }
}
