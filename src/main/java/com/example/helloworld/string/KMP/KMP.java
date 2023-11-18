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
     * Slow method of pattern matching
     *
     * O(m*n)
     */
    public boolean hasSubstring(char[] text, char[] pattern){
        int i=0;
        int j=0;
        int k = 0;
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
        if(j == pattern.length){
            return true;
        }
        return false;
    }

    /**
     * Compute temporary array to maintain size of suffix which is same as prefix
     * Time/space complexity is O(size of pattern) O(m+n)
     */
    public int[] computeTemporaryArray(char[] pattern){
        int [] lps = new int[pattern.length];
        int index =0;
        for(int i=1; i < pattern.length;){
            if(pattern[i] == pattern[index]){
                lps[i] = index + 1;
                index++;
                i++;
            }else{
                if(index != 0){
                    index = lps[index-1];
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
     */
    public boolean KMP(char []text, char []pattern){

        int lps[] = computeTemporaryArray(pattern);
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

//        String str = "abcxabcdabcdabcy";
////        String subString = "abcdabcy";
//        String str = "hello";
//        String subString = "ll";
        KMP ss = new KMP();
//        boolean result = ss.KMP(str.toCharArray(), subString.toCharArray());
//        System.out.print(result);

//  create a test to find lps of     abcabcabcabc
        int [] lps = ss.computeTemporaryArray("abcabcabcabc".toCharArray());
        System.out.println(Arrays.toString(lps));;

    }
}
