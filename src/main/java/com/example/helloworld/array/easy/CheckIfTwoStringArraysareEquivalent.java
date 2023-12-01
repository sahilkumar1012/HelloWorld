package com.example.helloworld.array.easy;

/**
 * leetcode 1662. Check If Two String Arrays are Equivalent
 * https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
 *
 * Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
 *
 * A string is represented by an array if the array elements concatenated in order forms the string.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
 * Output: true
 * Explanation:
 * word1 represents string "ab" + "c" -> "abc"
 * word2 represents string "a" + "bc" -> "abc"
 * The strings are the same, so return true.
 * Example 2:
 *
 * Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
 * Output: false
 * Example 3:
 *
 * Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= word1.length, word2.length <= 103
 * 1 <= word1[i].length, word2[i].length <= 103
 * 1 <= sum(word1[i].length), sum(word2[i].length) <= 103
 * word1[i] and word2[i] consist of lowercase letters.
 *
 */
public class CheckIfTwoStringArraysareEquivalent {

    // concatenate and compare
    public boolean arrayStringsAreEqualWithSpace(String[] word1, String[] word2) {
        StringBuilder first = new StringBuilder(), second = new StringBuilder();
        for(String s : word1){
            first.append(s);
        }
        for(String s : word2){
            second.append(s);
        }

        return first.compareTo(second) == 0;
    }

    // without using any extra space
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // word pointers to point to the current word, string pointer to point the corresponding index in curr word.
        int wp1 = 0, wp2 = 0;
        int sp1 = 0, sp2 = 0;

        while(wp1 < word1.length && wp2 < word2.length){
            if(word1[wp1].charAt(sp1) != word2[wp2].charAt(sp2)){
                return false;
            }
            sp1 ++;
            sp2 ++;

            if(sp1 == word1[wp1].length()){
                wp1++;
                sp1 = 0;
            }
            if(sp2 == word2[wp2].length()){
                wp2 ++;
                sp2 = 0;
            }
        }

        return wp1 == word1.length && wp2 == word2.length;      // any one word pointer has crossed the limit.
    }

    // write main to test arrayStringsAreEqual function
    public static void main(String[] args) {
        String[] word1 = {"ab", "c"}, word2 = {"a", "bcd"};
        CheckIfTwoStringArraysareEquivalent obj = new CheckIfTwoStringArraysareEquivalent();
        System.out.println(obj.arrayStringsAreEqual(word1, word2));
    }
}
