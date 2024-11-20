package com.example.helloworld.array.slidingwindow;

/**
 * leetcode 2516. Take K of Each Character From Left and Right
 * Code harmony video explanation :
 *
 * You are given a string s consisting of the characters 'a', 'b', and 'c' and a non-negative integer k. Each minute, you may take either the leftmost character of s, or the rightmost character of s.
 *
 * Return the minimum number of minutes needed for you to take at least k of each character, or return -1 if it is not possible to take k of each character.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aabaaaacaabc", k = 2
 * Output: 8
 * Explanation:
 * Take three characters from the left of s. You now have two 'a' characters, and one 'b' character.
 * Take five characters from the right of s. You now have four 'a' characters, two 'b' characters, and two 'c' characters.
 * A total of 3 + 5 = 8 minutes is needed.
 * It can be proven that 8 is the minimum number of minutes needed.
 * Example 2:
 *
 * Input: s = "a", k = 1
 * Output: -1
 * Explanation: It is not possible to take one 'b' or 'c' so return -1.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of only the letters 'a', 'b', and 'c'.
 * 0 <= k <= s.length
 */
public class TakeKofEachCharacterFromLeftandRight {
    int k;
    public int takeCharacters(String s, int k) {
        this.k = k;
        int[] count = new int[3];
        for(char ch : s.toCharArray()){     // store actual count of a,b,c
            count[ch-'a']++;
        }
        if(!valid(count)) return -1;

        // I definitely have answer now.

        int begin = 0, end = 0;
        int max = -1; // max len invalid window
        while(end < s.length()){
            char ch = s.charAt(end);
            count[ch-'a']--;

            // shrink by discarding invalid letters in this window.
            while(!valid(count) && begin<=end){
                count[s.charAt(begin)-'a']++;
                begin++;
            }

            max = Math.max(max, end-begin+1 );
            end++;
        }
        return s.length() - max;
    }

    private boolean valid(int[] count){
        for(int i : count){     // negative case.
            if(i < k) return false;
        }
        return true;
    }

}
