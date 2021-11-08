package com.example.helloworld.dp.catalannumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueBinarySearchTreesTest {

    @Test
    @DisplayName("Number of BSTs with 4 Nodes")
    void uniqueBinarySearchTrees() {
        assertEquals(14, UniqueBinarySearchTrees.uniqueBinarySearchTrees(4));
    }
}