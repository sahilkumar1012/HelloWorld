package com.example.helloworld.dp;

import java.util.Arrays;

/**
 * LeetCode 91. Decode Ways
 * https://leetcode.com/problems/decode-ways/
 * Solution Video, Code Harmony [Recursion with Memorization]: https://www.youtube.com/watch?v=np2FZDZQwn4
 *
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 *
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
 *
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 *
 * Given a string s containing only digits, return the number of ways to decode it.
 *
 * The test cases are generated so that the answer fits in a 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "12"
 * Output: 2
 * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: s = "226"
 * Output: 3
 * Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * Example 3:
 *
 * Input: s = "06"
 * Output: 0
 * Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 100
 * s contains only digits and may contain leading zero(s).
 */
public class DecodeWays {

    int[] dp;  // Dynamic programming array to store solutions

    /**
     * Recursive solution to count the number of decodings.
     * @param s The input string containing digits.
     * @return The number of ways to decode the string.
     */
    public int numDecodingsRecursive(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);  // Initialize dp array with -1

        return solve(s, 0);
    }

    /**
     * Helper recursive function to solve the decoding problem.
     * @param s The input string.
     * @param i The current index in the string.
     * @return Number of ways to decode from index i to end of string.
     */
    private int solve(String s, int i) {
        if (i == s.length()) return 1;  // Base case: If reached end of string, return 1

        if (dp[i] != -1) return dp[i];  // If solution is already computed, return it

        int ans = 0;
        int firstDigit = s.charAt(i) - '0';

        // Single digit decode
        if (firstDigit >= 1 && firstDigit <= 9)
            ans += solve(s, i + 1);

        // Double digit decode
        if (i + 1 < s.length()) {
            int second = Integer.valueOf(s.substring(i, i + 2));
            if (second >= 10 && second <= 26) {
                ans += solve(s, i + 2);
            }
        }

        return dp[i] = ans;  // Store and return the result
    }

    /**
     * Dynamic programming solution to count the number of decodings.
     * @param s The input string containing digits.
     * @return The number of ways to decode the string.
     */
    public int numDecodings(String s) {
        dp = new int[s.length() + 1];  // DP array of size (length + 1) for bottom-up approach
        dp[0] = 1;  // Base case for empty string
        dp[1] = s.charAt(0) == '0' ? 0 : 1;  // Base case for first character

        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];  // If single digit is valid, take its count
            }
            int two = Integer.valueOf(s.substring(i - 2, i));  // Check for two-digit validity
            if (two >= 10 && two <= 26) {
                dp[i] += dp[i - 2];  // If two digits form a valid number, add its count
            }
        }

        return dp[s.length()];  // Return the total count for the whole string
    }
}
