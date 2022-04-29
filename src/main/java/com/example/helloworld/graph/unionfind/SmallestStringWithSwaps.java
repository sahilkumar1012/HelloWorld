package com.example.helloworld.graph.unionfind;

import java.util.*;

/**
 * leetcode 1202. Smallest String With Swaps
 *
 * You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.
 *
 * You can swap the characters at any pair of indices in the given pairs any number of times.
 *
 * Return the lexicographically smallest string that s can be changed to after using the swaps.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "dcab", pairs = [[0,3],[1,2]]
 * Output: "bacd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[1] and s[2], s = "bacd"
 * Example 2:
 *
 * Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * Output: "abcd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[0] and s[2], s = "acbd"
 * Swap s[1] and s[2], s = "abcd"
 * Example 3:
 *
 * Input: s = "cba", pairs = [[0,1],[1,2]]
 * Output: "abc"
 * Explaination:
 * Swap s[0] and s[1], s = "bca"
 * Swap s[1] and s[2], s = "bac"
 * Swap s[0] and s[1], s = "abc"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] < s.length
 * s only contains lower case English letters.
 *
 */
public class SmallestStringWithSwaps {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] str = s.toCharArray();

        // [ parentid(index in string), all characters mapped to that parent ]
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();

        UnionFind uf = new UnionFind(str.length);
        for(List<Integer> pair : pairs){
            uf.union(pair.get(0), pair.get(1));
        }

        for(int i=0; i<str.length; i++){
            int parent = uf.find(i);
            PriorityQueue<Character> pq = map.getOrDefault(parent, new PriorityQueue<>());
            pq.offer(str[i]);
            map.putIfAbsent(parent, pq);
        }


        for(int i=0; i<str.length; i++){
            int parent = uf.find(i);
            str[i] = map.get(parent).poll();
        }

        return new String(str);
    }

    /**
     * Standard UnionFind data structure template, use it in your program | union find data structure
     */
    class UnionFind {
        int[] parent;
        public UnionFind(int n) {
            parent = new int[n];
            Arrays.fill(parent, -1);
        }
        public int find(int x) {
            if (parent[x] == -1) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }
        public void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a != b) {
                parent[a] = b;
            }
        }
    }

}