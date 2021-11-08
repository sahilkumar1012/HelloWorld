package com.example.helloworld.dp.catalannumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatalanNumberTest {

    @Test
    @DisplayName("Testing 3rd catalan number")
    void find3rdCatalanNumber() {
        int actual = CatalanNumber.findNthCatalanNumber(3);
        assertEquals(5, actual);
    }

    @Test
    @DisplayName("Testing 1st catalan number")
    void find1stCatalanNumber(){
        assertEquals(1, CatalanNumber.findNthCatalanNumber(1));
    }

}