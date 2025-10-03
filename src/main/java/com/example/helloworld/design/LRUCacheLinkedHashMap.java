package com.example.helloworld.design;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * leetcode 146. LRU Cache
 *
 * LRU cache built by Sahil.
 */
public class LRUCacheLinkedHashMap {

    /*
    A special constructor is provided to create a linked hash map whose order of iteration is the order in which its entries were last accessed,
    from least-recently accessed to most-recently (access-order). This kind of map is well-suited to building LRU caches

    The removeEldestEntry(Map.Entry) method may be overridden to impose a policy for removing stale mappings automatically when new mappings are added to the map
     */
    LinkedHashMap<Integer,Integer> cache;

    public LRUCacheLinkedHashMap(int capacity) {
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

/**
 * LRU cache using doubly linked list and hash map
 */
class LRUCacheCustom {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    private void addNode(DLinkedNode node) {
        /**
         * Always add the new node right after head.
         */
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node){
        /**
         * Remove an existing node from the linked list.
         */
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DLinkedNode node){
        /**
         * Move certain node in between to the head.
         */
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        /**
         * Pop the current tail.
         */
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private final Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private final int capacity;
    private DLinkedNode head, tail;

    public LRUCacheCustom(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        // head.prev = null;

        tail = new DLinkedNode();
        // tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;

        // move the accessed node to the head;
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if(node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            ++size;

            if(size > capacity) {
                // pop the tail
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            // update the value.
            node.value = value;
            moveToHead(node);
        }
    }
}