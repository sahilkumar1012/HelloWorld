package com.example.helloworld.dp.hard;

/**
 * leetcode 1092. Shortest Common Supersequence , Asked in Google , Amazon, Meta, Microsoft
 *
 * code harmony video explanation: https://youtu.be/dTV_IanBtXw
 *
 * my leetcode solution : https://leetcode.com/problems/shortest-common-supersequence/solutions/6477202/easy-to-understand-100-faster-lcs-dp-det-2f0z
 *
 * Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.
 *
 * A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.
 *
 *
 *
 * Example 1:
 *
 * Input: str1 = "abac", str2 = "cab"
 * Output: "cabac"
 * Explanation:
 * str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
 * str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
 * The answer provided is the shortest such string that satisfies these properties.
 * Example 2:
 *
 * Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
 * Output: "aaaaaaaa"
 *
 *
 * Constraints:
 *
 * 1 <= str1.length, str2.length <= 1000
 * str1 and str2 consist of lowercase English letters.
 *
 *
 */
public class ShortestCommonSupersequence {
    public static String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Step 1: Fill LCS DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Step 2: Extract LCS from dp table
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcs.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        lcs.reverse();  // LCS is built in reverse order, so we need to reverse it.

        // Step 3: Build SCS using LCS
        StringBuilder scs = new StringBuilder();
        i = 0;
        j = 0;
        for (char c : lcs.toString().toCharArray()) {
            while (str1.charAt(i) != c) scs.append(str1.charAt(i++)); // Add non-LCS chars from str1
            while (str2.charAt(j) != c) scs.append(str2.charAt(j++)); // Add non-LCS chars from str2
            scs.append(c); // Add LCS char
            i++; j++; // Move past this LCS character
        }

        // Append remaining characters of str1 and str2
        scs.append(str1.substring(i)).append(str2.substring(j));

        return scs.toString();
    }

}
