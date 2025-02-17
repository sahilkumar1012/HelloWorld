package com.example.helloworld.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 1079. Letter Tile Possibilities , Asked in Google, Amazon
 *
 * code harmony video explanation : https://youtu.be/-tvgS6dLgFE
 *
 * my leetcode solution : https://leetcode.com/problems/letter-tile-possibilities/solutions/6432772/easy-to-understand-permutations-backtrac-5edx
 *
 *
 * You have n  tiles, where each tile has one letter tiles[i] printed on it.
 *
 * Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.
 *
 *
 *
 * Example 1:
 *
 * Input: tiles = "AAB"
 * Output: 8
 * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
 * Example 2:
 *
 * Input: tiles = "AAABBC"
 * Output: 188
 * Example 3:
 *
 * Input: tiles = "V"
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= tiles.length <= 7
 * tiles consists of uppercase English letters.
 *
 *
 */
public class LetterTilePossibilities {
    int ans;  // Global variable to store the count of valid sequences

    public int numTilePossibilities(String tiles) {
        int[] hash = new int[26];  // Frequency array to store the count of each letter (A-Z)

        // Count the occurrences of each character in the given tiles string
        for (char ch : tiles.toCharArray())
            hash[ch - 'A']++;

        ans = 0; // Initialize the answer count
        sol(hash); // Start the recursive function
        return ans; // Return the final count of possible sequences
    }

    private void sol(int[] hash) {
        // Iterate through all 26 possible letters
        for (int i = 0; i < 26; i++) {
            if (hash[i] == 0) continue; // Skip letters that are not available

            ans++; // Count the current sequence

            hash[i]--; // Use one occurrence of the current letter
            sol(hash); // Recur to generate further sequences
            hash[i]++; // Backtrack: Restore the count of the letter
        }
    }

}
