package ir.hajk1.codility;

import ir.hajk1.leetcode.AllOne2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AllOneTest {
    @Test
    void test1() {
        AllOne2 allOne = new AllOne2();
        allOne.inc("hello");
        allOne.inc("hello");
        assertEquals("hello", allOne.getMaxKey()); // return "hello"
        assertEquals("hello", allOne.getMinKey()); // return "hello"
        allOne.inc("leet");
        assertEquals("hello", allOne.getMaxKey()); // return "hello"
        assertEquals("leet", allOne.getMinKey()); // return "leet"
        allOne.dec("leet");
        assertEquals("hello", allOne.getMaxKey()); // return "hello"
        assertEquals("hello", allOne.getMinKey()); // return "hello"
    }

    @Test
    void test2() {
        AllOne2 allOne = new AllOne2();
        allOne.inc("hello");
        allOne.inc("goodbye");
        allOne.inc("hello");
        allOne.inc("hello");
        assertEquals("hello", allOne.getMaxKey()); // return "hello"
        allOne.inc("leet");
        allOne.inc("code");
        allOne.inc("leet");
        allOne.dec("hello");
        allOne.inc("leet");
        allOne.inc("code");
        allOne.inc("code");
        assertEquals("leet", allOne.getMaxKey()); // return "hello"
    }

    @Test
    void test3() {
        AllOne2 allOne = new AllOne2();
        assertEquals("", allOne.getMaxKey()); // return "hello"
        assertEquals("", allOne.getMinKey()); // return "hello"
    }

    //    ["AllOne","inc","inc","inc","inc","inc","dec","dec","getMaxKey","getMinKey"]
//    [[],["a"],["b"],["b"],["b"],["b"],["b"],["b"],[],[]]
    @Test
    void test4() {
        AllOne2 allOne = new AllOne2();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("b");
        allOne.dec("b");
        allOne.dec("b");
        assertEquals("b", allOne.getMaxKey()); // return "hello"
        assertEquals("a", allOne.getMinKey()); // return "hello"
    }

    //    ["AllOne","inc","inc","inc","inc","inc","inc","inc","inc","inc","inc","inc","inc","getMinKey"]
//    [[],["a"],["b"],["c"],["d"],["a"],["b"],["c"],["d"],["c"],["d"],["d"],["a"],[]]
    @Test
    void test5() {
        AllOne2 allOne = new AllOne2();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("d");
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("d");
        allOne.inc("c");
        allOne.inc("d");
        allOne.inc("d");
        allOne.inc("a");
        assertEquals("b", allOne.getMinKey()); // return "hello"
        assertEquals("d", allOne.getMaxKey()); // return "hello"
    }
}
