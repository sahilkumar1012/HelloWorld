package com.example.helloworld.recursion;

/**
 * leetcode  3304. Find the K-th Character in String Game I , Bloomberg
 *
 * code harmony video explanation : https://youtu.be/vSEDu9QDXY8
 *
 * Alice and Bob are playing a game. Initially, Alice has a string word = "a".
 *
 * You are given a positive integer k.
 *
 * Now Bob will ask Alice to perform the following operation forever:
 *
 * Generate a new string by changing each character in word to its next character in the English alphabet, and append it to the original word.
 * For example, performing the operation on "c" generates "cd" and performing the operation on "zb" generates "zbac".
 *
 * Return the value of the kth character in word, after enough operations have been done for word to have at least k characters.
 *
 * Note that the character 'z' can be changed to 'a' in the operation.
 *
 *
 *
 * Example 1:
 *
 * Input: k = 5
 *
 * Output: "b"
 *
 * Explanation:
 *
 * Initially, word = "a". We need to do the operation three times:
 *
 * Generated string is "b", word becomes "ab".
 * Generated string is "bc", word becomes "abbc".
 * Generated string is "bccd", word becomes "abbcbccd".
 * Example 2:
 *
 * Input: k = 10
 *
 * Output: "c"
 *
 *
 *
 * Constraints:
 *
 * 1 <= k <= 500
 */
public class FindtheKthCharacterinStringGameI {

//    public char kthCharacterBruteForce(int k){
//        StringBuilder sb = new StringBuilder("a");
//
//        while (sb.length() < k) {
//            int len = sb.length();
//            for (int i = 0; i < len; i++) {
//                char c = sb.charAt(i);
//                sb.append((c == 'z') ? 'a' : (char)(c + 1));
//            }
//        }
//        return sb.charAt(k - 1);
//    }

    public char kthCharacter(int k) {
        int step = 0;
        while ((1 << step) <= k) {
            step++;
        }
        return getChar(step, k - 1);
    }

    private char getChar(int step, int index) {
        if (step == 0) return 'a';

        int half = 1 << (step - 1);
        if (index < half) {
            return getChar(step - 1, index);
        } else {
            char prev = getChar(step - 1, index - half);
            return (prev == 'z') ? 'a' : (char)(prev + 1);
        }
    }
}
