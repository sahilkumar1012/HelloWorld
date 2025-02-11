package com.example.helloworld.string.KMP;

/**
 * leetCode 1910. Remove All Occurrences of a Substring , Google Amazon Microsoft Adobe
 *
 * code harmony video explanation : https://youtu.be/cn6mfHJslUs
 *
 * my leetcode solution : https://leetcode.com/problems/remove-all-occurrences-of-a-substring/solutions/6409628/easy-to-understand-kmp-algorithm-detaile-89gx
 *
 *
 * Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:
 *
 * Find the leftmost occurrence of the substring part and remove it from s.
 * Return s after removing all occurrences of part.
 *
 * A substring is a contiguous sequence of characters in a string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "daabcbaabcbc", part = "abc"
 * Output: "dab"
 * Explanation: The following operations are done:
 * - s = "daabcbaabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
 * - s = "dabaabcbc", remove "abc" starting at index 4, so s = "dababc".
 * - s = "dababc", remove "abc" starting at index 3, so s = "dab".
 * Now s has no occurrences of "abc".
 * Example 2:
 *
 * Input: s = "axxxxyyyyb", part = "xy"
 * Output: "ab"
 * Explanation: The following operations are done:
 * - s = "axxxxyyyyb", remove "xy" starting at index 4 so s = "axxxyyyb".
 * - s = "axxxyyyb", remove "xy" starting at index 3 so s = "axxyyb".
 * - s = "axxyyb", remove "xy" starting at index 2 so s = "axyb".
 * - s = "axyb", remove "xy" starting at index 1 so s = "ab".
 * Now s has no occurrences of "xy".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * 1 <= part.length <= 1000
 * s​​​​​​ and part consists of lowercase English letters.
 */
public class RemoveAllOccurrencesofaSubstring {

    public String removeOccurrences(String s, String part) {
        KMP kmp = new KMP(); // Using the updated KMP class

        while (true) {
            int firstIdx = kmp.KMP(s.toCharArray(), part.toCharArray()); // Get index of first occurrence
            if (firstIdx == -1) break; // No more occurrences, stop

            // Remove the found substring
            s = s.substring(0, firstIdx) + s.substring(firstIdx + part.length());
        }

        return s;
    }
}


// Note: uncomment the below code if you don't get KMP class.
//class KMP {
//
//    /**
//     * Compute LPS array to maintain the size of the suffix which is the same as the prefix.
//     * Time Complexity: O(m), where m is the length of the pattern.
//     */
//    public int[] prepareLPS(char[] pattern) {
//        int[] lps = new int[pattern.length];
//        int len = 0;
//        for (int i = 1; i < pattern.length; ) {
//            if (pattern[i] == pattern[len]) {
//                len++;
//                lps[i] = len;
//                i++;
//            } else {
//                if (len > 0) {
//                    len = lps[len - 1];
//                } else {
//                    lps[i] = 0;
//                    i++;
//                }
//            }
//        }
//        return lps;
//    }
//
//    /**
//     * KMP algorithm to find the first occurrence index of the pattern in the text.
//     * Returns the index of the first occurrence, or -1 if not found.
//     */
//    public int KMP(char[] text, char[] pattern) {
//        int[] lps = prepareLPS(pattern);
//        int i = 0; // Pointer for text
//        int j = 0; // Pointer for pattern
//
//        while (i < text.length) {
//            if (text[i] == pattern[j]) {
//                i++;
//                j++;
//                if (j == pattern.length) {
//                    return i - j; // Found match, return start index
//                }
//            } else {
//                if (j != 0) {
//                    j = lps[j - 1];
//                } else {
//                    i++;
//                }
//            }
//        }
//        return -1; // No match found
//    }
//}
//
//
//// string matching algorithm