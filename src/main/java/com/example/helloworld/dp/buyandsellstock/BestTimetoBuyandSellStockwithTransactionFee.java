package com.example.helloworld.dp.buyandsellstock;

/**
 * leetcode 714. Best Time to Buy and Sell Stock with Transaction Fee
 * reference video from pepcoding : https://youtu.be/pTQB9wbIpfU
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [1,3,2,8,4,9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * - Buying at prices[0] = 1
 * - Selling at prices[3] = 8
 * - Buying at prices[4] = 4
 * - Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * Example 2:
 *
 * Input: prices = [1,3,7,5,10,3], fee = 3
 * Output: 6
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 5 * 104
 * 1 <= prices[i] < 5 * 104
 * 0 <= fee < 5 * 104
 *
 */
public class BestTimetoBuyandSellStockwithTransactionFee {
    public static int maxProfit(int[] prices, int fee) {
        // old bought state and selling state profit
        int obsp = -prices[0];
        int ossp = 0;

        for(int i=0; i < prices.length; ++i){
            int nbsp, nssp;

            // either go with earlier bought state or buy at this point from older selling state.
            if(ossp - prices[i] > obsp){
                nbsp = ossp - prices[i];
            }else{
                nbsp = obsp;
            }

            // either go with older selling state profit or sell at this point from older buying state
            if(obsp + prices[i] - fee > ossp){
                nssp = obsp + prices[i] - fee;
            }else{
                nssp = ossp;
            }

            ossp = nssp;
            obsp = nbsp;
        }

        return ossp;
    }
}