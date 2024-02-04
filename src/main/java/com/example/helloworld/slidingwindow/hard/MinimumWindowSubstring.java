package com.example.helloworld.slidingwindow.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 76. Minimum Window Substring
 *
 * code harmony youtube solution : https://youtu.be/WNXifOLW0hw
 *
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring
 *  of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 *
 * Constraints:
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 *
 *
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 */
public class MinimumWindowSubstring {

    /**
     * Sliding window approach to find the minimum window substring.
     *
     * @param s The input string.
     * @param t The target string.
     * @return The minimum window substring containing all characters from t, or an empty string if not found.
     */
    public String minWindow(String s, String t) {
        int i = 0, j = 0, count = t.length();
        int n = s.length();

        int minLen = Integer.MAX_VALUE;
        String ans = "";

        // Map to store the frequency of characters in string t
        Map<Character, Integer> tmap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }

        // Sliding window logic
        while (i < n || j < n) {

            if (count == 0) {
                // If we have a better length solution
                if (j - i < minLen) {
                    minLen = j - i;
                    ans = s.substring(i, j);

                    if (minLen == t.length()) {
                        // This is the minimum possible length, return the answer
                        return ans;
                    }
                }

                // Move the left pointer and update counts
                char ichar = s.charAt(i);
                if (tmap.containsKey(ichar)) {
                    tmap.put(ichar, tmap.get(ichar) + 1);
                    if (tmap.get(ichar) > 0) {
                        // Adding 1 char to count
                        count += 1;
                    }
                }
                i++;

            } else if (j < n) {
                // Move the right pointer and update counts
                char jchar = s.charAt(j);
                if (tmap.containsKey(jchar)) {
                    tmap.put(jchar, tmap.get(jchar) - 1);
                    if (tmap.get(jchar) >= 0) {
                        count--;
                    }
                }
                j++;
            } else {
                // No more solutions, break the loop
                break;
            }
        }

        return ans;
    }

    /**
     * Below is the brute force approach
     *
     * @param map  The map to check if it contains all characters from t.
     * @param tmap The map representing the frequency of characters in t.
     * @return True if map contains all characters from t, false otherwise.
     */
    private boolean check(Map<Character, Integer> map, Map<Character, Integer> tmap) {
        for (char key : tmap.keySet()) {
            if (map.get(key) == null || tmap.get(key) > map.get(key)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Brute force approach to find the minimum window substring.
     *
     * @param s The input string.
     * @param t The target string.
     * @return The minimum window substring containing all characters from t, or an empty string if not found.
     */
    public String minWindowBruteForce(String s, String t) {
        Map<Character, Integer> tmap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }

        // Iterate through all possible lengths and check for a valid window
        for (int len = t.length(); len <= s.length(); len++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < s.length(); j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                if (j >= len) {
                    map.put(s.charAt(j - len), map.get(s.charAt(j - len)) - 1);
                    if (map.get(s.charAt(j - len)) == 0)
                        map.remove(s.charAt(j - len));
                }
                if (j >= len - 1) {
                    if (check(map, tmap)) {
                        return s.substring(j - len + 1, j + 1);
                    }
                }
            }
        }
        return "";
    }
}