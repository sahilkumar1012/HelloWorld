package com.example.helloworld.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Generating all the permutations of a given String.
 * took reference from tushar roy's video.
 *
 * asked in Adobe
 */
public class StringPermutations {
    private final char firstChar = 'A'; // whether string is small case of capital case.

    /**
     * main method, calling helper function using frequency array.
     * @param s input string
     * @return list of all the words formed using string permutations.
     */
    public List<String> getStringPermutations(String s){ // string of same case english letters
        int freq[] = new int[26];
        List<String> res = new ArrayList<>();

        for(char ch : s.toCharArray())
            freq[ch-firstChar]++;

        helper(freq,res,0,new char[s.length()]);
        return res;
    }

    /**
     * backtracking
     * @param freq frequency array of input string
     * @param res to store every result
     * @param idx depth of recursion stack
     * @param temp to store temp word formed using frequency array.
     */
    private void helper(int[] freq, List<String> res, int idx, char[] temp) {
        if (idx == temp.length){
            res.add(new String(temp));
            return;
        }
        for(int i=0; i<26; ++i){
            if(freq[i]==0) continue;

            temp[idx] = (char)(firstChar+i);
            freq[i]--;
            helper(freq, res, idx+1, temp);
            freq[i]++;
        }
    }

}
