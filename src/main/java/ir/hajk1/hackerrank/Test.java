package ir.hajk1.hackerrank;

import java.util.HashMap;

public class Test {
    public static void test() {
        System.out.println("hi");
    }


    public static void main(String[] args) {
        HashMap te = new HashMap();
        te.put("A", new Integer(1));
        System.out.println("te.keySet() = " + te.keySet());
    }
}

class T extends Test {
    public static void test() {

    }
}
