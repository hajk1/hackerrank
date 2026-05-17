package ir.hajk1.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramModern {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> result = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            int key = Arrays.hashCode(chars);
            result.computeIfAbsent(key, k -> new java.util.ArrayList<>()).add(str);
        }

        return result.values().stream().toList();
    }


}
