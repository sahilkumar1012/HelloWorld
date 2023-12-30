package com.example.helloworld.hashtable.others;

/**
 * leetcode 1897. Redistribute Characters to Make All Strings Equal
 *
 * Code Harmony Video Link : https://youtu.be/spDUCudKSHg
 *
 * You are given an array of strings words (0-indexed).
 *
 * In one operation, pick two distinct indices i and j, where words[i] is a non-empty string, and move any character from words[i] to any position in words[j].
 *
 * Return true if you can make every string in words equal using any number of operations, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["abc","aabc","bc"]
 * Output: true
 * Explanation: Move the first 'a' in words[1] to the front of words[2],
 * to make words[1] = "abc" and words[2] = "abc".
 * All the strings are now equal to "abc", so return true.
 * Example 2:
 *
 * Input: words = ["ab","a"]
 * Output: false
 * Explanation: It is impossible to make all the strings equal using the operation.
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] consists of lowercase English letters.
 */
public class RedistributeCharacterstoMakeAllStringsEqual {
    /**
     * Method to determine if all strings in the given array can be made equal
     * by redistributing characters using the provided operations.
     *
     * @param words Array of strings to check
     * @return True if all strings can be made equal, otherwise false
     */
    public boolean makeEqual(String[] words) {
        // Array to store the count of each character's occurrence
        int[] hash = new int[26];

        int n = words.length; // Number of strings in the array

        // Count the occurrences of each character in all strings
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                hash[ch - 'a']++;
            }
        }

        // Check if the count of each character is divisible by the number of strings
        // If not, it's not possible to make all strings equal
        for (int i = 0; i < 26; i++) {
            if (hash[i] % n != 0) {
                return false;
            }
        }

        // All characters can be equally distributed among strings
        return true;
    }
}
