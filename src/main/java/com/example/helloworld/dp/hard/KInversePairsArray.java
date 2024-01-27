package com.example.helloworld.dp.hard;

/**
 * leetcode 629. K Inverse Pairs Array
 *
 * code harmony solution video : https://youtu.be/BAh0wm6qF1Q
 *
 * For an integer array nums, an inverse pair is a pair of integers [i, j] where 0 <= i < j < nums.length and nums[i] > nums[j].
 *
 * Given two integers n and k, return the number of different arrays consist of numbers from 1 to n such that there are exactly k inverse pairs. Since the answer can be huge, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3, k = 0
 * Output: 1
 * Explanation: Only the array [1,2,3] which consists of numbers from 1 to 3 has exactly 0 inverse pairs.
 * Example 2:
 *
 * Input: n = 3, k = 1
 * Output: 2
 * Explanation: The array [1,3,2] and [2,1,3] have exactly 1 inverse pair.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 1000
 * 0 <= k <= 1000
 */
public class KInversePairsArray {

    // Memoization table to store intermediate results
    Integer[][] dp = new Integer[1001][1001];

    /**
     * Method to calculate the number of arrays with k inverse pairs.
     *
     * @param n Number of elements in the array (1 to n).
     * @param k Number of inverse pairs desired.
     * @return The count of arrays with exactly k inverse pairs.
     */
    public int kInversePairs(int n, int k) {
        // Base cases
        if (n == 0) return 0;
        if (k == 0) return 1;   // found 1 valid array having elements [1 to n]

        // If the result is already calculated, return it
        if (dp[n][k] != null)
            return dp[n][k];

        // Initialize count
        int count = 0;

        // Iterate through possible values for the first element in the array
        for (int i = 0; i <= Math.min(k, n - 1); i++) {
            // Recursively calculate the count for the remaining elements
            count += kInversePairs(n - 1, k - i);
            count %= 1000000007; // Apply modulo to prevent overflow
        }

        // Store the result in the memoization table and return it
        return dp[n][k] = count;
    }
}
