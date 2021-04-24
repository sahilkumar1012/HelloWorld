package com.example.helloworld.dp;

/**
 leetcode problem 322. Coin Change

 video for reference : https://youtu.be/jgiZlGzXMBw
 

 You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

 Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

 You may assume that you have an infinite number of each kind of coin.



 Example 1:

 Input: coins = [1,2,5], amount = 11
 Output: 3
 Explanation: 11 = 5 + 5 + 1
 Example 2:

 Input: coins = [2], amount = 3
 Output: -1
 Example 3:

 Input: coins = [1], amount = 0
 Output: 0
 Example 4:

 Input: coins = [1], amount = 1
 Output: 1
 Example 5:

 Input: coins = [1], amount = 2
 Output: 2


 Constraints:

 1 <= coins.length <= 12
 1 <= coins[i] <= 231 - 1
 0 <= amount <= 104

 */
public class CoinChange {

    // https: //youtu.be/jgiZlGzXMBw video for reference.
    // bottom up dp
    public int coinChange(int[] c, int amt) {
        int dp[] = new int[amt+1]; // we need 0 coins for 0.

        for(int i=1; i<=amt; ++i){
            dp[i] = amt+1;

            for(int coin : c){

                if( i-coin >= 0){  // can use this coin?
                    if( dp[i-coin] + 1 < dp[i])
                        dp[i] = dp[i-coin] + 1;
                }
            }
        }
        if(dp[amt]==amt+1) // handle negative case.
            return -1;

        return dp[amt]; // result of all the subproblems.
    }
}
/**
 Test Cases to dry run code :

 [1,2,5]
 11
 [2]
 3
 [1]
 0
 [1]
 1
 [1]
 2
 [1,2147483647]
 2
 [186,419,83,408]
 6249
 [1,3,5,8]
 11
 **/
