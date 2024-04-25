package com.example.helloworld.dp;

import java.util.Arrays;

/**
 * leetcode 2370 Longest Ideal Subsequence
 *
 * You are given a string s consisting of lowercase letters and an integer k. We call a string t ideal if the following conditions are satisfied:
 *
 * t is a subsequence of the string s.
 * The absolute difference in the alphabet order of every two adjacent letters in t is less than or equal to k.
 * Return the length of the longest ideal string.
 *
 * A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.
 *
 * Note that the alphabet order is not cyclic. For example, the absolute difference in the alphabet order of 'a' and 'z' is 25, not 1.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "acfgbd", k = 2
 * Output: 4
 * Explanation: The longest ideal string is "acbd". The length of this string is 4, so 4 is returned.
 * Note that "acfgbd" is not ideal because 'c' and 'f' have a difference of 3 in alphabet order.
 * Example 2:
 *
 * Input: s = "abcd", k = 3
 * Output: 4
 * Explanation: The longest ideal string is "abcd". The length of this string is 4, so 4 is returned.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * 0 <= k <= 25
 * s consists of lowercase English letters.
 */

import java.util.Arrays;

public class LongestIdealSubsequence {
    int k; // Maximum allowable difference in alphabet order
    String s; // Input string
    int[][] dp; // Memoization array to store intermediate results
    int n; // Length of input string

    public int longestIdealString(String s, int k) {
        this.s = s;
        this.k = k;
        n = s.length();
        dp = new int[n][26]; // Memoization array initialized with -1
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Start the recursion with initial index 0 and '$' as previous character
        return sol(0, '$');
    }

    // Recursive function to find the length of the longest ideal string
    private int sol(int idx, char prev){
        // Base case: If we have processed the entire string, return 0
        if(idx == s.length()) return 0;

        // If we have already computed the result for this index and previous character, return it
        if(prev != '$' && dp[idx][prev-'a'] != -1) return dp[idx][prev-'a'];

        // Processing starts now.

        // Calculate the absolute difference in alphabet order between the current character and the previous character
        int delta = k+1;
        char cc = s.charAt(idx);

        if(prev > s.charAt(idx)){
            delta = prev - cc;
        } else {
            delta = cc - prev;
        }

        // Initialize variables to store the lengths of ideal strings including and excluding the current character
        int in = Integer.MIN_VALUE;
        int ex;

        // If the absolute difference is less than or equal to k or if it's the starting character ('$')
        // we can include the current character in the ideal string
        if(delta <= k || prev == '$'){
            // Recur for the next index with the current character included
            in = sol(idx+1, s.charAt(idx)) + 1;
        }

        // Recur for the next index with the current character excluded
        ex = sol(idx+1, prev);

        // If it's the starting character ('$'), return the maximum of in and ex
        if(prev == '$') return Math.max(in, ex);

        // Store the maximum of in and ex in the memoization array for this index and previous character
        return dp[idx][prev-'a'] = Math.max(in, ex);
    }
}