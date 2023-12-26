package com.example.helloworld.dp.easy;

/**
 * LeetCode Problem 1155: Number of Dice Rolls With Target Sum
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 *
 * Problem Description:
 * You have n dice, and each die has k faces numbered from 1 to k.
 * Given three integers n, k, and target, return the number of possible ways
 * (out of the kn total ways) to roll the dice, so the sum of the face-up numbers equals target.
 * Return the answer modulo 10^9 + 7 due to its potential size.
 *
 * Examples:
 * Input: n = 1, k = 6, target = 3 => Output: 1 (Only one way: 3)
 * Input: n = 2, k = 6, target = 7 => Output: 6 (Ways: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1)
 * Input: n = 30, k = 30, target = 500 => Output: 222616187
 *
 * Constraints:
 * 1 <= n, k <= 30
 * 1 <= target <= 1000
 */
public class NumberofDiceRollsWithTargetSum {

    // Memoization table to store computed results for subproblems.
    Integer[][] dp;

    // Modulus value for the final result.
    int M = 1000_000_007;

    /**
     * Method to compute the number of ways to get the target sum.
     *
     * @param n      : Number of dice.
     * @param k      : Number of faces on each die.
     * @param target : Target sum to achieve.
     * @return       : Number of ways to achieve the target sum.
     */
    public int numRollsToTarget(int n, int k, int target) {
        // Initialize the memoization table.
        dp = new Integer[n + 1][target + 1];
        return sol(n, k, target);
    }

    /**
     * Recursive helper function with memoization.
     *
     * @param n      : Remaining number of dice.
     * @param k      : Number of faces on each die.
     * @param target : Target sum to achieve.
     * @return       : Number of ways to achieve the target sum.
     */
    private int sol(int n, int k, int target) {
        // Base case: If no dice left and target is achieved.
        if (n == 0) {
            return target == 0 ? 1 : 0;
        }

        // If target becomes negative, no solution possible.
        if (target < 0) {
            return 0;
        }

        // If solution for current subproblem is already computed, return it.
        if (dp[n][target] != null) {
            return dp[n][target];
        }

        // Initialize the answer count.
        int ans = 0;

        // Try every possible face value for the current die.
        for (int i = 1; i <= k; i++) {
            ans += sol(n - 1, k, target - i); // Recur for remaining dice and reduced target.
            ans %= M; // Take modulo to avoid overflow.
        }

        // Store the computed result in memoization table and return.
        return dp[n][target] = ans;
    }
}
