package ir.hajk1.leetcode;

import java.util.HashMap;
import java.util.Map;

public class topKFrequent {

    public static void main(String[] args) {
        topKFrequent topKFrequent = new topKFrequent();
        int[] result = topKFrequent.topKFrequent(new int[] {4, 1, 1, 1, 2, 2, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5}, 2);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.compute(num, (k2, v) -> (v == null ? 1 : v + 1));
        }

        return map.entrySet().stream().sorted((a, b) -> Integer.compare(b.getValue(), a.getValue())).limit(k).mapToInt(e -> e.getKey()).toArray();
    }

}
