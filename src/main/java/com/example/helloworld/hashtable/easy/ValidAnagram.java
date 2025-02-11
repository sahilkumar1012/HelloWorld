package com.example.helloworld.hashtable.easy;

import java.util.Arrays;

/**
 * leetcode 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 *
 * Code harmony video solution : https://youtu.be/h1hzMgrsYNA
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 *
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        // check string len .
        if(s.length() != t.length()) return false;
        // capture freq

        int[] sf = new int[26];
        int[] tf = new int[26];

        for(int i=0; i<s.length(); i++){
            sf[s.charAt(i)-'a']++;
            tf[t.charAt(i)-'a']++;
        }

        return Arrays.equals(sf,tf);
    }
}
