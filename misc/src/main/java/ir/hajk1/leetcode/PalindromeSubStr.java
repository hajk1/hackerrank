package ir.hajk1.leetcode;

/*
Given a string s, return the longest palindromic substring in s.
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
 */
public class PalindromeSubStr {
    public static void main(String[] args) {
//        var palin = new PalindromeSubStr();
//        System.out.println("palin.longestPalindrome() = " + palin.longestPalindrome("babad"));
//        System.out.println("palin.longestPalindrome() = " + palin.longestPalindrome("a"));
//        System.out.println("palin.longestPalindrome() = " + palin.longestPalindrome("bb"));
//        System.out.println("palin.longestPalindrome() = " + palin.longestPalindrome("1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"));
//        System.out.println("palin.longestPalindrome() = " + palin.longestPalindrome("aacabdkacaa"));
    }

    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        if (s.length() == 1)
            return s;
        int i = 0;
        while (i < s.length() && (s.length() - i > (end - start + 1))) {
            int j = s.length() - 1;
            while (j >= i) {
                if ((j - i) > (end - start) - 1) {
                    if (isPalindrome(s, i, j)) {
                        start = i;
                        end = j;
                    }
                }
                j--;
            }
            i++;
        }
        return s.substring(start, end + 1);
    }

    private boolean isPalindrome(String s1, int startIndex, int endIndex) {
        for (int i = 0; i < (endIndex - startIndex + 1) / 2; i++) {
            if (s1.charAt(startIndex + i) != s1.charAt(endIndex - i))
                return false;
        }
        return true;
    }
}
