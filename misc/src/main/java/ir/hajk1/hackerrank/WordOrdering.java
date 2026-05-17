package ir.hajk1.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordOrdering {

    public String[] sortByDefinedOrder(String[] arr, String order) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        for (char c : order.toCharArray()) {
            map.put(c, i++);
        }
        Arrays.sort(arr, (o1, o2) -> {
            char[] a1 = o1.toCharArray();
            char[] a2 = o2.toCharArray();
            for (int j = 0; j < a1.length; j++) {
                if (j > a2.length - 1) {
                    return 1;
                }
                Integer index1 = map.get(a1[j]);
                Integer index2 = map.get(a2[j]);
                if (Objects.equals(index1, index2)) {
                    continue;
                }
                return Integer.compare(index1, index2);
            }
            if (a1.length < a2.length) {
                return -1;
            }
            return 0;
        });
        return arr;
    }
}
