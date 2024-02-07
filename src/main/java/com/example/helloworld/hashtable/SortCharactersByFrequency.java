package com.example.helloworld.hashtable;

import java.util.*;

/**
 * leetcode 451. Sort Characters By Frequency
 *
 * code harmony solution video: https://youtu.be/mvn1BFfTcSk
 *
 *
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
 *
 * Return the sorted string. If there are multiple answers, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "tree"
 * Output: "eert"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cccaaa"
 * Output: "aaaccc"
 * Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input: s = "Aabb"
 * Output: "bbAa"
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 105
 * s consists of uppercase and lowercase English letters and digits.
 */
public class SortCharactersByFrequency {

    /**
     * Method to sort the characters in the input string by their frequency in decreasing order.
     *
     * @param s The input string to be sorted.
     * @return The sorted string based on character frequency.
     */
    public String frequencySort(String s) {
        // Map to store the frequency of each character
        Map<Character, Integer> counts = new HashMap<>();

        // Count the frequency of each character
        for (char ch : s.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }

        // Create a list of characters from the keys of the map
        List<Character> chars = new ArrayList<>(counts.keySet());

        // Sort the characters based on their frequency in descending order
        Collections.sort(chars, (a, b) -> counts.get(b) - counts.get(a));

        // StringBuilder to construct the sorted string
        StringBuilder sb = new StringBuilder();

        // Append characters to the StringBuilder according to their frequency
        for (char c : chars) {
            int n = counts.get(c);
            while (n-- > 0) {
                sb.append(c);
            }
        }

        // Return the sorted string
        return sb.toString();
    }
}