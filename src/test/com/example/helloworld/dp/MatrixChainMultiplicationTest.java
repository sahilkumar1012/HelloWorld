package com.example.helloworld.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixChainMultiplicationTest {

    @Test
    void mcm() {
        assertEquals(6, MatrixChainMultiplication.matrixChainMultiplication(new int[]{1, 2, 3}));
        assertEquals(18, MatrixChainMultiplication.matrixChainMultiplication(new int[]{1, 2, 3, 4}));
    }
}