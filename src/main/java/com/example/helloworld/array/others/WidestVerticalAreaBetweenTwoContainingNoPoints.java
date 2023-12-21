package com.example.helloworld.array.others;

import java.util.Arrays;

/**
 * leetcode 1637. Widest Vertical Area Between Two Points Containing No Points
 * LeetCode problem link: https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/
 *
 * Given n points on a 2D plane where points[i] = [xi, yi], Return the widest vertical area between two points such that no points are inside the area.
 *
 * A vertical area is an area of fixed-width extending infinitely along the y-axis (i.e., infinite height). The widest vertical area is the one with the maximum width.
 *
 * Note that points on the edge of a vertical area are not considered included in the area.
 *
 *
 *
 * Example 1:
 *
 * ​
 * Input: points = [[8,7],[9,9],[7,4],[9,7]]
 * Output: 1
 * Explanation: Both the red and the blue area are optimal.
 * Example 2:
 *
 * Input: points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
 * Output: 3
 *
 *
 * Constraints:
 *
 * n == points.length
 * 2 <= n <= 105
 * points[i].length == 2
 * 0 <= xi, yi <= 109
 */
public class WidestVerticalAreaBetweenTwoContainingNoPoints {
    public int maxWidthOfVerticalArea(int[][] points) {
        // Step 1: Sort the points array based on the x-coordinate (a[0]) using a lambda comparator.
        Arrays.sort(points,
                (a, b) -> {
                    return a[0] - b[0];
                });

        // Step 2: Initialize a variable 'ans' to keep track of the maximum width.
        int ans = 0;

        // Step 3: Iterate through the sorted points array to find the maximum difference between consecutive x-coordinates.
        for (int i = 1; i < points.length; i++) {
            // Calculate the difference between the current x-coordinate and the previous x-coordinate.
            int currentWidth = points[i][0] - points[i - 1][0];

            // Update 'ans' with the maximum of its current value and the calculated width.
            ans = Math.max(ans, currentWidth);
        }

        // Step 4: Return the maximum width found.
        return ans;
    }

}
