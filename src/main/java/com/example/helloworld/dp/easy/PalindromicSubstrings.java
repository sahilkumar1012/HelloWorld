package com.example.helloworld.dp.easy;

/**
 * leetcode 647. Palindromic Substrings
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
    //using DP
    /*
    satisfying both conditions for Dynamic Programming problem
    1. optimal substructure
    2. overlapping sub-problems
    */
    public int countSubstrings(String s) {
        int n = s.length(),ans=0;

        if(n<1) return 0;
        boolean dp[][] = new boolean[n][n];

        for(int i=0;i<n;++i,++ans)  // base case for single letter string
            dp[i][i]=true;

        for(int i=0;i<n-1;++i){      // base case for two character string
            dp[i][i+1] = (s.charAt(i)==s.charAt(i+1));
            ans+= dp[i][i+1] ? 1:0;
        }

        // all other cases : substring of length 3 to n
        for(int len=3;len<=n;++len){
            for(int i=0,j=i+len-1; j<n; ++i,++j){ //window of length n
                dp[i][j] = dp[i+1][j-1] && (s.charAt(i)==s.charAt(j));
                ans+= (dp[i][j] ? 1 : 0);
            }
        }

        return ans;
    }

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