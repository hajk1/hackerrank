package ir.hajk1.leetcode;

import java.util.*;

public class AllOne {
    Map<Integer, Set<String>> map = new HashMap<>();
    Map<String, Integer> countMap = new HashMap<>();

    public AllOne() {

    }

    public void inc(String key) {
        countMap.computeIfPresent(key, (k, v) -> v + 1);
        countMap.putIfAbsent(key, 1);
        int len = countMap.get(key);
        if (len > 1) {
            map.get(len - 1).remove(key);
            if (map.get(len - 1).size() == 0)
                map.remove(len - 1);
        }
        map.putIfAbsent(len, new HashSet<>());
        map.get(len).add(key);
    }

    public void dec(String key) {
        int count = countMap.get(key);
        if (count == 1)
            countMap.remove(key);
        else
            countMap.compute(key, (k, v) -> v - 1);
        if (count > 1) {
            map.putIfAbsent(count - 1, new HashSet<>());
            map.get(count - 1).add(key);
        }
        map.get(count).remove(key);
        if (map.get(count).size() == 0)
            map.remove(count);

    }

    public String getMaxKey() {
        if (map.keySet().size() == 0)
            return "";
        Integer len = map.keySet().stream().
                sorted(Comparator.reverseOrder()).findFirst().get();
        return new ArrayList<>(map.get(len)).get(0);
    }

    public String getMinKey() {
        if (map.keySet().size() == 0)
            return "";
        Integer len = map.keySet().stream().
                sorted().findFirst().get();
        return new ArrayList<>(map.get(len)).get(0);
    }
}
