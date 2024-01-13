package com.example.helloworld.hashtable;

/**
 * leetcode 1347. Minimum Number of Steps to Make Two Strings Anagram
 *
 * code harmony solution video : https://youtu.be/u6DBdkAQqyI
 *
 * You are given two strings of the same length s and t. In one step you can choose any character of t and replace it with another character.
 *
 * Return the minimum number of steps to make t an anagram of s.
 *
 * An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "bab", t = "aba"
 * Output: 1
 * Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
 * Example 2:
 *
 * Input: s = "leetcode", t = "practice"
 * Output: 5
 * Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
 * Example 3:
 *
 * Input: s = "anagram", t = "mangaar"
 * Output: 0
 * Explanation: "anagram" and "mangaar" are anagrams.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 104
 * s.length == t.length
 * s and t consist of lowercase English letters only.
 */
public class MinimumNumberofStepstoMakeTwoStringsAnagram {

    /**
     * Method to determine the minimum number of steps to make strings s and t anagrams.
     *
     * @param s String s
     * @param t String t
     * @return Minimum number of steps
     */
    public int minSteps(String s, String t) {
        // Create an array to store the frequency of characters in string s
        int[] freq = new int[26];

        // Calculate the frequency of each character in string s
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int ans = 0; // Initialize the answer to 0

        // Traverse through each character in string t
        for (char ch : t.toCharArray()) {
            // If the character is present in string s, decrement its frequency
            if (freq[ch - 'a'] > 0) {
                freq[ch - 'a']--;
            } else {
                // If the character is not present in string s, increment the answer
                ans++;
            }
        }

        // Return the minimum number of steps required
        return ans;
    }
}