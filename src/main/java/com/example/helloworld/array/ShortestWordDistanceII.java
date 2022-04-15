package com.example.helloworld.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 244. Shortest Word Distance II
 *
 * Design a data structure that will be initialized with a string array, and then it should answer queries of the shortest distance between two different strings from the array.
 *
 * Implement the WordDistance class:
 *
 * WordDistance(String[] wordsDict) initializes the object with the strings array wordsDict.
 * int shortest(String word1, String word2) returns the shortest distance between word1 and word2 in the array wordsDict.
 *
 *
 * Example 1:
 *
 * Input
 * ["WordDistance", "shortest", "shortest"]
 * [[["practice", "makes", "perfect", "coding", "makes"]], ["coding", "practice"], ["makes", "coding"]]
 * Output
 * [null, 3, 1]
 *
 * Explanation
 * WordDistance wordDistance = new WordDistance(["practice", "makes", "perfect", "coding", "makes"]);
 * wordDistance.shortest("coding", "practice"); // return 3
 * wordDistance.shortest("makes", "coding");    // return 1
 *
 *
 * Constraints:
 *
 * 1 <= wordsDict.length <= 3 * 104
 * 1 <= wordsDict[i].length <= 10
 * wordsDict[i] consists of lowercase English letters.
 * word1 and word2 are in wordsDict.
 * word1 != word2
 * At most 5000 calls will be made to shortest.
 */
public class ShortestWordDistanceII {
    public static void main(String[] args) {
        System.out.println(" Array, Hashtable, design, two pointers, String | problem, asked in LinkedIn");
    }
}

class WordDistance {
    String[] wordsDict;
    Map<String, List<Integer>> freq;

    public WordDistance(String[] wordsDict) {
        this.wordsDict = wordsDict;
        this.freq = new HashMap<>();

        int i=0;
        for(String word : wordsDict){
            if(!freq.containsKey(word)){
                freq.put(word, new ArrayList<>());
            }
            freq.get(word).add(i++);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> first = freq.get(word1);
        List<Integer> second = freq.get(word2);

        int min = 100000;
        // below approach can be improved further, as indices will be in sorted order
        // for(int i=0; i<first.size(); i++){
        //     for(int j=0; j<second.size(); j++){
        //         min = Math.min(min, Math.abs(first.get(i) - second.get(j)));
        //     }
        // }

        // using two pointer approach, as both indices list will be sorted
        int i=0,j=0;
        while( i < first.size() && j < second.size()){
            min = Math.min(min, Math.abs(first.get(i) - second.get(j)));

            if(first.get(i) < second.get(j)){
                i++;
            }else
                j++;
        }
        return min;
    }

}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */