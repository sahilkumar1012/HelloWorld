package com.example.helloworld.dp;

/**
 * leetcode 72. Edit Distance   , asked in Microsoft coding interview
 *
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 *
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 *
 * Constraints:
 *
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 */
public class EditDistance {

    /*
    top down DP,
    took reference from tushar roy's video.
    link : https://youtu.be/We3YDTzNXEk
    */
    public int minDistance(String word1, String word2) {
        final int m = word1.length(), n=word2.length();
        int dp[][] = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0){
                    dp[0][j] = j;
                }else if(j==0){
                    dp[i][0] = i;
                }else{
                    if(word1.charAt(i-1)==word2.charAt(j-1)){           // no further change is required at this state
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        dp[i][j] = 1+ Math.min(dp[i-1][j-1],
                                Math.min(dp[i-1][j],dp[i][j-1]) );
                    }
                }
            }
        }

        return dp[m][n];
    }
}
