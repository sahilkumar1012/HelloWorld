package com.example.helloworld.array.twopointers;

/**
 * leetcode 2337 Move Pieces to Obtain a String, String, Two pointers , Google , Amazon interview question
 *
 * Code Harmony Video Explanation : https://youtu.be/7_i0_o_BUZw
 *
 * My LeetCode Solution : https://leetcode.com/problems/move-pieces-to-obtain-a-string/solutions/6114733/easy-to-understand-two-pointers-beats-100-detailed-video-explanation
 *
 *
 * You are given two strings start and target, both of length n. Each string consists only of the characters 'L', 'R', and '_' where:
 *
 * The characters 'L' and 'R' represent pieces, where a piece 'L' can move to the left only if there is a blank space directly to its left, and a piece 'R' can move to the right only if there is a blank space directly to its right.
 * The character '_' represents a blank space that can be occupied by any of the 'L' or 'R' pieces.
 * Return true if it is possible to obtain the string target by moving the pieces of the string start any number of times. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: start = "_L__R__R_", target = "L______RR"
 * Output: true
 * Explanation: We can obtain the string target from start by doing the following moves:
 * - Move the first piece one step to the left, start becomes equal to "L___R__R_".
 * - Move the last piece one step to the right, start becomes equal to "L___R___R".
 * - Move the second piece three steps to the right, start becomes equal to "L______RR".
 * Since it is possible to get the string target from start, we return true.
 * Example 2:
 *
 * Input: start = "R_L_", target = "__LR"
 * Output: false
 * Explanation: The 'R' piece in the string start can move one step to the right to obtain "_RL_".
 * After that, no pieces can move anymore, so it is impossible to obtain the string target from start.
 * Example 3:
 *
 * Input: start = "_R", target = "R_"
 * Output: false
 * Explanation: The piece in the string start can move only to the right, so it is impossible to obtain the string target from start.
 *
 *
 * Constraints:
 *
 * n == start.length == target.length
 * 1 <= n <= 105
 * start and target consist of the characters 'L', 'R', and '_'.
 */
public class MovePiecestoObtainaString {
    public boolean canChange(String start, String target) {
        int i = 0, j = 0;
        int n = start.length(), m = target.length();

        // Traverse both strings using two pointers
        while (i < n && j < m) {
            char a = start.charAt(i);
            char b = target.charAt(j);

            // Skip underscores ('_') in both strings
            if (a == '_' && b == '_') {
                i++;
                j++;
            }
            // Skip underscores in the `start` string
            else if (a == '_') {
                i++;
            }
            // Skip underscores in the `target` string
            else if (b == '_') {
                j++;
            }
            // If characters match, ensure valid movement
            else if (
                    a == b && // Characters must match
                            (
                                    (a == 'L' && i >= j) || // 'L' can only move left
                                            (a == 'R' && i <= j)    // 'R' can only move right
                            )
            ) {
                i++;
                j++;
            }
            // If none of the above conditions are satisfied, return false
            else {
                return false;
            }
        }

        // Skip remaining underscores in the `start` string
        while (i < n && start.charAt(i) == '_') {
            i++;
        }

        // Skip remaining underscores in the `target` string
        while (j < m && target.charAt(j) == '_') {
            j++;
        }

        // Both pointers must reach the end for a valid transformation
        return i == n && j == m;
    }
}
