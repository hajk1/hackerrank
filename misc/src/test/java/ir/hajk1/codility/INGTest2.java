package ir.hajk1.codility;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class INGTest2 {

    static Stream<Arguments> inputProvider() {
        return Stream.of(
            arguments(5, 2, true),
            arguments("ba", false),
            arguments("aaa", true),
            arguments("b", true),
            arguments("abba", false));
    }

    @DisplayName("Test shifting table problem")
    @ParameterizedTest
    @MethodSource("inputProvider")
    public void solutionTest(String in, boolean result) {
        INGChallenge sh = new INGChallenge();
        assertEquals(result, sh.solution(in));
    }

}
