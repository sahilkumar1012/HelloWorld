package com.example.helloworld.dp.easy;

/**
 * leetCode 1143. Longest Common Subsequence
 *
 * code harmony solution video :  https://youtu.be/6nYxpSTymA4
 *
 *
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 *
 * Constraints:
 *
 * 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters.
 */
public class LongestCommonSubsequence {
    // Memoization array for the top-down approach
    Integer[][] dp;

    // Approach 1: Top down / Recursion with Memorization
    public int longestCommonSubsequenceTopDown(String text1, String text2) {
        dp = new Integer[1001][1001];
        return sol(text1, text2, 0, 0);
    }

    // Recursive function with memoization to find the longest common subsequence
    private int sol(String s1, String s2, int i, int j) {
        // Base case: if either string is fully processed
        if (i == s1.length() || j == s2.length())
            return 0;

        // Check if result for current indices is already computed
        if (dp[i][j] != null)
            return dp[i][j];

        int res = 0;
        // If characters match, increment the result and move to the next indices
        if (s1.charAt(i) == s2.charAt(j)) {
            res = 1 + sol(s1, s2, i + 1, j + 1);
        } else {
            // If characters don't match, take the maximum from either skipping a character in s1 or s2
            res = Math.max(res, Math.max(
                    sol(s1, s2, i + 1, j),
                    sol(s1, s2, i, j + 1)
            ));
        }

        // Save the result in the dp array for future reference
        return dp[i][j] = res;
    }

    // Approach 2: Bottom-up / Tabulation
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // 2D array to store results of subproblems for the bottom-up approach
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j], dp[i][j - 1]
                    );
                }
            }
        }

        // Result is stored in the bottom-right corner of the dp array
        return dp[m][n];
    }
}
