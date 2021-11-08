package com.example.helloworld.dp.easy;

/**
 * leetcode 5. Longest Palindromic Substring
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 * Example 3:
 *
 * Input: s = "a"
 * Output: "a"
 * Example 4:
 *
 * Input: s = "ac"
 * Output: "a"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 0;
        int left= -1, right = -1;

        for(int g = 0; g < n; g++ ){
            for(int i=0, j=g; j<n; i++, j++){
                if(g == 0){
                    dp[i][j] = true;
                }else {
                    boolean sameLastChar = s.charAt(i) == s.charAt(j);
                    if(g == 1){
                        dp[i][j] = sameLastChar;
                    }else{
                        dp[i][j] = sameLastChar && dp[i+1][j-1];
                    }
                }

                if(dp[i][j] && g+1 > maxLen){
                    left = i;
                    right = j;
                }
            }
        }

        return s.substring(left,right+1);
    }
}
