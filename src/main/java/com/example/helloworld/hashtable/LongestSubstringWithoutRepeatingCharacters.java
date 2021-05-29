package com.example.helloworld.hashtable;

import java.util.HashSet;

/**
 * leetcode 3. Longest Substring Without Repeating Characters
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Example 4:
 *
 * Input: s = ""
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();

        int i=0, j=0;
        int maxLen = 0;

        int temp = 0;
        HashSet<Character> set = new HashSet<>();

        while(j < len){
            if( set.add( s.charAt(j) ) ){           // jab tak sahi se add ho rha hai kar do.
                if(maxLen < (j-i+1))
                    maxLen = j-i+1;
                j++;
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }

        return maxLen;
    }
}