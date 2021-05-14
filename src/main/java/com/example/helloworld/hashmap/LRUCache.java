package com.example.helloworld.hashmap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU cache built by Sahil.
 */
public class LRUCache {

    /*
    A special constructor is provided to create a linked hash map whose order of iteration is the order in which its entries were last accessed,
    from least-recently accessed to most-recently (access-order). This kind of map is well-suited to building LRU caches

    The removeEldestEntry(Map.Entry) method may be overridden to impose a policy for removing stale mappings automatically when new mappings are added to the map
     */
    LinkedHashMap<Integer,Integer> cache;

    public LRUCache(int capacity) {
        //using this below special constructor for LinkedHashMap ( which also accepts the order access to true, and implement removeEldestEntry function.)
        // orderAccess set to true(maintain the access order not insertion),
        // load factor to 100% as we already know the capacity and there's no need to increase the capacity of this hashmap. Generally it's 75%..
        cache = new LinkedHashMap<>(capacity+1,100.0f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest){
//                System.out.println(eldest);
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        cache.put(key,value);
    }
}
