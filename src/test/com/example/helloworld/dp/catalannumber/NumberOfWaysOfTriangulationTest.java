package com.example.helloworld.dp.catalannumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfWaysOfTriangulationTest {

    @Test
    @DisplayName("NumberOfWaysOfTriangulation for pentagon and hexagon")
    void numberOfWaysOfTriangulation() {
        assertEquals( 14, NumberOfWaysOfTriangulation.numberOfWaysOfTriangulation(6) );
        assertEquals( 5, NumberOfWaysOfTriangulation.numberOfWaysOfTriangulation(5) );
    }
}