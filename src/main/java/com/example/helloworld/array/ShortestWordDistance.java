package com.example.helloworld.array;

/**
 * leetcode 243. Shortest Word Distance , linkedin question
 *
 * Given an array of strings wordsDict and two different strings that already exist in the array word1 and word2, return the shortest distance between these two words in the list.
 *
 *
 *
 * Example 1:
 *
 * Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
 * Output: 3
 * Example 2:
 *
 * Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= wordsDict.length <= 3 * 104
 * 1 <= wordsDict[i].length <= 10
 * wordsDict[i] consists of lowercase English letters.
 * word1 and word2 are in wordsDict.
 * word1 != word2
 */
public class ShortestWordDistance {

    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int idx1 = -1, idx2 = -1, min = Integer.MAX_VALUE;

        int i=0;
        for(String word : wordsDict){
            if(word.equals(word1))
                idx1 = i;
            else if(word.equals(word2))
                idx2 = i;
            i++;

            if(idx1 != -1 && idx2 != -1)                // considering all the differences
                min = Math.min(min, Math.abs(idx1-idx2));
        }

        return min;
    }
}