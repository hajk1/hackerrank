package ir.hajk1.codility;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class INGTest {

    static Stream<Arguments> inputProvider() {
        return Stream.of(
            arguments("aabb", true),
            arguments("ba", false),
            arguments("aaa", true),
            arguments("b", true),
            arguments("abba", false));
    }

    @DisplayName("Test shifting table problem")
    @ParameterizedTest(name = "{index} ==> the result of ''{0}'' is {1}")
    @MethodSource("inputProvider")
    public void solutionTest(String in, boolean result) {
        INGChallenge sh = new INGChallenge();
        assertEquals(result, sh.solution(in));
    }

}
