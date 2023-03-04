package ir.hajk1.codility;

import java.util.stream.IntStream;

public class ShiftingTable {


  public void solutionTest(String[] args) {
    ShiftingTable sh = new ShiftingTable();
    int[] a = {1, 3, 5, 2, 8, 7};
    int[] b = {7, 1, 9, 8, 5, 7};
    int[] a1 = {1, 1, 1, 1};
    int[] b1 = {1, 2, 3, 4};
    int[] a2 = {3, 5, 0, 2, 4};
    int[] b2 = {1, 3, 10, 6, 7};
    int[] a3 = {3, 1, 4, 2};
    int[] b3 = {1, 4, 3, 2};
    System.out.println("sh.solution() = " + sh.solution(a, b));
    System.out.println("sh.solution() = " + sh.solution(a1, b1));
    System.out.println("sh.solution() = " + sh.solution(a2, b2));
    System.out.println("sh.solution() = " + sh.solution(a3, b3));
  }

  public int solution(int[] a, int[] b) {
    // Implement your solution here
    int step = 0;
    for (int i = 0; i < a.length; i++) {
      if (compareStep(a, b, step)) {
        return step;
      }
      step++;
    }
    return -1;
  }

  boolean compareStep(int[] a, int[] b, int n) {
    int size = a.length;
    return IntStream.range(0, a.length).
        noneMatch(i -> a[i] == ((i - n) >= 0 ? b[i - n] : b[size - n + i]));
  }

}
