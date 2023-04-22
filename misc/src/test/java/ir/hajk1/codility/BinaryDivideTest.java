package ir.hajk1.codility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BinaryDivideTest {

    @Test
    void testSolution() {
        assertEquals(7, BinaryDivide.solution("011100"));
        assertEquals(5, BinaryDivide.solution("111"));
        assertEquals(22, BinaryDivide.solution("1111010101111"));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 400_000; i++) {
            sb.append("1");
        }
        assertEquals(799_999, BinaryDivide.solution(sb.toString()));

    }

    @Test
    void testDivide() {
        assertEquals("1", BinaryDivide.binaryDivideByTwo("10".toCharArray()));
        assertEquals("100", BinaryDivide.binaryDivideByTwo("1000".toCharArray()));
        assertEquals("111111111", BinaryDivide.binaryDivideByTwo("1111111110".toCharArray()));
    }

    @Test
    void testSubtract() {
        assertEquals("10", BinaryDivide.binaryMinusOne("11".toCharArray()));
        assertEquals("110", BinaryDivide.binaryMinusOne("111".toCharArray()));
        assertEquals("11111111110", BinaryDivide.binaryMinusOne("11111111111".toCharArray()));

    }

}
