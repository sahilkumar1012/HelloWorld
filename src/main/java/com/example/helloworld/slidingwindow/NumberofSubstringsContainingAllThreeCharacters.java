package com.example.helloworld.slidingwindow;

/**
 * leetcode 1358. Number of Substrings Containing All Three Characters , Meta Google Amazon Microsoft
 *
 * code harmony video explanation : https://youtu.be/DAVhYDAKCRc
 *
 * My leetcode solution : https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/solutions/6523403/easy-to-understand-variable-sliding-wind-a37b
 *
 * Given a string s consisting only of characters a, b and c.
 *
 * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabc"
 * Output: 10
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
 * Example 2:
 *
 * Input: s = "aaacb"
 * Output: 3
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
 * Example 3:
 *
 * Input: s = "abc"
 * Output: 1
 *
 *
 * Constraints:
 *
 * 3 <= s.length <= 5 x 10^4
 * s only consists of a, b or c characters.
 */
public class NumberofSubstringsContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        int n = s.length(), ans = 0;
        int[] hash = new int[3]; // Array to store the frequency of 'a', 'b', and 'c'
        int i = 0, j = 0; // Two pointers for the sliding window approach

        for (; j < n; j++) { // Expand the right boundary of the window
            char ch = s.charAt(j);
            hash[ch - 'a']++; // Increase the count of the current character in the hash array

            // If the window contains at least one 'a', 'b', and 'c', start shrinking from the left
            while (valid(hash)) {
                ans += (n - j); // Every valid substring from i to n contributes (n - j) substrings

                ch = s.charAt(i);
                hash[ch - 'a']--; // Remove the leftmost character from the window
                i++; // Shrink the window from the left
            }
        }
        return ans; // Return the total count of valid substrings
    }

    // Helper function to check if the window contains at least one 'a', 'b', and 'c'
    private boolean valid(int[] hash) {
        return hash[0] > 0 && hash[1] > 0 && hash[2] > 0;
    }

}
