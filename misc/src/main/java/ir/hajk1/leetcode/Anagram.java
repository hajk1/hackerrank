package ir.hajk1.leetcode;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Anagram {

  public static void main(String[] args) {
    Anagram anagram = new Anagram();
    System.out.println("anagram.test(\"Python\") = " + anagram.apply("Python"));
    System.out.println("anagram.test(\"Python\") = " + anagram.apply2("Python"));

    System.out.println(anagram.solution(new int[]{1, 3, 6, 4, 1, 2}));
    System.out.println(anagram.solution(new int[]{1, 2, 3}));
    System.out.println(anagram.solution(new int[]{-1, -3}));
  }

  public int solution(int[] arr) {
    // Implement your solution here

    int[] arr2 = Arrays.stream(arr).
        filter(x -> x > 0).
        sorted().
        distinct().
        toArray();
    int count = 1;
    for (int i : arr2) {
      if (i > count) {
        break;
      }
      count++;
    }
    return count;
  }

  private String apply(String python) {
    int size = python.length();
    Stream<Character> cStream = IntStream.range(0, python.toCharArray().length)
        .mapToObj(i -> python.charAt(size - i - 1));

    return cStream.map(Objects::toString).collect(Collectors.joining());
  }

  private String apply2(String python) {
    int size = python.length();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size; i++) {
      if (i == 0) {
        sb.append(Character.toUpperCase(python.charAt(size - i - 1)));
      } else {
        sb.append(Character.toLowerCase(python.charAt(size - i - 1)));
      }

    }
    return sb.toString();
  }


}
