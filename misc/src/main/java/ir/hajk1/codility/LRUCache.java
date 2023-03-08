package ir.hajk1.codility;

import java.util.LinkedHashMap;

public class LRUCache {

    int capacity;
    LinkedHashMap<Integer, Integer> cacheList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheList = new LinkedHashMap(capacity, 1, true);
    }

    public int get(int key) {
        if (cacheList.containsKey(key)) {
            return cacheList.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cacheList.size() == capacity) {
            if (!cacheList.containsKey(key)) {
                cacheList.remove(cacheList.keySet().stream().findFirst().get());//71  ms
            }
            //cacheList.remove(cacheList.keySet().toArray()[0]);            //720 ms
        }
        cacheList.put(key, value);
    }


}






