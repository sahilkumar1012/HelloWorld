package com.example.helloworld.trie;

import java.util.Arrays;

/**
 * leetcode 2416. Sum of Prefix Scores of Strings
 *
 * You are given an array words of size n consisting of non-empty strings.
 *
 * We define the score of a string word as the number of strings words[i] such that word is a prefix of words[i].
 *
 * For example, if words = ["a", "ab", "abc", "cab"], then the score of "ab" is 2, since "ab" is a prefix of both "ab" and "abc".
 * Return an array answer of size n where answer[i] is the sum of scores of every non-empty prefix of words[i].
 *
 * Note that a string is considered as a prefix of itself.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["abc","ab","bc","b"]
 * Output: [5,4,3,2]
 * Explanation: The answer for each string is the following:
 * - "abc" has 3 prefixes: "a", "ab", and "abc".
 * - There are 2 strings with the prefix "a", 2 strings with the prefix "ab", and 1 string with the prefix "abc".
 * The total is answer[0] = 2 + 2 + 1 = 5.
 * - "ab" has 2 prefixes: "a" and "ab".
 * - There are 2 strings with the prefix "a", and 2 strings with the prefix "ab".
 * The total is answer[1] = 2 + 2 = 4.
 * - "bc" has 2 prefixes: "b" and "bc".
 * - There are 2 strings with the prefix "b", and 1 string with the prefix "bc".
 * The total is answer[2] = 2 + 1 = 3.
 * - "b" has 1 prefix: "b".
 * - There are 2 strings with the prefix "b".
 * The total is answer[3] = 2.
 * Example 2:
 *
 * Input: words = ["abcd"]
 * Output: [4]
 * Explanation:
 * "abcd" has 4 prefixes: "a", "ab", "abc", and "abcd".
 * Each prefix has a score of one, so the total is answer[0] = 1 + 1 + 1 + 1 = 4.
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] consists of lowercase English letters.
 */
public class SumofPrefixScoreofStrings {
}

class PrefixTreeNode {
    static final int ALPHABET_SIZE = 26;  // Constant for the number of lowercase letters
    PrefixTreeNode[] children;
    int count;

    // Constructor to initialize children array and count
    public PrefixTreeNode() {
        children = new PrefixTreeNode[ALPHABET_SIZE];
        count = 0;
    }
}

class PrefixTree {
    private final PrefixTreeNode root;  // Root of the Prefix Tree

    // Constructor to initialize the PrefixTree
    public PrefixTree() {
        root = new PrefixTreeNode();
    }

    // Insert a word into the Prefix Tree and increment the count at each prefix node
    public void insert(String word) {
        PrefixTreeNode current = root;
        for (char ch : word.toCharArray()) {
            int idx = getCharIndex(ch);  // Get index for the current character
            if (current.children[idx] == null) {
                current.children[idx] = new PrefixTreeNode();  // Create new node if needed
            }
            current.children[idx].count++;  // Increment the prefix count at the current node
            current = current.children[idx];  // Move to the next node
        }
    }

    // Calculate the score for a word by summing the counts of all its prefixes
    public int getPrefixScore(String word) {
        PrefixTreeNode current = root;
        int score = 0;
        for (char ch : word.toCharArray()) {
            int idx = getCharIndex(ch);
            current = current.children[idx];  // Move to the next node
            score += current.count;  // Sum the count of the current prefix
        }
        return score;
    }

    // Helper method to get the index of a character relative to 'a'
    private int getCharIndex(char ch) {
        return ch - 'a';
    }
}

class Solution {
    // Method to calculate the sum of prefix scores for each word in the list
    public int[] sumPrefixScores(String[] words) {
        PrefixTree prefixTree = new PrefixTree();

        // Insert all words into the prefix tree
        for (String word : words) {
            prefixTree.insert(word);
        }

        int len = words.length;
        int[] scores = new int[len];

        // Calculate the prefix score for each word
        for (int i = 0; i < len; i++) {
            scores[i] = prefixTree.getPrefixScore(words[i]);
        }

        return scores;
    }
}
