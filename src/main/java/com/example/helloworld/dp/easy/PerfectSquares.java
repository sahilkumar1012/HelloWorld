package com.example.helloworld.dp.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 279. Perfect Squares
 *
 * code harmony solution video : https://youtu.be/wyIkVKccd1w
 *
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 *
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 104
 *
 */
public class PerfectSquares {

    List<Integer> pslist;
    int[][] dp;

    // top down DP approach
    public int numSquares(int n) {
        pslist = new ArrayList<>();

        // Generate a list of perfect squares up to n
        for(int i=1; i*i <= n ; i++){
            pslist.add(i*i);
        }

        dp = new int[pslist.size()][n+1];
        return sol(0, n);
    }

    /**
     * Recursive function to find the minimum number of perfect squares summing up to the target.
     * @param idx index of the current perfect square to consider
     * @param target remaining target value
     * @return minimum number of perfect squares
     */
    private int sol(int idx, int target){
        // If the target is achieved, return 0
        if(target == 0) return 0;

        // If we have exhausted all perfect squares or if the target is negative, return a large value
        if(idx == pslist.size() || target < 0) return 99999;

        // If the result for the current index and target is already calculated, return it
        if(dp[idx][target] != 0)   return dp[idx][target];

        // Choose whether to include the current perfect square or not and return the minimum result
        return dp[idx][target] = Math.min(
                1 + sol(idx, target-pslist.get(idx)), // Include the current perfect square
                sol( idx+1, target) // Exclude the current perfect square
        );
    }
}
