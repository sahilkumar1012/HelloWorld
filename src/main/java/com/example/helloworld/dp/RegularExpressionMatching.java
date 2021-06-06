package com.example.helloworld.dp;

/**
 * leetcode 10. Regular Expression Matching
 *
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.​​​​
 * '*' Matches zero or more of the preceding element.
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
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 *
 * Input: s = "aab", p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 * Example 5:
 *
 * Input: s = "mississippi", p = "mis*is*p*."
 * Output: false
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 20
 * 0 <= p.length <= 30
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '.', and '*'.
 * It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];

        dp[0][0] = true;

        // first column is false as default.

        // for first row
        for(int i=2; i <= n; ++i){
            dp[0][i] = p.charAt(i-1)=='*' && dp[0][i-2]==true ;
        }

        // for rest of the grid.
        for(int i=1; i<=m; ++i){
            for(int j=1; j<=n; ++j){
                char pattChar = p.charAt(j-1);

                if(pattChar == '*'){ // saang karege
                    // case: mis to match with mis*
                    if( dp[i][j-2] == true ){           // mis to match with mi pattern (0 occurance)
                        dp[i][j] = true;
                    }else if( s.charAt(i-1)==p.charAt(j-1-1) || p.charAt(j-1-1)=='.'){  // mis vs miss*
                        dp[i][j] = dp[i-1][j];
                    }

                }else{
                    if(pattChar == '.' || pattChar == s.charAt(i-1))
                        dp[i][j] = dp[i-1][j-1];
                    // else mai false to already set hi h.
                }
            }
        }

        return dp[m][n];
    }
}
