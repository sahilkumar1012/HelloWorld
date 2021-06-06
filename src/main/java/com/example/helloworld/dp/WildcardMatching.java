package com.example.helloworld.dp;

/**
 * leetcode 44. Wildcard Matching
 *
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input: s = "aa", p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 *
 * Input: s = "cb", p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * Example 4:
 *
 * Input: s = "adceb", p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 * Example 5:
 *
 * Input: s = "acdcb", p = "a*c?b"
 * Output: false
 *
 *
 * Constraints:
 *
 * 0 <= s.length, p.length <= 2000
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '?' or '*'.
 */
public class WildcardMatching {
    public static void main(String[] args) {
        WildcardMatching o = new WildcardMatching();
        System.out.println(o.isMatch("aa", "*"));
    }
    public boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m+1][n+1];

        dp[0][0] = true;
        // first col is already false , no string match with "" pattern

        for(int i=1; i<=n; i++)        // for first row.
            dp[0][i] = dp[0][i-1]==true && p.charAt(i-1)=='*';

        for(int i=1; i<=m; ++i){            // for rest of the grid.
            for(int j=1; j<=n; ++j){
                char pc = p.charAt(j-1);

                if(pc == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];  // for case *a*, ad -> *a vs a || *a vs ad
                }else if(pc == '?' || pc == s.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }

        return dp[m][n];
    }
}
