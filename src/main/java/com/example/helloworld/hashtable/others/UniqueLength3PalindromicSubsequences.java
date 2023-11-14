package com.example.helloworld.hashtable.others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * leetcode 1930. Unique Length-3 Palindromic Subsequences
 *
 * Given a string s, return the number of unique palindromes of length three that are a subsequence of s.
 *
 * Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.
 *
 * A palindrome is a string that reads the same forwards and backwards.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 *
 *
 * Example 1:
 *
 * Input: s = "aabca"
 * Output: 3
 * Explanation: The 3 palindromic subsequences of length 3 are:
 * - "aba" (subsequence of "aabca")
 * - "aaa" (subsequence of "aabca")
 * - "aca" (subsequence of "aabca")
 * Example 2:
 *
 * Input: s = "adc"
 * Output: 0
 * Explanation: There are no palindromic subsequences of length 3 in "adc".
 * Example 3:
 *
 * Input: s = "bbcbaba"
 * Output: 4
 * Explanation: The 4 palindromic subsequences of length 3 are:
 * - "bbb" (subsequence of "bbcbaba")
 * - "bcb" (subsequence of "bbcbaba")
 * - "bab" (subsequence of "bbcbaba")
 * - "aba" (subsequence of "bbcbaba")
 *
 *
 * Constraints:
 *
 * 3 <= s.length <= 105
 * s consists of only lowercase English letters.
 */
public class UniqueLength3PalindromicSubsequences {
    public int countPalindromicSubsequence(String s) {
        // first last.
        Map<Character, Integer> first = new HashMap<>();
        Map<Character, Integer> last = new HashMap<>();
        Set<Character> characters = new HashSet<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            characters.add(ch);

            if(first.containsKey(ch)) continue;
            first.put(ch, i);
        }
        for(int i=s.length()-1; i>=0; i--){
            char ch = s.charAt(i);

            if(last.containsKey(ch)) continue;
            last.put(ch, i);
        }


        int ans = 0;
        for(char ch : characters){
            Set<Character> set = new HashSet<>();
            for(int k=first.get(ch)+1; k<=last.get(ch)-1; k++)
                set.add(s.charAt(k));
            ans += set.size();
        }

        return ans;
    }

}
