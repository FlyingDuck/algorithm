package com.dongshujin.year2018.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private final int cap;
    private LinkedHashMap<Integer, Integer> map;


    public LRUCache(final int capacity) {
        this.cap = capacity;
        this.map = new LinkedHashMap<Integer, Integer>(capacity, 0.75F, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > cap;
            }
        };
    }

    public int get(int key) {
        Integer result = map.get(key);
        if (null == result)
            result = -1;
        return result;
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

}
