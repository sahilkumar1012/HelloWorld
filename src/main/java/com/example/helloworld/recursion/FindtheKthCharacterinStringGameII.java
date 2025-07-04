package com.example.helloworld.recursion;

/**
 * leetcode 3307. Find the K-th Character in String Game II , Hard , follow up to 3304
 *
 * code harmony explanation video : https://youtu.be/ceVWHb2LgoU
 *
 *
 Alice and Bob are playing a game. Initially, Alice has a string word = "a".

 You are given a positive integer k. You are also given an integer array operations, where operations[i] represents the type of the ith operation.

 Now Bob will ask Alice to perform all operations in sequence:

 If operations[i] == 0, append a copy of word to itself.
 If operations[i] == 1, generate a new string by changing each character in word to its next character in the English alphabet, and append it to the original word. For example, performing the operation on "c" generates "cd" and performing the operation on "zb" generates "zbac".
 Return the value of the kth character in word after performing all the operations.

 Note that the character 'z' can be changed to 'a' in the second type of operation.



 Example 1:

 Input: k = 5, operations = [0,0,0]

 Output: "a"

 Explanation:

 Initially, word == "a". Alice performs the three operations as follows:

 Appends "a" to "a", word becomes "aa".
 Appends "aa" to "aa", word becomes "aaaa".
 Appends "aaaa" to "aaaa", word becomes "aaaaaaaa".
 Example 2:

 Input: k = 10, operations = [0,1,0,1]

 Output: "b"

 Explanation:

 Initially, word == "a". Alice performs the four operations as follows:

 Appends "a" to "a", word becomes "aa".
 Appends "bb" to "aa", word becomes "aabb".
 Appends "aabb" to "aabb", word becomes "aabbaabb".
 Appends "bbccbbcc" to "aabbaabb", word becomes "aabbaabbbbccbbcc".


 Constraints:

 1 <= k <= 1014
 1 <= operations.length <= 100
 operations[i] is either 0 or 1.
 The input is generated such that word has at least k characters after all operations.

 *
 *
 */
public class FindtheKthCharacterinStringGameII {
    public char kthCharacter(long k, int[] operations) {
        int steps = 0;
        while ((1L << steps) < k) {
            steps++;
        }

        return solve(steps, k, operations);
    }

    private char solve(int step, long k, int[] operations) {
        if (step == 0) {
            return 'a';
        }

        long half = 1L << (step - 1);
        int op = operations[step - 1];

        if (op == 0) {
            // Doubling: same content on both sides
            if (k <= half) {
                return solve(step - 1, k, operations);
            } else {
                return solve(step - 1, k - half, operations);
            }
        } else {
            // Shift append
            if (k <= half) {
                return solve(step - 1, k, operations);
            } else {
                char ch = solve(step - 1, k - half, operations);
                return (ch == 'z') ? 'a' : (char) (ch + 1);
            }
        }
    }
}
