package com.example.helloworld.string.KMP;

import java.util.Arrays;

/**
 * @author sahil
 *
 * KMP Explanation from Code Harmony : https://youtu.be/I7XZNmoBUKc
 *
 * Practice problem :
 * leetcode 28. Find the Index of the First Occurrence in a String
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 *
 *
 * 1910. Remove All Occurrences of a Substring
 * https://leetcode.com/problems/remove-all-occurrences-of-a-substring/
 * ( keep applying KMP until we do not find any occurance in the text )
 *
 *
 * 459. Repeated Substring Pattern
 * https://leetcode.com/problems/repeated-substring-pattern/
 * ( based on LPS array, how we can find the answer with lps array )
 *
 *
 * Do pattern matching using KMP algorithm
 *
 * Runtime complexity - O(m + n) where m is length of text and n is length of pattern
 * Space complexity - O(n)
 */
public class KMP {

    /**
     * Compute LPS array to maintain the size of the suffix which is the same as the prefix.
     * Time Complexity: O(m), where m is the length of the pattern.
     */
    public int[] prepareLPS(char[] pattern) {
        int[] lps = new int[pattern.length];
        int len = 0;
        for (int i = 1; i < pattern.length; ) {
            if (pattern[i] == pattern[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    /**
     * KMP algorithm to find the first occurrence index of the pattern in the text.
     * Returns the index of the first occurrence, or -1 if not found.
     */
    public int KMP(char[] text, char[] pattern) {
        int[] lps = prepareLPS(pattern);
        int i = 0; // Pointer for text
        int j = 0; // Pointer for pattern

        while (i < text.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
                if (j == pattern.length) {
                    return i - j; // Found match, return start index
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1; // No match found
    }

    public static void main(String args[]) {
        KMP kmp = new KMP();
        String text = "abcxabcdabcdabcy";
        String pattern = "abcdabcy";
        int index = kmp.KMP(text.toCharArray(), pattern.toCharArray());
        System.out.println("Pattern found at index: " + index); // Expected output: 7

        // Test LPS computation
        int[] lps = kmp.prepareLPS("abcabcabcabc".toCharArray());
        System.out.println("LPS Array: " + java.util.Arrays.toString(lps)); // Expected LPS output
    }
}
