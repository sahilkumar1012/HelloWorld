package com.example.helloworld.bitmanipulation.hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberofValidWordsforEachPuzzleTest {

    @Test
    /**
     * Sample inputs :
     ["aaaa","asas","able","ability","actt","actor","access"]
     ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
     ["apple","pleas","please"]
     ["aelwxyz","aelpxyz","aelpsxy","saelpxy","xaelpsy"]

     sample outputs :
     [1,1,3,2,4,0]
     [0,1,3,2,0]
     */
    void findNumOfValidWords() {
        String[] words = new String[]{"aaaa","asas","able","ability","actt","actor","access"};
        String[] puzzles = new String[]{"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
        assertEquals("[1, 1, 3, 2, 4, 0]", NumberofValidWordsforEachPuzzle.findNumOfValidWords(words, puzzles).toString());
    }
}