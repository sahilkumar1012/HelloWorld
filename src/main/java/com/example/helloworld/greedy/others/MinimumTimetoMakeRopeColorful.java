package com.example.helloworld.greedy.others;

/***
 * leetcode 1578. Minimum Time to Make Rope Colorful
 * https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
 * Code Harmony solution video : https://youtu.be/qebJ3leOLw4
 *
 *
 * Alice has n balloons arranged on a rope. You are given a 0-indexed string colors where colors[i] is the color of the ith balloon.
 *
 * Alice wants the rope to be colorful. She does not want two consecutive balloons to be of the same color, so she asks Bob for help. Bob can remove some balloons from the rope to make it colorful. You are given a 0-indexed integer array neededTime where neededTime[i] is the time (in seconds) that Bob needs to remove the ith balloon from the rope.
 *
 * Return the minimum time Bob needs to make the rope colorful.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: colors = "abaac", neededTime = [1,2,3,4,5]
 * Output: 3
 * Explanation: In the above image, 'a' is blue, 'b' is red, and 'c' is green.
 * Bob can remove the blue balloon at index 2. This takes 3 seconds.
 * There are no longer two consecutive balloons of the same color. Total time = 3.
 * Example 2:
 *
 *
 * Input: colors = "abc", neededTime = [1,2,3]
 * Output: 0
 * Explanation: The rope is already colorful. Bob does not need to remove any balloons from the rope.
 * Example 3:
 *
 *
 * Input: colors = "aabaa", neededTime = [1,2,3,4,1]
 * Output: 2
 * Explanation: Bob will remove the ballons at indices 0 and 4. Each ballon takes 1 second to remove.
 * There are no longer two consecutive balloons of the same color. Total time = 1 + 1 = 2.
 *
 *
 * Constraints:
 *
 * n == colors.length == neededTime.length
 * 1 <= n <= 105
 * 1 <= neededTime[i] <= 104
 * colors contains only lowercase English letters.
 */

public class MinimumTimetoMakeRopeColorful {

    /**
     * Calculates the minimum time required to make the rope colorful by removing balloons.
     *
     * @param colors      A string representing the colors of the balloons on the rope.
     * @param neededTime  An integer array representing the time required to remove each balloon.
     * @return            The minimum time required to make the rope colorful.
     */
    public int minCost(String colors, int[] neededTime) {
        int ans = 0;          // Initialize the answer variable to 0.
        int i = 0, j = 0;     // Initialize two pointers i and j to traverse the 'neededTime' array.
        int n = neededTime.length; // Store the length of the 'neededTime' array for optimization.

        // Iterate over the 'neededTime' array until both pointers 'i' and 'j' reach the end.
        while (i < n && j < n) {
            int currSum = 0;     // Initialize the current sum to 0 for each new sequence of the same color.
            int currMax = 0;     // Initialize the maximum time required to remove a balloon in the current sequence to 0.

            // Continue traversing until the color at index 'i' and 'j' is the same.
            while (j < n && colors.charAt(i) == colors.charAt(j)) {
                currSum += neededTime[j];  // Add the time required to remove the balloon at index 'j' to the current sum.
                currMax = Math.max(currMax, neededTime[j]);  // Update the maximum time if required.
                j++;  // Move the pointer 'j' to the next index.
            }

            // Update the answer by subtracting the maximum time required in the current sequence from the sum.
            ans += (currSum - currMax);

            // Move the pointer 'i' to the current position of 'j' to continue checking the next sequence of colors.
            i = j;
        }

        // Return the minimum time required to make the rope colorful.
        return ans;
    }
}

