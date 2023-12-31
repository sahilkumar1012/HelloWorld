package com.example.helloworld.string.easy;

/**
 * leetcode 1624. Largest Substring Between Two Equal Characters
 *
 * Code Harmony Video Solution : https://youtu.be/qQ5_ABahjXw
 *
 *
 * Given a string s, return the length of the longest substring between two equal characters, excluding the two characters. If there is no such substring return -1.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aa"
 * Output: 0
 * Explanation: The optimal substring here is an empty substring between the two 'a's.
 * Example 2:
 *
 * Input: s = "abca"
 * Output: 2
 * Explanation: The optimal substring here is "bc".
 * Example 3:
 *
 * Input: s = "cbzxy"
 * Output: -1
 * Explanation: There are no characters that appear twice in s.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 300
 * s contains only lowercase English letters.
 */
public class LargestSubstringBetweenTwoEqualCharacters {
    /**
     * This method computes the maximum length of a substring between two equal characters.
     *
     * @param s The input string.
     * @return The length of the longest substring between two equal characters. If no such substring exists, return -1.
     */
    public int maxLengthBetweenEqualCharacters(String s) {

        // Initialize the answer to -1 since it represents the absence of a valid substring.
        int ans = -1;

        // Use an array to keep track of the last index of each character encountered.
        // This array will store the last index of each lowercase English letter in the string 's'.
        Integer[] lastIndex = new Integer[26];

        // Traverse through each character in the string.
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If the character's last index is not yet recorded, store its current index.
            if (lastIndex[ch - 'a'] == null) {
                lastIndex[ch - 'a'] = i;
            } else {
                // If the character's last index is already recorded, compute the substring length between the two occurrences.
                // Update the answer with the maximum length found so far.
                ans = Math.max(ans, i - lastIndex[ch - 'a'] - 1);
            }
        }

        // Return the maximum substring length found between two equal characters.
        return ans;
    }
}
