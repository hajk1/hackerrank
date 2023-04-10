package ir.hajk1.codility;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class LRUCache {

    int capacity;
    Queue<Integer> cacheList = new ArrayDeque<>();

    Map<Integer, Integer> cacheMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>(capacity, 1);
    }

    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            cacheList.remove(key);
            cacheList.offer(key);
            return cacheMap.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        if (cacheMap.size() == capacity && !cacheMap.containsKey(key)) {
            Integer tempKey = cacheList.poll();
            cacheMap.remove(tempKey);
            cacheList.remove(tempKey);
        }

        cacheList.remove(key);
        cacheMap.remove(key);
        cacheList.offer(key);
        cacheMap.put(key, value);
    }
}



