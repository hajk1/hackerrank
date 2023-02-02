package ir.hajk1.hackerrank;

import java.util.HashSet;
import java.util.Set;

/*
Given a string s, find the length of the longest
substring without repeating characters.
 */
public class LongestSubstr {
    public static void main(String[] args) {
        LongestSubstr substr = new LongestSubstr();
        System.out.println("result =" + substr.lengthOfLongestSubstring("abcabcbb"));
        System.out.println("result = " + substr.lengthOfLongestSubstring(" "));
        System.out.println("result = " + substr.lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (max > s.length() - i)
                return max;
            Set<Character> chars = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (chars.add(s.charAt(j))) {
                    max = Math.max(chars.size(), max);
                } else {
                    break;
                }
            }
        }
        return max;
    }
}
