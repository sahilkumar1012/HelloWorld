package com.example.helloworld.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuyAndSellStockIITest {

    @Test
    /**
     * sample inputs :
     [7,1,5,3,6,4]
     [1,2,3,4,5]
     [7,6,4,3,1]

     sample outputs:
     7
     4
     0
     */
    void maxProfit() {
        int[] prices = new int[]{7,1,5,3,6,4};
        assertEquals(7, BestTimeToBuyAndSellStockII.maxProfit(prices));
    }
}