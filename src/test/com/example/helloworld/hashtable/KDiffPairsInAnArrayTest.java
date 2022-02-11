package com.example.helloworld.hashtable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KDiffPairsInAnArrayTest {

    @Test
    void findPairsUsingHashing() {
        KDiffPairsInAnArray obj = new KDiffPairsInAnArray();
        int nums[] = {3,1,4,1,5};
        Integer actual = obj.findPairsUsingHashing(nums, 2);
        assertEquals(actual,2);
    }
}