package ir.hajk1.qualified;

import java.util.Arrays;

public class ChallengeWordle {

    public static final char GREEN = 'G';
    public static final char YELLOW = 'Y';
    public static final char BLACK = 'B';

    public static String colorizeWordle(String guess, String word) {
        Wordle wordle = new Wordle(guess, word);
        wordle.computeGreen();
        wordle.computeYellow();
        wordle.computeBlack();
        return wordle.getResultString();
    }

    static class Wordle {

        char[] guess;
        char[] word;
        char[] result;

        String resultString;

        public Wordle(String guess, String word) {
            this.guess = guess.toCharArray();
            this.word = word.toCharArray();
            this.result = new char[word.length()];
        }

        public void computeGreen() {
            for (int i = 0; i < guess.length; i++) {
                if (word[i] == guess[i]) {
                    result[i] = GREEN;
                    word[i] = 0;
                    guess[i] = 0;
                }

            }
        }

        public void computeYellow() {
            for (int i = 0; i < guess.length; i++) {
                Arrays.sort(word);
                if (guess[i] != 0) {
                    int index = Arrays.binarySearch(word, guess[i]);
                    if (index >= 0) {
                        result[i] = YELLOW;
                        word[index] = 0;
                        guess[i] = 0;
                    }
                }
            }
        }

        public void computeBlack() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < result.length; i++) {
                if (result[i] != GREEN && result[i] != YELLOW) {
                    sb.append(BLACK);
                } else {
                    sb.append(result[i]);
                }
            }
            resultString = sb.toString();
        }

        public String getResultString() {
            return this.resultString;
        }
    }
}
