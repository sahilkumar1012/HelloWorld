package com.example.helloworld.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * 1593. Split a String Into the Max Number of Unique Substrings
 *
 * Given a string s, return the maximum number of unique substrings that the given string can be split into.
 *
 * You can split the string s into any list of non-empty substrings, where the concatenation of the substrings
 * forms the original string. However, the substrings must all be unique.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 * Example 1:
 * Input: s = "ababccc"
 * Output: 5
 * Explanation: One way to split maximally is ['a', 'b', 'ab', 'c', 'cc'].
 * Splitting like ['a', 'b', 'a', 'b', 'c', 'cc'] is not valid as 'a' and 'b' repeat.
 *
 * Example 2:
 * Input: s = "aba"
 * Output: 2
 * Explanation: One way to split maximally is ['a', 'ba'].
 *
 * Example 3:
 * Input: s = "aa"
 * Output: 1
 * Explanation: It is impossible to split the string any further.
 *
 * Constraints:
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 */

public class SplitaStringIntotheMaxNumberofUniqueSubstrings {
    // A set to track unique substrings
    Set<String> set;
    // The input string s
    String s;
    // Variable to store the maximum number of unique substrings found
    int ans;

    /**
     * This method initializes the process and calls the recursive function 'sol'
     * to start the backtracking process.
     *
     * @param s Input string to split into unique substrings.
     * @return The maximum number of unique substrings.
     */
    public int maxUniqueSplit(String s) {
        // Initialize the HashSet to store unique substrings
        set = new HashSet<>();
        // Store the input string for future use
        this.s = s;
        // Initialize ans to 0, which will hold the final result
        ans = 0;

        // Start the backtracking from index 0
        sol(0);

        // Return the maximum number of unique substrings found
        return ans;
    }

    /**
     * The recursive function that tries to split the string into unique substrings
     * and keeps track of the maximum number of unique splits.
     *
     * @param idx The current index to start splitting the string from.
     */
    private void sol(int idx){
        // Base case: If we have reached the end of the string
        if (idx == s.length()) {
            // Update ans with the maximum size of unique substrings found so far
            ans = Math.max(ans, set.size());
            return; // Exit the recursive call
        }

        // Try to generate all possible substrings starting from the current index
        int i = idx + 1;  // 'i' represents the end index of the substring (exclusive)
        while (i <= s.length()) {
            // Extract the substring from the current index to 'i'
            String ss = s.substring(idx, i);

            // If the substring is not already in the set (i.e., it is unique)
            if (!set.contains(ss)) {
                // Add the substring to the set to track it
                set.add(ss);
                // Recursively call the function for the next index (i)
                sol(i);
                // Backtrack by removing the substring and trying a different one
                set.remove(ss); // This substring didn't work, so remove and try the next one
            }
            i++; // Move to the next possible substring
        }
    }

}
