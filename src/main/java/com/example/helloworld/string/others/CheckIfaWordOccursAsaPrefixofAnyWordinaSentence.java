package com.example.helloworld.string.others;

/**
 * leetcode 1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence , Easy ,String ,
 * Yelp Interview Question
 *
 * Code Harmony Video Explanation : https://youtu.be/HOvEFn5EVDA
 *
 * My LeetCode Solution : https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/solutions/6102397/3-easy-approaches-beats-100-detailed-video-explanation
 *
 * Given a sentence that consists of some words separated by a single space, and a searchWord, check if searchWord is a prefix of any word in sentence.
 *
 * Return the index of the word in sentence (1-indexed) where searchWord is a prefix of this word. If searchWord is a prefix of more than one word, return the index of the first word (minimum index). If there is no such word return -1.
 *
 * A prefix of a string s is any leading contiguous substring of s.
 *
 *
 *
 * Example 1:
 *
 * Input: sentence = "i love eating burger", searchWord = "burg"
 * Output: 4
 * Explanation: "burg" is prefix of "burger" which is the 4th word in the sentence.
 * Example 2:
 *
 * Input: sentence = "this problem is an easy problem", searchWord = "pro"
 * Output: 2
 * Explanation: "pro" is prefix of "problem" which is the 2nd and the 6th word in the sentence, but we return 2 as it's the minimal index.
 * Example 3:
 *
 * Input: sentence = "i am tired", searchWord = "you"
 * Output: -1
 * Explanation: "you" is not a prefix of any word in the sentence.
 *
 *
 * Constraints:
 *
 * 1 <= sentence.length <= 100
 * 1 <= searchWord.length <= 10
 * sentence consists of lowercase English letters and spaces.
 * searchWord consists of lowercase English letters.
 */
public class CheckIfaWordOccursAsaPrefixofAnyWordinaSentence {

    public int isPrefixOfWord(String sentence, String searchWord) {
        // Split the sentence into an array of words using space as a delimiter.
        String[] words = sentence.split(" ");

        int i = 0; // Initialize an index to track the position of each word in the sentence.
        for (String word : words) { // Iterate through each word in the array.
            // Check if the current word starts with the given searchWord.
            if (prefix(word, searchWord)) {
                return i + 1; // If it does, return the 1-based index of the word.
            }
            i++; // Increment the index for the next word.
        }

        return -1; // If no word matches, return -1 to indicate no match.
    }

    // Helper function to check if the word starts with the given prefix.
    private boolean prefix(String w, String p) {
        // If the prefix is longer than the word, it cannot be a prefix.
        if (p.length() > w.length()) return false;
        // Use the startsWith method to check if the word starts with the prefix.
        return w.startsWith(p);
    }
}
