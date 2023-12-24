package com.example.helloworld.string.others;

/**
 * Leetcode 1758: Minimum Changes To Make Alternating Binary String
 * https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/
 *
 * Problem Statement:
 * Given a string s consisting only of the characters '0' and '1'. In one operation,
 * you can change any '0' to '1' or vice versa. The string is called alternating if no
 * two adjacent characters are equal. Return the minimum number of operations needed
 * to make s alternating.
 *
 * Examples:
 * Input: s = "0100"
 * Output: 1
 * Explanation: If you change the last character to '1', s will be "0101", which is alternating.
 *
 * Input: s = "10"
 * Output: 0
 * Explanation: s is already alternating.
 *
 * Input: s = "1111"
 * Output: 2
 * Explanation: You need two operations to reach "0101" or "1010".
 *
 * Constraints:
 * 1 <= s.length <= 10^4
 * s[i] is either '0' or '1'.
 */
public class MinimumChangesToMakeAlternatingBinaryString {

    /**
     * This method calculates the minimum number of operations needed to make the given string s alternating.
     * The strategy is to count the number of positions where the string should start with '0' (0-indexed positions)
     * and where it should start with '1'. Then, return the minimum of these two counts.
     *
     * @param s The input string consisting of '0's and '1's.
     * @return The minimum number of operations needed to make s alternating.
     */
    public int minOperations(String s) {
        // Length of the input string.
        int n = s.length();

        // Counter to store the number of positions where the string should start with '0'.
        int start0 = 0;

        // Iterate through the string to count positions where it should start with '0' or '1'.
        for (int i = 0; i < n; i++) {
            // If the index is even (0-indexed), then the character should be '0'.
            if (i % 2 == 0) {
                if (s.charAt(i) == '1') {
                    start0++; // Increment the counter if the character is '1' at even index.
                }
            } else {
                // If the index is odd, then the character should be '1'.
                if (s.charAt(i) == '0') {
                    start0++; // Increment the counter if the character is '0' at odd index.
                }
            }
        }

        // Return the minimum of 'start0' and '(n - start0)' as both represent the possible alternate strings.
        return Math.min(start0, n - start0);
    }
}
