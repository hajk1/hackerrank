package ir.hajk1.codility;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int result = solution.solution(new int[] {1, 2, 3, 4, 5});
        int expected = 6;
        System.out.println("Test 1: " + (result == expected ? "✓ PASS" : "✗ FAIL") + " (expected: " + expected + ", got: " + result + ")");

        // Test case 2
        result = solution.solution(new int[] {1, 2, 3});
        expected = 4;
        System.out.println("Test 2: " + (result == expected ? "✓ PASS" : "✗ FAIL") + " (expected: " + expected + ", got: " + result + ")");

        // Test case 3
        result = solution.solution(new int[] {-1, -3});
        expected = 1;
        System.out.println("Test 3: " + (result == expected ? "✓ PASS" : "✗ FAIL") + " (expected: " + expected + ", got: " + result + ")");
        expected = 1;
        result = solution.solution(new int[] {0});
        System.out.println("Test 4: " + (result == expected ? "✓ PASS" : "✗ FAIL") + " (expected: " + expected + ", got: " + result + ")");
        expected = 2;
        result = solution.solution(new int[] {1});
        System.out.println("Test 5: " + (result == expected ? "✓ PASS" : "✗ FAIL") + " (expected: " + expected + ", got: " + result + ")");
        result = solution.solution(new int[] {10, 11, 12, 8, 9, 14, 15, -1, 0});
        expected = 1;
        System.out.println("Test 6: " + (result == expected ? "✓ PASS" : "✗ FAIL") + " (expected: " + expected + ", got: " + result + ")");
    }

    public int solution(int[] A) {
        // Implement your solution here
        int result = 1;
        Arrays.sort(A);
        for (int a : A) {
            if (a <= 0) {
                continue;
            }
            if (a == result) {
                result++;
                continue;
            }
            if (a - result >= 1) {
                return result;
            }
        }
        return result;
    }


}
