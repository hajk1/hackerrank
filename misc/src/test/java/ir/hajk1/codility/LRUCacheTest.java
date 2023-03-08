package ir.hajk1.codility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LRUCacheTest {

  static Stream<Arguments> inputProvider() {
    return Stream.of(
        arguments(2, new String[] {"get", "put", "get", "put", "put", "get", "get"},
            new int[][] {{2}, {2, 6}, {1}, {1, 5}, {1, 2}, {1}, {2}},
            new Integer[] {-1, null, -1, null, null, 2, 6}),
        arguments(2, new String[] {"put", "put", "get", "put", "put", "get"},
            new int[][] {{2, 1}, {2, 2}, {2}, {1, 1}, {4, 1}, {2}},
            new Integer[] {null, null, 2, null, null, -1}),
        arguments(2, new String[] {"put", "put", "get", "put", "get", "put", "get", "get", "get"},
            new int[][] {{1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4}},
            new Integer[] {null, null, 1, null, -1, null, -1, 3, 4}));
  }

  @DisplayName("Test LRU cache problem")
  @ParameterizedTest
  @MethodSource("inputProvider")
  public void solutionTest(int capacity, String[] opt, int[][] input, Integer[] result) {
    LRUCache sh = new LRUCache(capacity);
    for (int i = 0; i < opt.length; i++) {
      String s = opt[i];
      switch (s) {
      case "put":
        sh.put(input[i][0], input[i][1]);
        break;
      case "get":
        int temp = sh.get(input[i][0]);
        assertEquals(result[i], temp);
      }
    }
  }

  @DisplayName("Test Queue")
  @Test
  public void solutionTest() {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.add(4);
    System.out.println("queue = " + queue);

    System.out.println("queue.poll() = " + queue.poll());
    System.out.println("queue.poll() = " + queue.poll());
    System.out.println("queue.poll() = " + queue.poll());
    System.out.println("queue = " + queue);

    queue.offer(1);
    System.out.println("queue = " + queue);
    System.out.println("queue.poll() = " + queue.poll());
    System.out.println("queue.poll() = " + queue.poll());
    System.out.println("queue = " + queue);
  }

}
