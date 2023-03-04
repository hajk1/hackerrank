package ir.hajk1.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AnagramString {

// You are given a list of strings, create a program that groups anagrams together.
// An anagram is a word formed by rearranging the letters of another word.
// For example the string ‘row’ has the following anagrams: ‘rwo’, ‘orw’, ‘owr’, ‘wor’, ‘wro’

// Example:
// Input: ["row", "a", "wor", "test", "ttes", "tset"]
// Output: [["row", "wor"], ["a"], ["test", "ttes", "tset"]]



  /*
   * To execute Java, please define "static void main" on a class
   * named Solution.
   *
   * If you need more classes, simply define them inline.
   */

  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java " + Runtime.version().feature());

    for (String string : strings) {
      System.out.println(string);
    }
    Collection<List<String>> result = anagram(
        new String[]{"row", "a", "wor", "test", "ttes", "tset"});
    for (List<String> arr : result) {
      System.out.println("new set:");
      for (String item : arr) {
        System.out.println(item);
      }

    }
  }

  public static Collection<List<String>> anagram(String[] input) {

    Map<String, List<String>> map = new HashMap<>();

    for (String item : input) {
      char[] chars = item.toCharArray();
      Stream<Character> cStream = IntStream.range(0, chars.length).mapToObj(i -> chars[i]);
      String sorted = cStream.sorted().map(Objects::toString).collect(Collectors.joining());
      if (!map.containsKey(sorted)) {
        map.put(sorted, new ArrayList<>());
      }
      map.get(sorted).add(item);
    }

    return map.values();
  }
}

