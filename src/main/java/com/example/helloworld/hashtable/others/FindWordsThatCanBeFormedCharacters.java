package com.example.helloworld.hashtable.others;

/**
 * leetcode 1160. Find Words That Can Be Formed by Characters
 * https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
 *
 * You are given an array of strings words and a string chars.
 *
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 *
 * Return the sum of lengths of all good strings in words.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation: The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 * Example 2:
 *
 * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * Output: 10
 * Explanation: The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * words[i] and chars consist of lowercase English letters.
 */
public class FindWordsThatCanBeFormedCharacters {
    public int countCharacters(String[] words, String chars) {
        int[] count = new int[26];
        for(char ch : chars.toCharArray())
            count[ch - 'a']++;

        int ans = 0;
        for(String word : words){
            int[] freq = new int[26];
            for(char ch : word.toCharArray())
                freq[ch-'a']++;

            boolean good = true;
            for(int i=0; i<26; i++){        // can we achieve this word by given characters ( chars string )
                if(freq[i] > count[i]){
                    good = false; break;
                }
            }

            if(good)
                ans += word.length();
        }

        return ans;
    }
}
