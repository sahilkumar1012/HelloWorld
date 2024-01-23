package com.example.helloworld.backtracking.easy;

import java.util.List;

/**
 * leetcode 1239. Maximum Length of a Concatenated String with Unique Characters
 *
 * code harmony solution video : https://youtu.be/LD9A7sBIn4A
 *
 * You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.
 *
 * Return the maximum possible length of s.
 *
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All the valid concatenations are:
 * - ""
 * - "un"
 * - "iq"
 * - "ue"
 * - "uniq" ("un" + "iq")
 * - "ique" ("iq" + "ue")
 * Maximum length is 4.
 * Example 2:
 *
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
 * Example 3:
 *
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 * Explanation: The only string in arr has all 26 characters.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] contains only lowercase English letters.
 */
public class MaximumLengthofaConcatenatedStringwithUniqueCharacters {
    // Variable to store the maximum length of the concatenated string
    int ans = 0;

    /**
     * Main function to calculate the maximum length of a concatenated string with unique characters.
     *
     * @param arr List of strings
     * @return Maximum length of the concatenated string
     */
    public int maxLength(List<String> arr) {
        // Initialize the backtracking helper function
        helper(arr, 0, "");
        return ans;
    }

    /**
     * Backtracking helper function to explore all possible combinations of strings to form a concatenated string with unique characters.
     *
     * @param arr List of strings
     * @param idx Current index in the list
     * @param temp Current temporary string being formed
     */
    private void helper(List<String> arr, int idx, String temp){
        // If we have processed all strings in the list
        if(idx == arr.size()){
            // Check if the current temporary string has unique characters
            if(unique(temp)){
                // Update the maximum length if the current temporary string is longer
                ans = Math.max(ans, temp.length());
            }
            return;
        }

        // Explore not including the current string in the temporary string
        helper(arr, idx+1, temp);
        // Explore including the current string in the temporary string
        helper(arr, idx+1, temp + arr.get(idx));
    }

    /**
     * Function to check if a string has unique characters.
     *
     * @param s Input string
     * @return True if the string has unique characters, false otherwise
     */
    private boolean unique(String s){
        // Array to store the count of characters (assuming lowercase English letters)
        int[] hash = new int[26];
        // Iterate through each character in the string
        for(char ch : s.toCharArray()){
            // If the character has already occurred once, return false
            if(hash[ch-'a'] == 1){
                return false;
            }
            // Otherwise, update the count of the character
            hash[ch-'a']++;
        }
        // All characters are unique
        return true;
    }
}
