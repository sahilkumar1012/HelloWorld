package com.example.helloworld.dp.buyandsellstock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BestTimetoBuyandSellStockwithTransactionFeeTest {

    @Test
    /**
     sample inputs :
     [1,3,2,8,4,9]
     2
     [1,3,7,5,10,3]
     3

     sample outputs:
     8
     6
     */
    void maxProfit() {
        int[] prices = new int[]{1,3,2,8,4,9};
        Assertions.assertEquals(8, BestTimetoBuyandSellStockwithTransactionFee.maxProfit(prices, 2));
    }
}