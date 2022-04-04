package com.example.helloworld.backtracking.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * leetcode 1087. Brace Expansion
 *
 * You are given a string s representing a list of words. Each letter in the word has one or more options.
 *
 * If there is one option, the letter is represented as is.
 * If there is more than one option, then curly braces delimit the options. For example, "{a,b,c}" represents options ["a", "b", "c"].
 * For example, if s = "a{b,c}", the first character is always 'a', but the second character can be 'b' or 'c'. The original list is ["ab", "ac"].
 *
 * Return all words that can be formed in this manner, sorted in lexicographical order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "{a,b}c{d,e}f"
 * Output: ["acdf","acef","bcdf","bcef"]
 * Example 2:
 *
 * Input: s = "abcd"
 * Output: ["abcd"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 50
 * s consists of curly brackets '{}', commas ',', and lowercase English letters.
 * s is guaranteed to be a valid input.
 * There are no nested curly brackets.
 * All characters inside a pair of consecutive opening and ending curly brackets are different.
 */
public class BraceExpansion {
        public String[] expand(String s) {
            return findAllWords(s,0);
        }
        private String[] findAllWords(String s, int startPos){
            if(startPos == s.length())
                return new String[]{""};

            List<Character> firstOptions = new ArrayList<>();
            int remStringStartPos = storeFirstOptions(s, startPos, firstOptions);
            String[] wordsWithRemString = findAllWords(s, remStringStartPos);

            List<String> expandedWords = new ArrayList<>();
            for(Character c : firstOptions){
                for(String word : wordsWithRemString){
                    expandedWords.add(c + word);
                }
            }
            return expandedWords.toArray(new String[0]);
        }

        int storeFirstOptions(String s, int startPos, List<Character> firstOptions){
            if(s.charAt(startPos) != '{'){
                firstOptions.add(s.charAt(startPos));
            }else{
                while (s.charAt(startPos) != '}') {
                    if (s.charAt(startPos) >= 'a' && s.charAt(startPos) <= 'z') {
                        firstOptions.add(s.charAt(startPos));
                    }
                    startPos++;
                }
                Collections.sort(firstOptions);
            }
            return startPos + 1;
        }
    }