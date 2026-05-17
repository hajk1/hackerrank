package ir.hajk1.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {

    public static void main(String[] args) {
        LongestSubString longestSubString = new LongestSubString();
        System.out.println(longestSubString.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(longestSubString.lengthOfLongestSubstring("au"));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndex = new HashMap<>();
        int max = 0;
        int index = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (charIndex.containsKey(c) && charIndex.get(c) >= index) {
                index = charIndex.get(c) + 1;
            }
            charIndex.put(c, right);
            max = Math.max(max, right - index + 1);
        }
        return max;
    }

}
