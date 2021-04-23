package com.example.helloworld.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 1079. Letter Tile Possibilities
 * https://leetcode.com/problems/letter-tile-possibilities/
 * Solution of the above problem.
 * If you don't get this, take reference from Tushar roy's video
 * https://www.youtube.com/watch?v=xTNFs5KRV_g
 *
 */
public class LetterTilePossibilities {
    private final char firstChar = 'A';

    /**
     * call helper function with frequency array to get all the subset's permutations of given string..
     * @param s input string with same case characters
     * @return list of all the words which can be formed with string letter combinations
     */
    public List<String> getStringSubsetsPermutations(String s){ // string of same case english letters
        int[] freq = new int[26];
        List<String> res = new ArrayList<>();

        for(char ch : s.toCharArray())
            freq[ch-firstChar]++;

        helper(freq,res,0,new char[s.length()]);
        return res;
    }

    /**
    @param word will store temporary word and at every moment we'll add this into our result array
     */
    private void helper(int[] freq, List<String> res, int idx, char[] word) {
        if (idx == word.length)
            return;

        for(int i=0; i<26; ++i){
            if(freq[i]==0) continue;

            word[idx] = (char)(firstChar+i);
            freq[i]--;
            res.add(getValue(word,idx));
            helper(freq, res, idx+1, word);
            freq[i]++;
        }
    }

    /**
     * create word from temp char array till idx index.
     * @param temp temp array which was used to store word
     * @param idx till what index we need to form string word from temp array
     * @return word.
     */
    private String getValue(char[] temp, int idx) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<=idx; ++i){
            sb.append(temp[i]);
        }
        return sb.toString();
    }

}
