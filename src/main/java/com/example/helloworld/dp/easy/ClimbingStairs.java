package com.example.helloworld.dp.easy;

/**
 * LeetCode 70. Climbing Stairs
 * Problem Link: https://leetcode.com/problems/climbing-stairs/
 * Code Harmony Video Link: https://youtu.be/q5-qjY_JF04
 *
 * Problem Description:
 * You are climbing a staircase with n steps. Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 *
 * Examples:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top: 1) 1 step + 1 step, 2) 2 steps.
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top: 1) 1 step + 1 step + 1 step,
 * 2) 1 step + 2 steps, 3) 2 steps + 1 step.
 *
 * Constraints:
 * 1 <= n <= 45
 */
public class ClimbingStairs {

    // Array to store computed results for dynamic programming approach
    private int[] dp;

    /**
     * Approach 1: Recursion with Memorization (Dynamic Programming)
     * Uses the memorization technique to store already computed values.
     *
     * @param n Number of steps to reach the top
     * @return Number of distinct ways to reach the top
     */
    public int climbStairsRecursion(int n) {
        dp = new int[n + 1]; // Initialize the memorization array
        return solve(n);    // Call the helper function to compute the result
    }

    /**
     * Helper function for recursion with memorization.
     *
     * @param n Number of steps to reach the top
     * @return Number of distinct ways to reach the top
     */
    private int solve(int n) {
        if (n == 0 || n == 1) return 1;   // Base case
        if (dp[n] != 0) return dp[n];     // If already computed, return the result

        // Compute the result for 'n' steps by adding results of (n-1) and (n-2) steps
        return dp[n] = solve(n - 1) + solve(n - 2);
    }




    /**
     * Approach 2: Tabulation (Dynamic Programming)
     * Uses tabulation technique to compute the result bottom-up.
     *
     * @param n Number of steps to reach the top
     * @return Number of distinct ways to reach the top
     */
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];  // Initialize the tabulation array

        dp[0] = 1;  // Base case for 0 steps
        dp[1] = 1;  // Base case for 1 step

        // Compute the result for 'i' steps by summing results of (i-1) and (i-2) steps
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];  // Return the result for 'n' steps
    }
}
