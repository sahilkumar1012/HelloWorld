package com.example.helloworld.string.easy;

/**
 * leetcode 1790. Check if One String Swap Can Make Strings Equal ,Easy ,  DoorDash, Amazon, Meta
 *
 * Code Harmony Explanation Video : https://youtu.be/nynQBxWrB0U
 *
 * My LeetCode submission : https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/solutions/6378158/easy-to-understand-beginner-friendly-str-7bc0
 *
 *
 * You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.
 *
 * Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "bank", s2 = "kanb"
 * Output: true
 * Explanation: For example, swap the first character with the last character of s2 to make "bank".
 * Example 2:
 *
 * Input: s1 = "attack", s2 = "defend"
 * Output: false
 * Explanation: It is impossible to make them equal with one string swap.
 * Example 3:
 *
 * Input: s1 = "kelb", s2 = "kelb"
 * Output: true
 * Explanation: The two strings are already equal, so no string swap operation is required.
 *
 *
 * Constraints:
 *
 * 1 <= s1.length, s2.length <= 100
 * s1.length == s2.length
 * s1 and s2 consist of only lowercase English letters.
 */
public class CheckifOneStringSwapCanMakeStringsEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();  // Get the length of the strings

        int firstIdxDiff = -1, secondIdxDiff = -1; // Variables to store the indices where characters differ
        int diffCount = 0;  // Counter to track the number of differing characters

        int i = 0, j = 0;
        while (i < n && j < n) {  // Loop through both strings
            if (s1.charAt(i) != s2.charAt(j)) {  // If characters at the current index are different
                if (diffCount > 0) {
                    secondIdxDiff = i;  // Store the second mismatch index
                } else {
                    firstIdxDiff = i;  // Store the first mismatch index
                }

                diffCount++;  // Increment the difference counter

                if (diffCount > 2) return false;  // More than two mismatches mean swapping won't work
            }
            i++; j++;  // Move to the next character
        }

        if (diffCount == 2) {
            // Check if swapping the two differing characters makes the strings equal
            return s1.charAt(firstIdxDiff) == s2.charAt(secondIdxDiff) &&
                    s2.charAt(firstIdxDiff) == s1.charAt(secondIdxDiff);
        } else if (diffCount == 1) {
            return false;  // If only one mismatch exists, swapping isn't possible
        }

        return true;  // If no mismatches exist, the strings are already equal
    }
}
