package com.example.helloworld.dp;

/**
 * leetcode 518. Coin Change II ,
 * Coin Change Combinations
 * reference video link : https://youtu.be/l_nR5X9VmaI?list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy ( pepcoding )
 *
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * The answer is guaranteed to fit into a signed 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: amount = 5, coins = [1,2,5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * Example 2:
 *
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * Example 3:
 *
 * Input: amount = 10, coins = [10]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= coins.length <= 300
 * 1 <= coins[i] <= 5000
 * All the values of coins are unique.
 * 0 <= amount <= 5000
 */
public class CoinChangeII {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;

        for (int coin : coins) {     // take effect of coins one by one
            for (int j = coin; j <= amount; j++) {       // for all amount
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }

    // prepare a main function to test above code
    public static void main(String[] args) {
        CoinChangeII coinChangeII = new CoinChangeII();
        int[] coins = {1,2,5};
        int amount = 5;
        System.out.println(coinChangeII.change(amount, coins)); // 4
    }
}
