package com.example.helloworld.string.KMP;

/**
 * leetcode 459. 459. Repeated Substring Pattern
 *
 * Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abab"
 * Output: true
 * Explanation: It is the substring "ab" twice.
 * Example 2:
 *
 * Input: s = "aba"
 * Output: false
 * Example 3:
 *
 * Input: s = "abcabcabcabc"
 * Output: true
 * Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of lowercase English letters.
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int[] lps= new KMP().prepareLPS(s.toCharArray());
        int n=s.length();
        // System.out.println(lps);
        /**
         for a pattern like : abcabcabcabc

         our lps should be like this : [0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
         */
        // Check if a repeated pattern exists
        return lps[n - 1] > 0 && n % (n - lps[n - 1]) == 0;

        // or
        // count number of zeros in the starting = m
        // lps[n-1] % m == 0

    }


    public static void main(String[] args) {
        RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("abacabacabac"));
    }

    /**
     * this is a KMP algorithm, LPS util function to compute the longest prefix suffix array
     * @param pattern
     * @return
     */
    private int[] lps(char[] pattern) {
        int lps[] = new int[pattern.length];
        int index = 0;
        for (int i = 1; i < pattern.length; ) {
            if (pattern[index] == pattern[i]) {
                lps[i] = index + 1;
                index++;
                i++;
            } else {
                if (index != 0) {
                    index = lps[index - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

}
