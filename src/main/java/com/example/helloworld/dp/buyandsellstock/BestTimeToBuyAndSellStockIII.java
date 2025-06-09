package com.example.helloworld.dp.buyandsellstock;

/**
 * leetcode : 123. Best Time to Buy and Sell Stock III
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 *
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * Example 4:
 *
 * Input: prices = [1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 105
 */
public class BestTimeToBuyAndSellStockIII {
    // reference from pepcoding's video
    // https://youtu.be/wuzTpONbd-0

    public int maxProfit(int[] arr) {
        int n = arr.length;

        // max profit if mandatory to sell today or max profit achieved so far
        int mpist = 0;
        int leastsf = arr[0];
        int[] dpl = new int[n];

        for(int i=1; i<n; i++){
            if(arr[i] < leastsf)
                leastsf = arr[i];

            mpist = arr[i] - leastsf;
            if(mpist > dpl[i-1]){
                dpl[i] = mpist;
            }else{
                dpl[i] = dpl[i-1];
            }
        }

        // max profit if mandatory to buy today or max profit achieved after this point
        int mpibt = 0;
        int maxat = arr[n-1]; // max after today
        int dpr[] = new int[n];

        for(int i=n-2; i>=0; i--){
            if(arr[i] > maxat)
                maxat = arr[i];
            mpibt = maxat - arr[i];
            if(mpibt > dpr[i+1]){
                dpr[i] = mpibt;
            }else{
                dpr[i] = dpr[i+1];
            }
        }

        // Now at every index we've (best transaction at left + best transaction at right) jispe best hoga vo ans hai
        int op = 0;
        for(int i=0; i<n; ++i){
            op = Math.max(op, dpl[i] + dpr[i]);
        }
        return op;
    }
}
