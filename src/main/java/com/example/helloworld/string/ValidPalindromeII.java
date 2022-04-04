package com.example.helloworld.string;

/**
 * leetcode 680. Valid Palindrome II
 *
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aba"
 * Output: true
 * Example 2:
 *
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 * Example 3:
 *
 * Input: s = "abc"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 */
public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        int l = 0, h = s.length()-1;
        while(l<h){
            if(s.charAt(l)!=s.charAt(h)){
                // remove char at l || char at h
                return isPalindrome(s.substring(l+1,h+1)) || isPalindrome(s.substring(l,h));
            }
            h--;
            l++;
        }
        return true;
    }

    private boolean isPalindrome(String s){
        int l = 0, h = s.length()-1;
        while(l<h){
            if(s.charAt(l)!=s.charAt(h))
                return false;
            h--;
            l++;
        }
        return true;
    }
}
