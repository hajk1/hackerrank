package ir.hajk1.codility;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class INGChallenge2 {


    Set<Character> set = new HashSet<>();

    public static void main(String[] args) {
        INGChallenge2 ch = new INGChallenge2();

        System.out.println("ch.solution(5,2) = " + ch.solution(5, 2));
        System.out.println("ch.solution(5,2) = " + ch.solution(8, 3));
        System.out.println("ch.solution(5,2) = " + ch.solution(3, 2));
    }

    public String solution(int n, int k) {
        // Implement your solution here
        char[] letters = new char[k];
        for (int i = 0; i < k; i++) {
            char c = (char) ('a' + i);
            letters[i] = c;
            set.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < (n + 1) / 2; i++) {
            char c = removeRandom();
            sb.append(c);
        }

        String left = sb.toString();
        String right = new StringBuilder(left).reverse().toString();
        if (n % 2 == 1) {
            right = right.substring(1);
        }
        return left + right;
    }

    private char removeRandom() {
        int index = new Random().nextInt(set.size());
        int i = 0;
        for (Character c : set) {
            if (i == index) {
                if (set.size() > 1) {
                    set.remove(c);
                }
                return c;
            }
            i++;
        }
        throw new RuntimeException("should not reach here");
    }

}
