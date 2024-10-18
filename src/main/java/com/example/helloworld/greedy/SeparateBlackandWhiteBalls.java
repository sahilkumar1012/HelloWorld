package com.example.helloworld.greedy;

/**
 * Leetcode 2938. Separate Black and White Balls
 *
 * Problem Statement:
 *
 * You are given a binary string `s` where '1' represents a black ball and '0' represents a white ball.
 * The task is to group all the black balls to the right side of the string, and all the white balls to the left side.
 *
 * In each move, you can swap two adjacent balls.
 * The goal is to find the minimum number of swaps needed to achieve this arrangement.
 *
 * Example 1:
 * Input: s = "101"
 * Output: 1
 * Explanation: We can group all the black balls to the right in the following way:
 * - Swap the first and second elements: s = "011". Now the black balls ('1') are grouped to the right.
 *
 * Example 2:
 * Input: s = "100"
 * Output: 2
 * Explanation: We need two swaps:
 * - Swap the first and second elements: s = "010".
 * - Swap the second and third elements: s = "001". Now the black balls are grouped to the right.
 *
 * Example 3:
 * Input: s = "0111"
 * Output: 0
 * Explanation: All black balls are already on the right side, so no swaps are needed.
 *
 * Constraints:
 * 1 <= n == s.length <= 105
 * s[i] is either '0' or '1'.
 */
public class SeparateBlackandWhiteBalls {

    /**
     * This method calculates the minimum number of steps (swaps) required to group all black balls ('1')
     * to the right and all white balls ('0') to the left.
     *
     * @param s - the binary string representing the arrangement of balls
     * @return long - the minimum number of swaps required
     */
    public long minimumSteps(String s) {
        long ans = 0;  // This will store the total number of swaps needed
        int ones = 0;  // This will count the number of black balls ('1') encountered so far

        // Traverse the string character by character
        for(char ch : s.toCharArray()) {
            if (ch == '0') {
                // If we encounter a white ball ('0'), all the black balls ('1') seen so far
                // need to be swapped past this white ball to move them to the right.
                ans += ones;  // Add the number of '1's encountered so far to the total swap count
            } else {
                // If we encounter a black ball ('1'), simply increment the count of black balls
                ones++;
            }
        }

        // After the loop finishes, 'ans' will hold the minimum number of swaps required
        return ans;
    }
}
