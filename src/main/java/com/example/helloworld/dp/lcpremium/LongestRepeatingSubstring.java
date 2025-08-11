package com.example.helloworld.dp.lcpremium;

/**
 *
 * leetcode 1062. Longest Repeating Subs * leetcode 1062. Longest Repeating Substring , Asked in Google Amazon Meta
 *  *
 *  *
 *  * Given a string s, return the length of the longest repeating substrings. If no repeating substring exists, return 0.
 *  *
 *  *
 *  *
 *  * Example 1:
 *  *
 *  * Input: s = "abcd"
 *  * Output: 0
 *  * Explanation: There is no repeating substring.
 *  *
 *  * Example 2:
 *  *
 *  * Input: s = "abbaba"
 *  * Output: 2
 *  * Explanation: The longest repeating substrings are "ab" and "ba", each of which occurs twice.tring , Asked in Google Amazon Meta
 *
 *
 * Given a string s, return the length of the longest repeating substrings. If no repeating substring exists, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcd"
 * Output: 0
 * Explanation: There is no repeating substring.
 *
 * Example 2:
 *
 * Input: s = "abbaba"
 * Output: 2
 * Explanation: The longest repeating substrings are "ab" and "ba", each of which occurs twice.
 *
 * Example 3:
 *
 * Input: s = "aabcaabdaab"
 * Output: 3
 * Explanation: The longest repeating substring is "aab", which occurs 3 times.
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 2000
 *     s consists of lowercase English letters.
 *
 */
public class LongestRepeatingSubstring {
    public int longestRepeatingSubstring(String s) {
        int n = s.length();
        // DP table where dp[i][j] stores the length of the longest common suffix
        // of substrings s[0...i-1] and s[0...j-1]
        int[][] dp = new int[n+1][n+1];
        int ans = 0; // Variable to keep track of the longest repeating substring length

        // Iterate through the string to fill the DP table
        for(int i=1; i<=n; i++){
            for(int j= i+1; j<=n; j++){ // j starts from i+1 to ensure non-overlapping substrings
                // If characters at i-1 and j-1 match, update dp[i][j]
                if(s.charAt(i-1) == s.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1; // Extend the previous match length
                    ans = Math.max(ans, dp[i][j]); // Update the answer if we found a longer match
                }
            }
        }
        return ans; // Return the length of the longest repeating substring
    }
}
