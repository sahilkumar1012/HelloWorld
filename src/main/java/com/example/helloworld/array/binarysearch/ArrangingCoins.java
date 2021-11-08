package com.example.helloworld.array.binarysearch;

/**
 * leetcode 441. Arranging Coins
 *
 * You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.
 *
 * Given the integer n, return the number of complete rows of the staircase you will build.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 5
 * Output: 2
 * Explanation: Because the 3rd row is incomplete, we return 2.
 * Example 2:
 *
 *
 * Input: n = 8
 * Output: 3
 * Explanation: Because the 4th row is incomplete, we return 3.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 231 - 1
 */
public class ArrangingCoins {

    public int arrangeCoins(int n) {
        long l = 0, r = n;

        while(l<=r){
            long k = l+(r-l)/2;
            long curr = k * (k+1)/2;

            if(curr == n) return (int)k;

            if(curr < n)
                l = k+1;
            else
                r = k-1;
        }

        return (int)r;
    }
}