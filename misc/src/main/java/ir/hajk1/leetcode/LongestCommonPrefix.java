package ir.hajk1.leetcode;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println("result = " + longestCommonPrefix.longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
        System.out.println("result = " + longestCommonPrefix.longestCommonPrefix(new String[] {"dog", "racecar", "car"}));
        System.out.println("result = " + longestCommonPrefix.longestCommonPrefix(new String[] {"dog"}));
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        String first = strs[0];
        if (strs.length == 1) {
            return first;
        }
        outer:
        for (int i = 0; i < first.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() < i + 1) {
                    break outer;
                }
                if (strs[j].charAt(i) != first.charAt(i)) {
                    break outer;
                }
            }
            result.append(first.charAt(i));
        }
        return result.toString();
    }
}