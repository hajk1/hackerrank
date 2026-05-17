package ir.hajk1.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyTest2 {

    public static void main(String[] args) {
        MyTest2 mt = new MyTest2();
//        String[] strings = {"allot", "cat", "peach", "dusty", "act", "cheap"};
//        String[] queries = {"tac", "study", "peahc"};
        String[] strings = {"cat", "act", "tac", "dog", "god"};
        String[] queries = {"cat", "dog", "tac"};

        System.out.println("mt = " + mt.getSearchResults(Arrays.stream(strings).collect(Collectors.toList()), Arrays.stream(queries).collect(Collectors.toList())));


    }

    public List<List<String>> getSearchResults(List<String> words, List<String> queries) {
        // Write your code here
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        List<List<String>> result = new ArrayList<>();
        for (String query : queries) {
            char[] chars = query.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> potentialAnagrams = map.getOrDefault(key, new ArrayList<>());
            Collections.sort(potentialAnagrams);
            result.add(potentialAnagrams);
        }
        return result;
    }
}
