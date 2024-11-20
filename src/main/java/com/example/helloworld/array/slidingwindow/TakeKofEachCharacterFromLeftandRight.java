package com.example.helloworld.array.slidingwindow;

/**
 * leetcode 2516. Take K of Each Character From Left and Right
 * Code harmony video explanation : https://youtu.be/5I5HJMYscgg
 *
 * You are given a string s consisting of the characters 'a', 'b', and 'c' and a non-negative integer k. Each minute, you may take either the leftmost character of s, or the rightmost character of s.
 *
 * Return the minimum number of minutes needed for you to take at least k of each character, or return -1 if it is not possible to take k of each character.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aabaaaacaabc", k = 2
 * Output: 8
 * Explanation:
 * Take three characters from the left of s. You now have two 'a' characters, and one 'b' character.
 * Take five characters from the right of s. You now have four 'a' characters, two 'b' characters, and two 'c' characters.
 * A total of 3 + 5 = 8 minutes is needed.
 * It can be proven that 8 is the minimum number of minutes needed.
 * Example 2:
 *
 * Input: s = "a", k = 1
 * Output: -1
 * Explanation: It is not possible to take one 'b' or 'c' so return -1.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of only the letters 'a', 'b', and 'c'.
 * 0 <= k <= s.length
 */
public class TakeKofEachCharacterFromLeftandRight {
    int k; // Required count of each character

    /**
     * Finds the minimum number of characters to take from the left or right to satisfy the condition.
     *
     * @param s The input string consisting of 'a', 'b', and 'c'.
     * @param k The minimum count of each character required.
     * @return The minimum number of minutes needed, or -1 if it's not possible.
     */
    public int takeCharacters(String s, int k) {
        this.k = k; // Store `k` for use in validation
        int[] count = new int[3]; // Array to track counts of 'a', 'b', and 'c'

        // Calculate the total count of each character in the string
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++; // Increment count for the respective character
        }

        // Check if it's possible to have at least `k` occurrences of each character
        if (!valid(count)) return -1;

        // If we reach here, it is possible to satisfy the condition.
        // Use a sliding window approach to find the maximum length of an "invalid" substring.

        int begin = 0, end = 0; // Sliding window pointers
        int max = -1; // Maximum length of a valid window (i.e., invalid substring)

        while (end < s.length()) {
            // Expand the window by including the character at `end`
            char ch = s.charAt(end);
            count[ch - 'a']--; // Decrement the count of the character in the window

            // Shrink the window from the left until the window becomes valid again
            while (!valid(count) && begin <= end) {
                count[s.charAt(begin) - 'a']++; // Restore the count for the character being removed
                begin++; // Move the left pointer forward
            }

            // Update the maximum length of the valid window
            max = Math.max(max, end - begin + 1);
            end++; // Move the right pointer forward
        }

        // The result is the total length of the string minus the maximum valid window size
        return s.length() - max;
    }

    /**
     * Checks if the current counts of characters meet the requirement of having at least `k` of each.
     *
     * @param count Array containing counts of 'a', 'b', and 'c'.
     * @return True if the counts are valid, otherwise false.
     */
    private boolean valid(int[] count) {
        for (int i : count) { // Check each character's count
            if (i < k) return false; // If any count is less than `k`, return false
        }
        return true; // All counts are valid
    }
}

