package com.example.helloworld.string.others;


import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 2981 Find Longest Special Substring That Occurs Thrice I | Google Interview Question
 *
 * code harmony video explanation : https://youtu.be/6QhqDJ2H1VU
 *
 * My LeetCode solution : https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/solutions/6131715/easy-intuitive-approach-string-hashtable-detailed-video-explanation
 *
 * You are given a string s that consists of lowercase English letters.
 *
 * A string is called special if it is made up of only a single character. For example, the string "abc" is not special, whereas the strings "ddd", "zz", and "f" are special.
 *
 * Return the length of the longest special substring of s which occurs at least thrice, or -1 if no special substring occurs at least thrice.
 *
 * A substring is a contiguous non-empty sequence of characters within a string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aaaa"
 * Output: 2
 * Explanation: The longest special substring which occurs thrice is "aa": substrings "aaaa", "aaaa", and "aaaa".
 * It can be shown that the maximum length achievable is 2.
 * Example 2:
 *
 * Input: s = "abcdef"
 * Output: -1
 * Explanation: There exists no special substring which occurs at least thrice. Hence return -1.
 * Example 3:
 *
 * Input: s = "abcaba"
 * Output: 1
 * Explanation: The longest special substring which occurs thrice is "a": substrings "abcaba", "abcaba", and "abcaba".
 * It can be shown that the maximum length achievable is 1.
 *
 *
 * Constraints:
 *
 * 3 <= s.length <= 50
 * s consists of only lowercase English letters.
 */
public class FindLongestSpecialSubstringThatOccursThriceI {

    public int maximumLength(String s) {
        // Create a map to store substrings and their frequency
        Map<String, Integer> map = new HashMap<>();
        int n = s.length();

        // Iterate through each character in the string
        for (int i = 0; i < n; i++) {
            int j = i; // Initialize the end pointer of the substring
            do {
                // Extract the substring from index i to j
                String ss = s.substring(i, j + 1);
                // Update the frequency of the substring in the map
                map.put(ss, map.getOrDefault(ss, 0) + 1);

                // Check if the next character is the same as the current one
                // If so, extend the substring by incrementing j
                if (j < n - 1 && s.charAt(j) == s.charAt(j + 1)) {
                    j++;
                } else {
                    // Break the loop if the substring cannot be extended
                    break;
                }
            } while (j < n); // Continue while within the bounds of the string
        }

        // Initialize a variable to store the longest valid substring
        String ssmax = "";

        // Iterate through the map to find the longest substring
        // that appears at least 3 times
        for (String ss : map.keySet()) {
            if (map.get(ss) >= 3 && ss.length() > ssmax.length()) {
                ssmax = ss;
            }
        }

        // If no valid substring is found, return -1
        // Otherwise, return the length of the longest valid substring
        return ssmax.equals("") ? -1 : ssmax.length();
    }

}
