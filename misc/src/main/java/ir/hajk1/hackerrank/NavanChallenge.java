package ir.hajk1.hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class NavanChallenge {

    /*
     * Complete the 'degreeOfArray' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int degreeOfArray(List<Integer> arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
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
            List<Integer> list = arr.subList(arr.indexOf(i), arr.lastIndexOf(i) + 1);
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