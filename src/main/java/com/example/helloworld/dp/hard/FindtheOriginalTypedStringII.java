package com.example.helloworld.dp.hard;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * leetcode 3333. Find the Original Typed String II , prefix DP
 *
 * code harmony explanation video : https://youtu.be/ICAG-q2s8DE
 *
 * Alice is attempting to type a specific string on her computer. However, she tends to be clumsy and may press a key for too long, resulting in a character being typed multiple times.
 *
 * You are given a string word, which represents the final output displayed on Alice's screen. You are also given a positive integer k.
 *
 * Return the total number of possible original strings that Alice might have intended to type, if she was trying to type a string of size at least k.
 *
 * Since the answer may be very large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: word = "aabbccdd", k = 7
 *
 * Output: 5
 *
 * Explanation:
 *
 * The possible strings are: "aabbccdd", "aabbccd", "aabbcdd", "aabccdd", and "abbccdd".
 *
 * Example 2:
 *
 * Input: word = "aabbccdd", k = 8
 *
 * Output: 1
 *
 * Explanation:
 *
 * The only possible string is "aabbccdd".
 *
 * Example 3:
 *
 * Input: word = "aaabbb", k = 3
 *
 * Output: 8
 *
 *
 *
 * Constraints:
 *
 * 1 <= word.length <= 5 * 105
 * word consists only of lowercase English letters.
 * 1 <= k <= 2000
 */

// Rec with memorization - TLE
// class Solution {
//     final int MOD = 1_000_000_007;
//     Integer[][] dp;

//     public int possibleStringCountRec(String word, int k) {
//         List<int[]> groups = new ArrayList<>();
//         int count = 1;

//         for (int i = 1; i < word.length(); i++) {
//             if (word.charAt(i) == word.charAt(i - 1)) {
//                 count++;
//             } else {
//                 groups.add(new int[]{word.charAt(i - 1), count});
//                 count = 1;
//             }
//         }
//         groups.add(new int[]{word.charAt(word.length() - 1), count});

//         int n = groups.size();
//         dp = new Integer[n + 1][k + 1];

//         return dfs(groups, 0, 0, k);
//     }

//     private int dfs(List<int[]> groups, int idx, int len, int k) {
//         if (idx == groups.size()) {
//             return len >= k ? 1 : 0;
//         }

//         if (dp[idx][len] != null) return dp[idx][len];

//         int ans = 0;
//         int maxCount = groups.get(idx)[1];

//         for (int take = 1; take <= maxCount; take++) {
//             int newLen = Math.min(len + take, k);
//             ans = (ans + dfs(groups, idx + 1, newLen, k)) % MOD;
//         }

//         return dp[idx][len] = ans;
//     }


// }


// without prefix sum - bottom up approach - still TLE
// public class Solution {
//     final int MOD = 1_000_000_007;

//     public int possibleStringCount(String word, int k) {
//         List<Integer> groups = new ArrayList<>();
//         int count = 1;

//         for (int i = 1; i < word.length(); i++) {
//             if (word.charAt(i) == word.charAt(i - 1)) {
//                 count++;
//             } else {
//                 groups.add(count);
//                 count = 1;
//             }
//         }
//         groups.add(count);

//         int maxLen = word.length();
//         int[] dp = new int[maxLen + 1];
//         dp[0] = 1;

//         for (int freq : groups) {
//             int[] newDp = new int[maxLen + 1];

//             for (int len = 0; len <= maxLen; len++) {
//                 if (dp[len] == 0) continue;

//                 for (int take = 1; take <= freq; take++) {
//                     if (len + take > maxLen) break;
//                     newDp[len + take] = (newDp[len + take] + dp[len]) % MOD;
//                 }
//             }

//             dp = newDp;
//         }

//         int ans = 0;
//         for (int i = k; i <= maxLen; i++) {
//             ans = (ans + dp[i]) % MOD;
//         }

//         return ans;
//     }
// }


// total valid strings of all length : f1*f2*f3*....fn = total
// total valid strings of length < k.


// passed !!! prefix DP
public class FindtheOriginalTypedStringII {

    static final int MOD = 1_000_000_007;
    // >=k , <k
    public int possibleStringCount(String word, int k) {
        List<Integer> freq = new ArrayList<>();
        int count = 1;

        // Step 1: Group consecutive characters
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) count++;
            else {
                freq.add(count);
                count = 1;
            }
        }
        freq.add(count);

        // Step 2: Calculate total combinations
        long total = 1;
        for (int f : freq) {
            total = (total * f) % MOD;
        }

        // Early return optimization
        if (freq.size() >= k) return (int) total;

        // Step 3: Bottom-up DP with prefix sums
        int[] dp = new int[k]; // only for lengths < k
        dp[0] = 1;

        for (int f : freq) {
            int[] prefix = new int[k + 1];
            for (int i = 0; i < k; i++) {
                prefix[i + 1] = (prefix[i] + dp[i]) % MOD;
            }

            int[] newDp = new int[k];
            for (int len = 0; len < k; len++) {
                int from = Math.max(0, len - f);
                newDp[len] = (prefix[len] - prefix[from] + MOD) % MOD;
            }

            dp = newDp;
        }

        // Step 4: Count all strings of length < k
        int invalid = 0;
        for (int i = 0; i < k; i++) {
            invalid = (invalid + dp[i]) % MOD;
        }

        return (int) ((total - invalid + MOD) % MOD);
    }
}
