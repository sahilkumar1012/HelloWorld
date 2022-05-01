package com.example.helloworld.stack;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * leetcode 484. Find Permutation , asked in Google, goldman sachs
 * reference video solution pepcoding : https://youtu.be/GOCbsY7Arw4?list=TLGGshJnuSN1R7YwMTA1MjAyMg
 *
 * A permutation perm of n integers of all the integers in the range [1, n] can be represented as a string s of length n - 1 where:
 *
 * s[i] == 'I' if perm[i] < perm[i + 1], and
 * s[i] == 'D' if perm[i] > perm[i + 1].
 * Given a string s, reconstruct the lexicographically smallest permutation perm and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "I"
 * Output: [1,2]
 * Explanation: [1,2] is the only legal permutation that can represented by s, where the number 1 and 2 construct an increasing relationship.
 * Example 2:
 *
 * Input: s = "DI"
 * Output: [2,1,3]
 * Explanation: Both [2,1,3] and [3,1,2] can be represented as "DI", but since we want to find the smallest lexicographical permutation, you should return [2,1,3]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is either 'I' or 'D'.
 *
 */
public class FindPermutation {
    public static int[] findPermutation(String s) {
        int n = s.length();
        int[] ans = new int[n + 1];

        Deque<Integer> stack = new ArrayDeque<>();

        int k = 1, idx = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'D') {
                stack.push(k++);
            } else {
                stack.push(k++);

                while (!stack.isEmpty()) {
                    ans[idx++] = stack.pop();
                }
            }
        }

        stack.push(k++);
        while (!stack.isEmpty()) {
            ans[idx++] = stack.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findPermutation("DI")));
    }
}
