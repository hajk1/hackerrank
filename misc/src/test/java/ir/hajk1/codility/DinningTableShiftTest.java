package ir.hajk1.codility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DinningTableShiftTest {

  static Stream<Arguments> inputProvider() {
    return Stream.of(
        arguments(new int[]{1, 3, 5, 2, 8, 7}, new int[]{7, 1, 9, 8, 5, 7}, 2),
        arguments(new int[]{1, 1, 1, 1}, new int[]{1, 2, 3, 4}, -1),
        arguments(new int[]{3, 5, 0, 2, 4}, new int[]{1, 3, 10, 6, 7}, 0),
        arguments(new int[]{3, 1, 4, 2}, new int[]{1, 4, 3, 2}, 3));
  }

  @DisplayName("Test shifting table problem")
  @ParameterizedTest
  @MethodSource("inputProvider")
  public void solutionTest(int[] a, int[] b, int result) {
    ShiftingTable sh = new ShiftingTable();
    assertEquals(result, sh.solution(a, b));
  }

}
