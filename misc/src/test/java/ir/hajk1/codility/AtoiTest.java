package ir.hajk1.codility;

import ir.hajk1.leetcode.MyAtoi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AtoiTest {
    MyAtoi atoi = new MyAtoi();

    @Test
    void test1() {
        Assertions.assertEquals(42, atoi.myAtoi("42"));
        Assertions.assertEquals(-42, atoi.myAtoi("    -42"));
        Assertions.assertEquals(4193, atoi.myAtoi("4193 with words"));
        Assertions.assertEquals(-2147483648, atoi.myAtoi("-91283472332"));
    }
}
