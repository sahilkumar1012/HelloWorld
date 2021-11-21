package com.example.helloworld.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestIncreasingSubsequenceLISTest {

    @Test
    void lengthOfLISd() {
        LongestIncreasingSubsequenceLIS lis = new LongestIncreasingSubsequenceLIS();
        assertEquals(4, lis.lengthOfLISd(new int[]{10,9,2,5,7,3,5,8}));
    }
}