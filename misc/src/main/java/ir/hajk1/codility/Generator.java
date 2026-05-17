package ir.hajk1.codility;

import java.util.HashSet;
import java.util.Set;

public class Generator {

    public static void main(String[] args) {
        // Implement your solution here
        int n = 3;
        System.out.println("set = " + createChars(n));
    }

    static Set<Character> createChars(int n) {
        Set<Character> set = new HashSet<>();
        char[] letters = new char[3];
        for (int i = 0; i < n; i++) {
            char c = (char) ('A' + i);
            letters[i] = c;
            set.add(c);
        }
        return set;
    }
}
