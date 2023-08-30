package com.example.helloworld.dp.easy;

/**
 * leetcode 70. Climbing Stairs
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 * Constraints:
 *
 * 1 <= n <= 45
 */
public class ClimbingStairs {
    // memorization dp
    public int climbStairsMemorizationDp(int n) {
        return sol( n, new int[n+1] );
    }

    private int sol(int n, int[] dp){
        if(n<3)
            return n;

        if(dp[n] != 0) return dp[n];

        return dp[n] = sol(n-1, dp) + sol(n-2, dp);
    }

    // tabulation dp
    public int climbStairs(int n) {
        int[] dp = new int[n+1];

        dp[1] = 1;

        if(n>1)
            dp[2] = 2;

        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }


}
