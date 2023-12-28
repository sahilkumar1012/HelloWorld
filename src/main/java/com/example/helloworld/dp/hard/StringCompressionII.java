package com.example.helloworld.dp.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * leetcode 1531. String Compression II
 * https://leetcode.com/problems/string-compression-ii/
 * Code Harmony Video Solution : https://youtu.be/S1IdB36gkJw
 *
 * Run-length encoding is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "aabccc" we replace "aa" by "a2" and replace "ccc" by "c3". Thus the compressed string becomes "a2bc3".
 *
 * Notice that in this problem, we are not adding '1' after single characters.
 *
 * Given a string s and an integer k. You need to delete at most k characters from s such that the run-length encoded version of s has minimum length.
 *
 * Find the minimum length of the run-length encoded version of s after deleting at most k characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aaabcccd", k = 2
 * Output: 4
 * Explanation: Compressing s without deleting anything will give us "a3bc3d" of length 6. Deleting any of the characters 'a' or 'c' would at most decrease the length of the compressed string to 5, for instance delete 2 'a' then we will have s = "abcccd" which compressed is abc3d. Therefore, the optimal way is to delete 'b' and 'd', then the compressed version of s will be "a3c3" of length 4.
 * Example 2:
 *
 * Input: s = "aabbaa", k = 2
 * Output: 2
 * Explanation: If we delete both 'b' characters, the resulting compressed string would be "a4" of length 2.
 * Example 3:
 *
 * Input: s = "aaaaaaaaaaa", k = 0
 * Output: 3
 * Explanation: Since k is zero, we cannot delete anything. The compressed string is "a11" of length 3.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 100
 * 0 <= k <= s.length
 * s contains only lowercase English letters.
 */
public class StringCompressionII {

    // Memoization map to store computed results for specific states.
    private Map<Integer, Integer> memo = new HashMap<>();

    // A set to store the lengths where an additional character is needed after compression.
    Set<Integer> add = Set.of(1, 9, 99);

    /**
     * Method to calculate the minimum length of the compressed string after deleting at most k characters.
     *
     * @param s The input string.
     * @param k The maximum number of characters that can be deleted.
     * @return The minimum length of the compressed string.
     */
    public int getLengthOfOptimalCompression(String s, int k) {
        // Call the recursive function with initial parameters.
        return sol(s, 0, '#', 1, k);
    }

    /**
     * Recursive helper function to compute the minimum length of the compressed string.
     *
     * @param s   The input string.
     * @param idx Current index in the string.
     * @param lc  Last character considered in the previous step.
     * @param lcc Length of the last character sequence considered.
     * @param k   Remaining deletions allowed.
     * @return Minimum length of compressed string.
     */
    private int sol(String s, int idx, char lc, int lcc, int k) {
        // If more than k deletions are needed, return a very large value.
        if (k < 0)
            return Integer.MAX_VALUE / 2;

        // If we've reached the end of the string, return 0.
        if (idx == s.length())
            return 0;

        // Create a unique key for the current state to memoize results.
        int key = idx * 101 * 27 * 101 + (lc - 'a') * 101 * 101 + lcc * 101 + k;

        // If result for current state is already computed, return it.
        if (memo.containsKey(key))
            return memo.get(key);

        int keep, del;

        // Recur by deleting the current character.
        del = sol(s, idx + 1, lc, lcc, k - 1);

        char cc = s.charAt(idx);

        // Recur by keeping the current character and possibly compressing it.
        if (cc == lc) {
            keep = sol(s, idx + 1, lc, lcc + 1, k) + (add.contains(lcc) ? 1 : 0);
        } else {
            keep = sol(s, idx + 1, cc, 1, k) + 1;
        }

        // Choose the minimum of the two results.
        int res = Math.min(del, keep);

        // Store the result in the memoization map.
        memo.put(key, res);

        return res;
    }

    public static void main(String[] args) {
        StringCompressionII solution = new StringCompressionII();

        // Test case 1
        String s1 = "aaabcccd";
        int k1 = 2;
        System.out.println("Output for " + s1 + ", k = " + k1 + ": " + solution.getLengthOfOptimalCompression(s1, k1));  // Expected output: 4

        // Test case 2
        String s2 = "aabbaa";
        int k2 = 2;
        System.out.println("Output for " + s2 + ", k = " + k2 + ": " + solution.getLengthOfOptimalCompression(s2, k2));  // Expected output: 2

        // Test case 3
        String s3 = "aaaaaaaaaaa";
        int k3 = 0;
        System.out.println("Output for " + s3 + ", k = " + k3 + ": " + solution.getLengthOfOptimalCompression(s3, k3));  // Expected output: 3

        // You can add more test cases as needed
    }
}
