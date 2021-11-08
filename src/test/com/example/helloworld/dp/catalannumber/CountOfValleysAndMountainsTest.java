package com.example.helloworld.dp.catalannumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountOfValleysAndMountainsTest {

    @Test
    @DisplayName("Testing CountOfValleysAndMountainsTest with 4 pairs of upstroke and downstrokes")
    public void test(){
        assertEquals(14, CountOfValleysAndMountains.countOfValleysAndMountains(4)); // 4 pairs of upstrokes and down strokes
    }
}