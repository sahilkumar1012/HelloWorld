package com.example.helloworld.string;

/**
 * Leetcode 647. Palindromic Substrings
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
 *
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            count+=oddPalindrome(s,i);
            count+=evenPalindrome(s,i);
        }
        return count;
    }
    private int oddPalindrome(String s,int i){
        int count=0;
        int k=i;
        int j=i;
        while(k>=0 && j<s.length()){
            if(s.charAt(k)==s.charAt(j))
            {
                //System.out.println(s.substring(k,j+1));
                k--;
                j++;

                count++;
            }
            else
                break;
        }
        return count;
    }
    private int evenPalindrome(String s,int i){
        int count=0;
        int k=i-1;
        int j=i;
        while(k>=0 && j<s.length()){
            if(s.charAt(k)==s.charAt(j))
            {
                //System.out.println(s.substring(k,j+1));
                k--;
                j++;
                count++;
            }
            else
                break;
        }
        return count;
    }

    // DP Solution

    public int countSubstringsDP(String s) {
        int n = s.length();
        boolean[][] dp=new boolean[n][n];
        int count=0;
        for(int i=0;i<n;i++){
            dp[i][i]=true;
            count++;
        }
        for(int i=1;i<n;i++)
        {
            if(s.charAt(i)==s.charAt(i-1)){
                dp[i-1][i]=true;
                count++;
            }
        }
        for(int len=3;len<=n;len++){
            int i=0;
            int j=i+len-1;
            while(j<n){
                if(s.charAt(j)==s.charAt(i) && dp[i+1][j-1]){
                    dp[i][j]=true;
                    count++;
                }
                j++;
                i++;
            }

        }


        return count;
    }
}
