package ir.hajk1.codility;

import ir.hajk1.qualified.ChallengeWordle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("colorizeWordle")
public class ColorizeWordleTest {

    @Nested
    @DisplayName("non duplicates")
    class NonDuplicates {

        @Test
        @DisplayName("should detect no letters matching")
        public void shouldDetectNoLettersMatching() {
            assertEquals("BBBBB", ChallengeWordle.colorizeWordle("alpha", "truck"));
        }

        @Test
        @DisplayName("should detect all letters matching")
        public void shouldDetectAllLettersMatching() {
            assertEquals("GGGGG", ChallengeWordle.colorizeWordle("truck", "truck"));
        }

        @Test
        @DisplayName("should detect one letter not matching")
        public void shouldDetectOneLetterNotMatching() {
            assertEquals("GGBGG", ChallengeWordle.colorizeWordle("truck", "track"));
        }

        @Test
        @DisplayName("should detect one letter not matching in a different spot")
        public void shouldDetectOneLetterNotMatchingInADifferentSpot() {
            assertEquals("BGGGG", ChallengeWordle.colorizeWordle("track", "crack"));
        }
    }

    @Nested
    @DisplayName("duplicates")
    class Duplicates {

        @Test
        @DisplayName("should only report the first two of three letters as present in the result")
        public void shouldOnlyReportTheFirstTwoOfThreeLettersAsPresentInTheResult() {
            assertEquals("GGYBB", ChallengeWordle.colorizeWordle("mamma", "maxim"));
        }

        @Test
        @DisplayName("should handle guess and hidden sharing two letters at different locations")
        public void shouldHandleGuessAndHiddenSharingTwoLettersAtDifferentLocations() {
            assertEquals("YYYBB", ChallengeWordle.colorizeWordle("reeks", "elder"));
        }

        @Test
        @DisplayName("should work with a duplicate in guess that appears once at the same location in hidden")
        public void shouldWorkWithADuplicateInGuessThatAppearsOnceAtTheSameLocationInHidden() {
            assertEquals("BBBGG", ChallengeWordle.colorizeWordle("preen", "alien"));
        }

        @Test
        @DisplayName("should work with a duplicate in guess that appears once elsewhere in hidden")
        public void shouldWorkWithADuplicateInGuessThatAppearsOnceElsewhereInHidden() {
            assertEquals("YBBBB", ChallengeWordle.colorizeWordle("alpha", "tacks"));
        }

        @Test
        @DisplayName("should report only the first of two duplicate letters in guess when one is in result with matching location")
        public void shouldReportOnlyTheFirstOfTwoDuplicateLettersInGuessWhenOneIsInResultWithMatchingLocation() {
            assertEquals("BBBBG", ChallengeWordle.colorizeWordle("toast", "burnt"));
        }

        @Test
        @DisplayName("should report only the first of three duplicate letters in guess when one is in result without matching location")
        public void shouldReportOnlyTheFirstOfThreeDuplicateLettersInGuessWhenOneIsInResultWithoutMatchingLocation() {
            assertEquals("YBYBY", ChallengeWordle.colorizeWordle("iiwis", "swift"));
        }

        @Test
        @DisplayName("should detect no letters matching")
        public void shouldDetectNoLettersMatching() {
            assertEquals("BBBBB", ChallengeWordle.colorizeWordle("soils", "abbey"));
        }

        @Test
        @DisplayName("should detect all letters matching")
        public void shouldDetectAllLettersMatching() {
            assertEquals("GGGGG", ChallengeWordle.colorizeWordle("toast", "toast"));
        }
    }
}
