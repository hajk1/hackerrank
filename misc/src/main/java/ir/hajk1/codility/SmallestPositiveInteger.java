package ir.hajk1.codility;

import java.util.Arrays;

/*
that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class SmallestPositiveInteger {

    public static void main(String[] args) {
        var sample = new SmallestPositiveInteger();
        System.out.println("sample = " + sample.solution(new int[]{1, 3, 6, 4, 1, 2}));
        System.out.println("sample = " + sample.solution(new int[]{1, 2, 3}));
        System.out.println("sample = " + sample.solution(new int[]{-1, -3}));
    }

    public int solution(int[] A) {
        // Implement your solution here
        int[] positive = Arrays.stream(A)
                .filter(a -> a > 0)
                .distinct()
                .sorted()
                .toArray();

        int result = 1;
        for (int i : positive) {
            if (i == result)
                result++;
            else
                break;
        }
        return result;
    }
}
