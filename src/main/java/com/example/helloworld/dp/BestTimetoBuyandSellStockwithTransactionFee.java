package com.example.helloworld.dp;

public class BestTimetoBuyandSellStockwithTransactionFee {
    public static int maxProfit(int[] prices, int fee) {
        // old bought state and selling state profit
        int obsp = -prices[0];
        int ossp = 0;

        for(int i=0; i < prices.length; ++i){
            int nbsp, nssp;

            if(ossp - prices[i] > obsp){
                nbsp = ossp - prices[i];
            }else{
                nbsp = obsp;
            }

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