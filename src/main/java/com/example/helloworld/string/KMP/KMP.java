package com.example.helloworld.string.KMP;

import java.util.Arrays;

/**
 * @author sahil
 *
 * Matching problem :
 * leetcode 28. Find the Index of the First Occurrence in a String
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 *
 *
 * Do pattern matching using KMP algorithm
 *
 * Runtime complexity - O(m + n) where m is length of text and n is length of pattern
 * Space complexity - O(n)
 */
public class KMP {

    /**
     * Naive String Matching Algorithm
     * ( not efficient for long and repetitive patterns , too much redundant matchings )
     * Time - O(m*n)
     */
    public boolean hasSubstring(char[] text, char[] pattern){
        int i=0;        // pointer for text
        int j=0;        // pointer for pattern
        int k = 0;      // start from k this time.
        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
            }else{
                j=0;
                k++;
                i = k;
            }
        }
        return j == pattern.length;
    }

    /**
     * Compute temporary array to maintain size of suffix which is same as prefix
     * Time complexity to prepare LPS is O(m)
     * m is size of pattern
     */
    public int[] prepareLPS(char[] pattern){
        int [] lps = new int[pattern.length];
        int len =0;
        for(int i=1; i < pattern.length;){
            if(pattern[i] == pattern[len]){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len > 0){
                    len = lps[len-1];
                }else{
                    lps[i] =0;
                    i++;
                }
            }
        }
        return lps;
    }

    /**
     * KMP algorithm of pattern matching.
     * (using LPS array)
     */
    public boolean KMP(char []text, char []pattern){

        int[] lps = prepareLPS(pattern);
        int i=0;
        int j=0;
        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
            }else{
                if(j!=0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        return j == pattern.length;
    }

    public static void main(String args[]){

        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        KMP ss = new KMP();
        boolean result = ss.KMP(str.toCharArray(), subString.toCharArray());
        System.out.print(result);

//  create a test to find lps of     abcabcabcabc
//        int [] lps = ss.prepareLPS("abcabcabcabc".toCharArray());
//        System.out.println(Arrays.toString(lps));;

    }
}
