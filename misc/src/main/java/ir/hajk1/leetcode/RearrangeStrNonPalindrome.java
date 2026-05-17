package ir.hajk1.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RearrangeStrNonPalindrome {

    public static String solve(String S) {
        char[] chars = S.toCharArray();
        Arrays.sort(chars);

        int n = chars.length;

        // Check if it's possible to create non-palindrome
        // Count character frequencies
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : chars) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // If any character appears more than (n+1)/2 times, impossible
        for (int count : freq.values()) {
            if (count > (n + 1) / 2) {
                return "impossible";
            }
        }

        // Try to rearrange to avoid matching pairs
        // Simple approach: if sorted string has no matching pairs, return it
        if (!hasMatchingPairs(chars)) {
            return new String(chars);
        }

        // If sorted has matching pairs, try swapping adjacent different characters
        for (int i = 0; i < n - 1; i++) {
            if (chars[i] != chars[i + 1]) {
                // Swap
                char temp = chars[i];
                chars[i] = chars[i + 1];
                chars[i + 1] = temp;

                if (!hasMatchingPairs(chars)) {
                    return new String(chars);
                }

                // Swap back if it didn't work
                temp = chars[i];
                chars[i] = chars[i + 1];
                chars[i + 1] = temp;
            }
        }

        return "impossible";
    }

    private static boolean hasMatchingPairs(char[] chars) {
        int n = chars.length;
        for (int i = 0; i < n / 2; i++) {
            if (chars[i] == chars[n - 1 - i]) {
                return true; // Found a matching pair, violates condition
            }
        }
        return false; // No matching pairs found, satisfies condition
    }

    public static void main(String[] args) {
        System.out.println(solve("aaab")); // Output: "impossible"
        System.out.println(solve("aabb")); // Possible Output: "abab" or "baba"
        System.out.println(solve("abcde")); // Possible Output: "abcde" or any permutation without matching pairs
        System.out.println(solve("aaa")); // Output: "impossible"
        System.out.println(solve("a")); // Output: "a"
        System.out.println(solve("aa")); // Output: "impossible"
        System.out.println(solve("aab")); // Possible Output: "aba"
        System.out.println(solve("abca")); // Possible Output: "aabc"
    }

}
