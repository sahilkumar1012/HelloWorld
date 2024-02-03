package com.example.helloworld.dp;

/**
 * leetcode 1043. Partition Array for Maximum Sum
 *
 * code harmony solution video : https://youtu.be/Qbwi9dlXxds
 *
 * Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. After partitioning, each subarray has their values changed to become the maximum value of that subarray.
 *
 * Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,15,7,9,2,5,10], k = 3
 * Output: 84
 * Explanation: arr becomes [15,15,15,9,10,10,10]
 * Example 2:
 *
 * Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
 * Output: 83
 * Example 3:
 *
 * Input: arr = [1], k = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 109
 * 1 <= k <= arr.length
 */
public class PartitionArrayforMaximumSum {
    int n;
    int k;
    int[] arr;
    Integer[] dp;

    /**
     * Approach 1: Recursion with Memorization
     * Top-down approach using recursion with memoization.
     *
     * @param arr The input array.
     * @param k   The maximum length of subarrays.
     * @return The largest sum of the array after partitioning.
     */
    public int maxSumAfterPartitioningTopDown(int[] arr, int k) {
        n = arr.length;
        this.k = k;
        this.arr = arr;
        dp = new Integer[n];

        return sol(0);
    }

    /**
     * Helper function for top-down approach using recursion with memoization.
     *
     * @param idx The current index in the array.
     * @return The largest sum of the array after partitioning from the current index.
     */
    private int sol(int idx) {
        if (idx >= n) return 0;

        if (dp[idx] != null) return dp[idx];

        int result = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < k && idx + i < n; i++) {
            max = Math.max(max, arr[idx + i]);      // Max value of this partition
            result = Math.max(result, (max * (i + 1)) + sol(idx + i + 1));
        }

        return dp[idx] = result;
    }

    /**
     * Approach 2: Bottom-Up Dynamic Programming
     * Iterative bottom-up approach using dynamic programming.
     *
     * @param arr The input array.
     * @param k   The maximum length of subarrays.
     * @return The largest sum of the array after partitioning.
     */
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            int result = Integer.MIN_VALUE;

            for (int j = i; j > i - k && j >= 0; j--) {
                max = Math.max(max, arr[j]);
                result = Math.max(
                        result,
                        max * (i - j + 1) + (j > 0 ? dp[j - 1] : 0)
                );
            }

            dp[i] = result;
        }

        return dp[n - 1];
    }
}
