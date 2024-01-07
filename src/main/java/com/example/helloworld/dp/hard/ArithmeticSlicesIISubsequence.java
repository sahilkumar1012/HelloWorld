package com.example.helloworld.dp.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode  446. Arithmetic Slices II - Subsequence | hard
 *
 * code harmony solution video : https://youtu.be/j2abH1d7B1s
 *
 *
 * Given an integer array nums, return the number of all the arithmetic subsequences of nums.
 *
 * A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 *
 * For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.
 * For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
 * A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.
 *
 * For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
 * The test cases are generated so that the answer fits in 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,4,6,8,10]
 * Output: 7
 * Explanation: All arithmetic subsequence slices are:
 * [2,4,6]
 * [4,6,8]
 * [6,8,10]
 * [2,4,6,8]
 * [4,6,8,10]
 * [2,4,6,8,10]
 * [2,6,10]
 * Example 2:
 *
 * Input: nums = [7,7,7,7,7]
 * Output: 16
 * Explanation: Any subsequence of this array is arithmetic.
 *
 *
 * Constraints:
 *
 * 1  <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 */
public class ArithmeticSlicesIISubsequence {

    /**
     * Method to calculate the number of arithmetic subsequences in the given array.
     *
     * @param A The input integer array.
     * @return The number of arithmetic subsequences.
     */
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length; // Length of the input array.
        long ans = 0; // Variable to store the answer.
        Map<Integer, Integer>[] dp = new Map[n]; // Dynamic programming array.

        // Loop through each element in the array.
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>(i); // Create a hashmap for each element.

            // Loop through each previous element to check for arithmetic subsequences.
            for (int j = 0; j < i; j++) {
                long delta = (long) A[i] - (long) A[j]; // Calculate the difference between elements.

                // Check if the difference is within integer range.
                // as per statement : The test cases are generated so that the answer fits in 32-bit integer.
                if (delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE) {
                    continue; // If not, skip to the next iteration.
                }

                int diff = (int) delta; // Convert the difference to integer.

                int sum = dp[j].getOrDefault(diff, 0); // Get the count of subsequences ending at j with this diff.

                int existing = dp[i].getOrDefault(diff, 0); // Get existing count of subsequences ending at i with this diff.

                dp[i].put(diff, existing + sum + 1); // Update the count of subsequences ending at i with this diff.

                ans += sum; // Add the count to the answer. Whenever we use subsequences ending at j, append to the answer.
            }
        }
        return (int) ans; // Return the total count of arithmetic subsequences.
    }
}
