package com.example.helloworld.dp.arraydp;

/**
 * leetcode 647. Palindromic Substrings
 *
 * Code harmony solution video : https://youtu.be/i6yagZ6TFJ8
 *
 *
 * Given a string s, return the number of palindromic substrings in it.
 *
 * A string is a palindrome when it reads the same backward as forward.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2:
 *
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 */
public class PalindromicSubstrings {

    /**
     * Method to count palindromic substrings in a given string.
     *
     * @param s The input string.
     * @return The number of palindromic substrings in the input string.
     */
    public int countSubstrings(String s) {
        // Length of the input string
        int n = s.length();

        // Initialize answer variable to the length of the string
        // Every single character is a palindrome by itself
        int ans = n;

        // Dynamic programming matrix to store whether substrings are palindromes or not
        boolean[][] dp = new boolean[n][n];

        // 1-letter substrings are always palindromes
        for (int i = 0; i < n; i++)
            dp[i][i] = true;

        // Check for 2-letter palindromes
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true; // Mark as palindrome
                ans++; // Increase answer count
            }
        }

        // Check for palindromes of length greater than 2
        for (int len = 3; len <= n; ++len) {
            for (int i = 0, j = i + len - 1; j < n; ++i, ++j) {
                // Check if substring from i to j is a palindrome
                // It's a palindrome if inner substring is a palindrome and characters at i and j match
                dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                ans += dp[i][j] ? 1 : 0; // If it's a palindrome, increase the answer count
            }
        }

        return ans;
    }


}
