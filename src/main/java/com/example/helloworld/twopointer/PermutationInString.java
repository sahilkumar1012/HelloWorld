package com.example.helloworld.twopointer;

/**
 * leetcode 567. Permutation in String
 *
 * Given two strings s1 and s2, return true if s2 contains the permutation of s1.
 *
 * In other words, one of s1's permutations is the substring of s2.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 *
 */
public class PermutationInString {

    public final char a = 'a';

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;

        int[] fre1 = new int[26];
        int[] fre2 = new int[26];

        for(char ch : s1.toCharArray())
            fre1[ch - a]++;

        int len = s1.length();

        for(int i=0; i<len; ++i)
            fre2[s2.charAt(i)-a]++;

        if(sameFreq(fre1,fre2))
            return true;

        for(int i=len; i < s2.length(); ++i){
            fre2[s2.charAt(i)-a]++;
            fre2[s2.charAt(i-len)-a]--;

            if(sameFreq(fre1,fre2))
                return true;
        }


        return false;
    }

    private boolean sameFreq(int[] a, int[] b){
        for(int i=0; i<26; ++i){
            if(a[i] != b[i])
                return false;
        }
        return true;
    }
}
