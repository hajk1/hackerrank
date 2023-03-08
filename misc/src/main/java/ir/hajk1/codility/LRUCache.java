package ir.hajk1.codility;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCache {

    int capacity;
    Queue<Integer> cacheList = new LinkedList();

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
        if (cacheMap.containsKey(key)) {
            cacheList.remove(key);
            cacheMap.remove(key);
        } else {
            if (cacheMap.size() == capacity) {
                Integer tempKey = cacheList.poll();
                cacheMap.remove(tempKey);
                cacheList.remove(tempKey);
            }
        }
        cacheList.offer(key);
        cacheMap.put(key, value);
    }
}



