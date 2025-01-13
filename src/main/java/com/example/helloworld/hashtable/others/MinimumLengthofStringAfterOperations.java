package com.example.helloworld.hashtable.others;

/**
 * leetcode 3223. Minimum Length of String After Operations
 *
 * Code harmony video explanation : https://youtu.be/IYfZmxazJoA
 *
 * My leetcode solution : https://leetcode.com/problems/minimum-length-of-string-after-operations/solutions/6272935/easy-to-understand-hash-table-java-detai-z3pf
 *
 * You are given a string s.
 *
 * You can perform the following process on s any number of times:
 *
 * Choose an index i in the string such that there is at least one character to the left of index i that is equal to s[i], and at least one character to the right that is also equal to s[i].
 * Delete the closest character to the left of index i that is equal to s[i].
 * Delete the closest character to the right of index i that is equal to s[i].
 * Return the minimum length of the final string s that you can achieve.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abaacbcbb"
 *
 * Output: 5
 *
 * Explanation:
 * We do the following operations:
 *
 * Choose index 2, then remove the characters at indices 0 and 3. The resulting string is s = "bacbcbb".
 * Choose index 3, then remove the characters at indices 0 and 5. The resulting string is s = "acbcb".
 * Example 2:
 *
 * Input: s = "aa"
 *
 * Output: 2
 *
 * Explanation:
 * We cannot perform any operations, so we return the length of the original string.
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2 * 105
 * s consists only of lowercase English letters.
 */
public class MinimumLengthofStringAfterOperations {
    public int minimumLength(String s) {
        // Step 1: Initialize a frequency array for characters a-z
        int[] hash = new int[26];
        for (char ch : s.toCharArray()) {
            // Increment the count for the corresponding character in the frequency array
            hash[ch - 'a']++;
        }

        int ans = 0; // Initialize the result variable to store the minimum length

        // Step 2: Traverse the frequency array to calculate the minimum length
        for (int i = 0; i < 26; i++) {
            if (hash[i] > 0) { // Check if the character exists in the string
                if (hash[i] % 2 == 0) {
                    // If the frequency is even, add 2 to the result
                    ans += 2;
                } else {
                    // If the frequency is odd, add 1 to the result
                    ans++;
                }
            }
        }

        // Step 3: Return the calculated minimum length
        return ans;
    }
}
