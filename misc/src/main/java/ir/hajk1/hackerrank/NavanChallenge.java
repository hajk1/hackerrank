package ir.hajk1.hackerrank;

import java.io.IOException;
import java.util.*;

/**
 * The problem file can be found on resources navanChallenge.txt
 */
public class NavanChallenge {

    /*
     * Complete the 'degreeOfArray' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int degreeOfArray(List<Integer> arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Deque<Integer>> dequeMap = new HashMap<>();
        int j = 0;
        for (Integer i : arr) {
            map.computeIfPresent(i, (k, v) -> v + 1);
            map.putIfAbsent(i, 1);
            dequeMap.computeIfAbsent(i, k -> new ArrayDeque<>());
            int finalJ = j;
            dequeMap.computeIfPresent(i, (k, v) -> {
                v.offer(finalJ);
                return v;
            });
            j++;
        }

        List<Integer> keys = new ArrayList<>();
        int max = 0;
        for (Integer i : map.keySet()) {
            System.out.println("i is " + i);

            int temp = map.get(i);
            System.out.println("max is " + temp);
            if (temp > max) {
                max = temp;
                keys = new ArrayList<>();
                keys.add(i);

            } else if (temp == max) {
                keys.add(i);
            }
        }
        System.out.println("keys: " + keys);

        Set<Integer> sizeSet = new TreeSet<>();
        for (Integer i : keys) {
            Deque<Integer> que = dequeMap.get(i);
            int start = que.peekFirst();
            int end = que.peekLast();

            List<Integer> list = arr.subList(start, end + 1);
            System.out.println("sub list: " + list);

            sizeSet.add(list.size());
        }
        return sizeSet.stream().findFirst().get();

    }

}


class Solution {

    public static void main(String[] args) throws IOException {
        int[] arr = new int[] {1, 2, 2, 3, 1};
        int result = NavanChallenge.degreeOfArray(Arrays.stream(arr).boxed().toList());
        System.out.println("result = " + result);

    }
}