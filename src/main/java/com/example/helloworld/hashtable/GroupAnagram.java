package com.example.helloworld.hashtable;

import java.util.*;

/**
 * leetcode 49. Group Anagrams
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lower-case English letters.
 */
public class GroupAnagram {

    public static void main(String[] args) {
        System.out.println(new GroupAnagram().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm= new HashMap<>();

        for(String s: strs){
            char[] ch= s.toCharArray();

            Arrays.sort(ch);
            String temp=new String(ch);

            if(!hm.containsKey(temp))
            {
                hm.put(temp,new ArrayList<String>());
            }
            hm.get(temp).add(s);
        }

        return new ArrayList<>(hm.values());
    }
}
