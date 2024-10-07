package com.example.helloworld.graph.unionfind;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 737. Sentence Similarity II
 *
 * We can represent a sentence as an array of words, for example, the sentence "I am happy with leetcode" can be represented as arr = ["I","am",happy","with","leetcode"].
 *
 * Given two sentences sentence1 and sentence2 each represented as a string array and given an array of string pairs similarPairs where similarPairs[i] = [xi, yi] indicates that the two words xi and yi are similar.
 *
 * Return true if sentence1 and sentence2 are similar, or false if they are not similar.
 *
 * Two sentences are similar if:
 *
 * They have the same length (i.e., the same number of words)
 * sentence1[i] and sentence2[i] are similar.
 * Notice that a word is always similar to itself, also notice that the similarity relation is transitive. For example, if the words a and b are similar, and the words b and c are similar, then a and c are similar.
 *
 *
 *
 * Example 1:
 *
 * Input: sentence1 = ["great","acting","skills"], sentence2 = ["fine","drama","talent"], similarPairs = [["great","good"],["fine","good"],["drama","acting"],["skills","talent"]]
 * Output: true
 * Explanation: The two sentences have the same length and each word i of sentence1 is also similar to the corresponding word in sentence2.
 * Example 2:
 *
 * Input: sentence1 = ["I","love","leetcode"], sentence2 = ["I","love","onepiece"], similarPairs = [["manga","onepiece"],["platform","anime"],["leetcode","platform"],["anime","manga"]]
 * Output: true
 * Explanation: "leetcode" --> "platform" --> "anime" --> "manga" --> "onepiece".
 * Since "leetcode is similar to "onepiece" and the first two words are the same, the two sentences are similar.
 * Example 3:
 *
 * Input: sentence1 = ["I","love","leetcode"], sentence2 = ["I","love","onepiece"], similarPairs = [["manga","hunterXhunter"],["platform","anime"],["leetcode","platform"],["anime","manga"]]
 * Output: false
 * Explanation: "leetcode" is not similar to "onepiece".
 *
 *
 * Constraints:
 *
 * 1 <= sentence1.length, sentence2.length <= 1000
 * 1 <= sentence1[i].length, sentence2[i].length <= 20
 * sentence1[i] and sentence2[i] consist of lower-case and upper-case English letters.
 * 0 <= similarPairs.length <= 2000
 * similarPairs[i].length == 2
 * 1 <= xi.length, yi.length <= 20
 * xi and yi consist of English letters.
 */

/**
 * This class solves Leetcode problem 737: Sentence Similarity II.
 *
 * Problem Overview:
 * - Two sentences are represented as arrays of words, and the goal is to check if the two sentences are similar.
 * - Given an array of similar word pairs, two sentences are considered similar if:
 *   1. They have the same length.
 *   2. Corresponding words in both sentences are either the same or can be connected via a transitive relationship of similarity.
 * - Similarity is transitive, meaning if word A is similar to word B, and word B is similar to word C, then A is also similar to C.
 *
 * Approach:
 * - We use the Union-Find (Disjoint Set Union) data structure to model the transitive nature of word similarity.
 * - Each word pair indicates that two words belong to the same component.
 * - If corresponding words in both sentences belong to the same component, they are similar.
 */

public class SentenceSimilarityII {
    /**
     * This method checks if two sentences are similar using the union-find approach.
     *
     * @param sentence1 - The first sentence represented as an array of words.
     * @param sentence2 - The second sentence represented as an array of words.
     * @param similarPairs - List of pairs of words that are considered similar.
     * @return true if the sentences are similar, otherwise false.
     */
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        // If the two sentences do not have the same number of words, return false.
        if (sentence1.length != sentence2.length) return false;

        // Map to assign a unique integer ID to each word in the similarPairs list.
        Map<String, Integer> map = new HashMap<>();
        int counter = 0;

        // Assign unique IDs to words and populate the map.
        for (List<String> entry : similarPairs) {
            String key = entry.get(0);
            String value = entry.get(1);

            // If a word is not already mapped, assign a unique ID.
            if (!map.containsKey(key)) {
                map.put(key, counter++);
            }
            if (!map.containsKey(value)) {
                map.put(value, counter++);
            }
        }

        // Initialize Union-Find structure with the number of unique words.
        UnionFind uf = new UnionFind(counter);

        // Union all the word pairs in similarPairs by their corresponding IDs.
        for (List<String> entry : similarPairs) {
            int a = map.get(entry.get(0));
            int b = map.get(entry.get(1));
            uf.union(a, b);
        }

        // Iterate through both sentences and compare each pair of words.
        for (int i = 0; i < sentence1.length; i++) {
            // If the words at index i are identical, continue to the next word.
            if (sentence1[i].equals(sentence2[i])) continue;

            // If either word is not found in the map, the sentences are not similar.
            if (!map.containsKey(sentence1[i]) || !map.containsKey(sentence2[i]))
                return false;

            // Find the components (roots) of the two words and check if they are in the same component.
            int a = map.get(sentence1[i]);
            int b = map.get(sentence2[i]);
            if (uf.find(a) != uf.find(b))
                return false;
        }
        return true;  // If all checks passed, the sentences are similar.
    }

    /**
     * This is the Union-Find (Disjoint Set) data structure used to manage the word similarity components.
     */
    static class UnionFind {
        int[] parent;  // Array representing the parent of each node (word).

        /**
         * Constructor to initialize the UnionFind structure for n elements.
         *
         * @param n - The number of unique words.
         */
        public UnionFind(int n) {
            parent = new int[n];  // Initialize parent array with -1 (indicating each node is its own parent initially).
            Arrays.fill(parent, -1);
        }

        /**
         * Find method with path compression.
         *
         * @param x - The element whose root is to be found.
         * @return The root of element x.
         */
        public int find(int x) {
            if (parent[x] == -1) {
                return x;  // If parent[x] == -1, then x is its own root.
            }
            return parent[x] = find(parent[x]);  // Path compression: make the root the direct parent of x.
        }

        /**
         * Union method to connect two elements a and b.
         *
         * @param a - The first element.
         * @param b - The second element.
         */
        public void union(int a, int b) {
            a = find(a);  // Find root of a.
            b = find(b);  // Find root of b.
            if (a != b) {
                parent[a] = b;  // Union by setting the root of a as b.
            }
        }
    }

}
