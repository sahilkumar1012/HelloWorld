package com.example.helloworld.slidingwindow;

/**
 * leetcode 3208. Alternating Groups II ,
 *
 * code harmony video explanation :https://youtu.be/51E6hoWVigo
 *
 * my leetcode solution: https://leetcode.com/problems/alternating-groups-ii/solutions/6516748/easy-to-understand-fixed-sliding-window-detailed-video-explanation
 *
 * There is a circle of red and blue tiles. You are given an array of integers colors and an integer k. The color of tile i is represented by colors[i]:
 *
 * colors[i] == 0 means that tile i is red.
 * colors[i] == 1 means that tile i is blue.
 * An alternating group is every k contiguous tiles in the circle with alternating colors (each tile in the group except the first and last one has a different color from its left and right tiles).
 *
 * Return the number of alternating groups.
 *
 * Note that since colors represents a circle, the first and the last tiles are considered to be next to each other.
 *
 *
 *
 * Example 1:
 *
 * Input: colors = [0,1,0,1,0], k = 3
 *
 * Output: 3
 *
 * Explanation:
 *
 *
 *
 * Alternating groups:
 *
 *
 *
 * Example 2:
 *
 * Input: colors = [0,1,0,0,1,0,1], k = 6
 *
 * Output: 2
 *
 * Explanation:
 *
 *
 *
 * Alternating groups:
 *
 *
 *
 * Example 3:
 *
 * Input: colors = [1,1,0,1], k = 4
 *
 * Output: 0
 *
 * Explanation:
 *
 *
 *
 *
 *
 * Constraints:
 *
 * 3 <= colors.length <= 105
 * 0 <= colors[i] <= 1
 * 3 <= k <= colors.length
 */
public class AlternatingGroupsII {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        // Extend the colors array to handle the circular nature
        int[] extended = new int[colors.length + k - 1];

        // Copy the original colors array into the extended array
        for (int i = 0; i < colors.length; i++) {
            extended[i] = colors[i];
        }

        // Append the first (k - 1) elements to the end to simulate circular behavior
        for (int i = 0; i < k - 1; i++) {
            extended[colors.length + i] = colors[i];
        }

        int n = extended.length; // New extended array size
        int i = 0, j = 0; // Two pointers for the sliding window
        int ans = 0; // Counter for the alternating groups

        while (j < n - 1) {
            // If two consecutive tiles have the same color, reset the window
            if (extended[j] == extended[j + 1]) {
                j = j + 1;
                i = j;
                continue;
            }
            j++; // Expand the window

            // If window size is smaller than k, continue expanding
            if (j - i + 1 < k) continue;

            // Valid alternating group found, increment the count
            ans++;
            i++; // Slide the window forward
        }

        return ans; // Return total count of alternating groups
    }

}
