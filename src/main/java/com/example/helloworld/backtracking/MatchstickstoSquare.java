package com.example.helloworld.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * leetcode 473. Matchsticks to Square
 *
 * code harmony solution video :  https://youtu.be/fse9Krsi80A
 *
 *
 * You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
 *
 * Return true if you can make this square and false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matchsticks = [1,1,2,2,2]
 * Output: true
 * Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
 * Example 2:
 *
 * Input: matchsticks = [3,3,3,3,4]
 * Output: false
 * Explanation: You cannot find a way to form a square with all the matchsticks.
 *
 *
 * Constraints:
 *
 * 1 <= matchsticks.length <= 15
 * 1 <= matchsticks[i] <= 108
 */
public class MatchstickstoSquare {
    // Length of each side of the square
    int validEdgeLen;
    // List to store matchstick lengths
    List<Integer> list;

    public boolean makesquare(int[] matchsticks) {
        // Calculate the total sum of matchstick lengths
        int sum = 0;
        list = new ArrayList<>();

        // Populate the list and calculate the sum
        for (int i : matchsticks) {
            sum += i;
            list.add(i);
        }

        // If the total sum is not divisible by 4, it's impossible to form a square
        if (sum % 4 != 0) return false;

        // Calculate the length of each side of the square
        validEdgeLen = sum / 4;
        // Sort matchstick lengths in descending order for efficient backtracking
        Collections.sort(list, Collections.reverseOrder());

        // Perform backtracking to find if a square can be formed
        return sol(0, 0, 0, 0, 0);
    }

    /**
     * Recursive function to perform backtracking.
     * @param idx Index of the current matchstick being considered
     * @param s1 Length accumulated on side 1
     * @param s2 Length accumulated on side 2
     * @param s3 Length accumulated on side 3
     * @param s4 Length accumulated on side 4
     * @return True if a square can be formed, otherwise false
     */
    private boolean sol(int idx, int s1, int s2, int s3, int s4) {
        // If any side exceeds the valid edge length, return false
        if (
                s1 > validEdgeLen ||
                        s2 > validEdgeLen ||
                        s3 > validEdgeLen ||
                        s4 > validEdgeLen
        ) {
            return false;
        }

        // If all matchsticks have been used, check if all sides are of equal length
        if (idx == list.size()) {
            if (s1 == s2 && s2 == s3 && s3 == s4) {
                return true; // All sides are equal, a square can be formed
            }
            return false; // Unequal side lengths, cannot form a square
        }

        // Try adding the current matchstick to each side and recursively check
        if (
                sol(idx + 1, s1 + list.get(idx), s2, s3, s4) ||
                        sol(idx + 1, s1, s2 + list.get(idx), s3, s4) ||
                        sol(idx + 1, s1, s2, s3 + list.get(idx), s4) ||
                        sol(idx + 1, s1, s2, s3, s4 + list.get(idx))
        ) {
            return true; // A square can be formed
        }

        return false; // None of the combinations work
    }
}
