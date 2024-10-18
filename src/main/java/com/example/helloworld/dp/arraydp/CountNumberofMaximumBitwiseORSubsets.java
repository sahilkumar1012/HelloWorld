package com.example.helloworld.dp.arraydp;

/**
 * Leetcode 2044. Count Number of Maximum Bitwise-OR Subsets
 *
 * Problem: Given an integer array nums, find the maximum possible bitwise OR of a subset of nums
 * and return the number of different non-empty subsets with the maximum bitwise OR.
 *
 * A subset is defined as a selection of elements (with some elements possibly removed) from the array.
 * Two subsets are considered different if they have different indices of the chosen elements.
 *
 * The bitwise OR of an array is computed by applying the OR operator between all elements.
 *
 * Example 1:
 * Input: nums = [3,1]
 * Output: 2
 * Explanation: The maximum possible bitwise OR is 3. There are 2 subsets with a bitwise OR of 3:
 * - [3]
 * - [3,1]
 *
 * Example 2:
 * Input: nums = [2,2,2]
 * Output: 7
 * Explanation: All non-empty subsets of [2,2,2] have a bitwise OR of 2. There are 2^3 - 1 = 7 total subsets.
 *
 * Example 3:
 * Input: nums = [3,2,1,5]
 * Output: 6
 * Explanation: The maximum possible bitwise OR is 7. There are 6 subsets with a bitwise OR of 7:
 * - [3,5]
 * - [3,1,5]
 * - [3,2,5]
 * - [3,2,1,5]
 * - [2,5]
 * - [2,1,5]
 *
 * Constraints:
 * 1 <= nums.length <= 16
 * 1 <= nums[i] <= 10^5
 */
public class CountNumberofMaximumBitwiseORSubsets {
    // Variables to store length of array and count of valid subsets
    int n;
    int count;

    // Input array
    int[] nums;

    // DP table to store results of overlapping subproblems
    int[][] dp;

    /**
     * Main function that counts the number of subsets with the maximum bitwise OR.
     * @param arr Input array of integers
     * @return The number of subsets with the maximum bitwise OR
     */
    public int countMaxOrSubsets(int[] arr) {
        n = arr.length; // Get the length of the input array
        this.nums = arr; // Store the input array in the class variable
        count = 0; // Initialize the subset count

        // Compute the maximum possible bitwise OR of all elements in the array
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            max |= arr[i]; // Perform OR operation for each element in the array
        }

        // Initialize the DP table with dimensions [n][max+1]
        dp = new int[n][max + 1];

        // Start the recursive solution from the first index with an initial OR value of 0
        return sol(0, max, 0);
    }

    /**
     * Recursive function to solve the problem using dynamic programming.
     * @param idx Current index in the nums array
     * @param max Maximum possible OR value for the subset
     * @param curr Current bitwise OR value for the subset being built
     * @return Number of valid subsets that achieve the maximum bitwise OR
     */
    private int sol(int idx, int max, int curr) {
        // Base case: if we have processed all elements in the array
        if (idx == n) {
            // Check if the current OR value is equal to the maximum OR value
            if (curr == max) return 1; // Valid subset, return 1
            return 0; // Invalid subset, return 0
        }

        // Check if the result for this subproblem has already been computed
        if (dp[idx][curr] > 0) return dp[idx][curr];

        // Case 1: Include the current element in the subset
        int count1 = sol(idx + 1, max, curr | nums[idx]);

        // Case 2: Do not include the current element in the subset
        int count2 = sol(idx + 1, max, curr);

        // Store the result of the current subproblem in the DP table
        return dp[idx][curr] = count1 + count2;
    }
}
