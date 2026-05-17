package ir.hajk1.codility;

import ir.hajk1.hackerrank.WordOrdering;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordOrderingTest {

    @Test
    void test() {
        WordOrdering s = new WordOrdering();

        String[] input = {"hello", "word", "hell", "words"};

        String order = "hlabcdefgijkmnopqrstuvwxyz";

        String[] result = s.sortByDefinedOrder(input, order);

        Assertions.assertArrayEquals(new String[] {"hell", "hello", "word", "words"}, result);
    }


}