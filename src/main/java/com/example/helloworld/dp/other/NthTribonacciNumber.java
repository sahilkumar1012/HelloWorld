package com.example.helloworld.dp.other;

/**
 * leetcode 1137. N-th Tribonacci Number
 *
 * Code harmony video solution : https://youtu.be/74ADMbrZEX4
 *
 * The Tribonacci sequence Tn is defined as follows:
 *
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 *
 * Given n, return the value of Tn.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4
 * Output: 4
 * Explanation:
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * Example 2:
 *
 * Input: n = 25
 * Output: 1389537
 *
 *
 * Constraints:
 *
 * 0 <= n <= 37
 * The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
 */
public class NthTribonacciNumber {

    // Memoization array to store calculated values for dynamic programming approach.
    int[] dp = new int[38];

    /**
     * Recursive solution with memoization.
     * Time Complexity: O(n)
     * Space Complexity: O(n) due to the memoization array.
     */
    public int tribonacciRecursion(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        // Check if value for n is already computed and stored in dp array.
        if (dp[n] != 0) return dp[n];

        // Recursive formula for Tribonacci sequence.
        return dp[n] = tribonacciRecursion(n - 1) + tribonacciRecursion(n - 2) + tribonacciRecursion(n - 3);
    }

    /**
     * Dynamic programming solution using extra space.
     * Time Complexity: O(n)
     * Space Complexity: O(n) for the dp array.
     */
    public int tribonacciWithSpace(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        // Initialize base cases.
        dp[1] = 1;
        dp[2] = 1;

        // Compute Tribonacci sequence using dynamic programming.
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    /**
     * Efficient solution with constant space using iterative approach.
     * Time Complexity: O(n)
     * Space Complexity: O(1) as no extra space is used apart from three variables.
     */
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        // Initialize first three numbers of Tribonacci sequence.
        int a = 0, b = 1, c = 1;

        // Compute Tribonacci sequence iteratively.
        for (int i = 3; i <= n; i++) {
            int temp = a + b + c;
            a = b;
            b = c;
            c = temp;
        }
        return c;
    }

}
