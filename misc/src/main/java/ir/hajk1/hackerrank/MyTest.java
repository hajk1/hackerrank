package ir.hajk1.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyTest {

    public static void main(String[] args) {
        MyTest mt = new MyTest();
//        String[] strings = {"allot", "cat", "peach", "dusty", "act", "cheap"};
//        String[] queries = {"tac", "study", "peahc"};
//        String[] strings = {"cat", "act", "tac", "dog", "god"};
//        String[] queries = {"cat", "dog", "tac"};
        String[] strings = {"listen", "silent", "list", "enlist"};
        String[] queries = {"listen", "list"};

        System.out.println("mt = " + mt.getSearchResults(Arrays.stream(strings).collect(Collectors.toList()), Arrays.stream(queries).collect(Collectors.toList())));


    }

    public List<List<String>> getSearchResults(List<String> words, List<String> queries) {
        // Write your code here
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            map.computeIfAbsent(sortIt(word), k -> new ArrayList<>()).add(word);
        }
        List<List<String>> result = new ArrayList<>();
        for (String query : queries) {
            List<String> potentialAnagrams = map.getOrDefault(sortIt(query), new ArrayList<>());
            Collections.sort(potentialAnagrams);
            result.add(potentialAnagrams);
        }
        return result;
    }

    private String sortIt(String query) {
        char[] chars = query.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
