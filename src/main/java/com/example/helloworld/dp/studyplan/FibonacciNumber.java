package com.example.helloworld.dp.studyplan;

/**
 * LeetCode 509. Fibonacci Number
 * Problem Link: https://leetcode.com/problems/fibonacci-number/
 *
 * Description:
 * The Fibonacci numbers, denoted as F(n), form a sequence where each number is the sum
 * of the two preceding ones, starting from 0 and 1.
 *
 * Formula:
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 *
 * Constraints: 0 <= n <= 30
 */
public class FibonacciNumber {

    // Using an array to store previously computed Fibonacci numbers
    int[] dp = new int[31];

    /**
     * Top-down Dynamic Programming approach.
     * This method uses memoization to store previously computed Fibonacci numbers.
     *
     * @param n The index of the Fibonacci number to compute.
     * @return The Fibonacci number at index n.
     */
    public int fibDP(int n) {
        // Base cases: F(0) and F(1)
        if (n <= 1) return n;

        // If the Fibonacci number at index n has already been computed, return it.
        if (dp[n] != 0) return dp[n];

        // Compute F(n) recursively by summing up the previous two Fibonacci numbers.
        return dp[n] = fibDP(n - 1) + fibDP(n - 2);
    }

    /**
     * Bottom-up Dynamic Programming approach.
     * This method computes the Fibonacci number iteratively using a loop.
     *
     * @param n The index of the Fibonacci number to compute.
     * @return The Fibonacci number at index n.
     */
    public int fib(int n) {
        // Base cases: F(0) and F(1)
        if (n <= 1) return n;

        int prev1 = 1;  // F(1)
        int prev2 = 0;  // F(0)
        int curr = 0;   // Current Fibonacci number

        // Compute F(n) iteratively from the bottom up.
        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;  // Compute F(i) = F(i-1) + F(i-2)

            // Update previous Fibonacci numbers for the next iteration.
            prev2 = prev1;
            prev1 = curr;
        }

        return curr;  // Return the Fibonacci number at index n.
    }
}
