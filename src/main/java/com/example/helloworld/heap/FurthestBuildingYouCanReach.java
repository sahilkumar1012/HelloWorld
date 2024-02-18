package com.example.helloworld.heap;

import java.util.PriorityQueue;

/**
 * Solution for LeetCode problem 1642. Furthest Building You Can Reach
 *
 * Problem Statement:
 * You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.
 * You start your journey from building 0 and move to the next building by possibly using bricks or ladders.
 * While moving from building i to building i+1 (0-indexed),
 * - If the current building's height is greater than or equal to the next building's height,
 *   you do not need a ladder or bricks.
 * - If the current building's height is less than the next building's height,
 *   you can either use one ladder or (h[i+1] - h[i]) bricks.
 * Return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally.
 *
 * Example:
 * Input: heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
 * Output: 4
 * Explanation: Starting at building 0, you can follow these steps:
 * - Go to building 1 without using ladders nor bricks since 4 >= 2.
 * - Go to building 2 using 5 bricks. You must use either bricks or ladders because 2 < 7.
 * - Go to building 3 without using ladders nor bricks since 7 >= 6.
 * - Go to building 4 using your only ladder. You must use either bricks or ladders because 6 < 9.
 * It is impossible to go beyond building 4 because you do not have any more bricks or ladders.
 *
 * Approach:
 * This solution utilizes a priority queue to track the difference in heights between consecutive buildings.
 * We iterate through the heights, calculating the differences and adding them to the priority queue.
 * If we have ladders available, we use them for any height difference encountered.
 * Otherwise, we use bricks to cover the height difference, removing bricks from the available count if needed.
 * Once we cannot cover the height difference with the available resources, we return the index of the last building reached.
 *
 * Time Complexity: O(n log n) - As we iterate through the heights and utilize a priority queue.
 * Space Complexity: O(n) - The priority queue to store height differences.
 */
public class FurthestBuildingYouCanReach {

    /**
     * Finds the furthest building index reachable using the given bricks and ladders.
     *
     * @param heights Array representing heights of buildings
     * @param bricks  Available number of bricks
     * @param ladders Available number of ladders
     * @return The furthest building index reachable
     */
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        int[] diff = new int[n];

        // Calculate height differences between consecutive buildings
        for (int i = 1; i < n; i++) {
            diff[i] = heights[i] - heights[i - 1] < 0 ? 0 : heights[i] - heights[i - 1];
        }

        // Priority queue to store height differences
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            if (diff[i] == 0) {
                continue;
            }
            if (ladders > 0) {
                // If ladders available, use them
                ladders--;
                pq.add(diff[i]);
            } else {
                // If no ladders left, use bricks
                pq.add(diff[i]);
                int temp = pq.poll(); // Use bricks
                if (temp > bricks)
                    return i - 1; // Cannot proceed further
                else
                    bricks = bricks - temp; // Deduct used bricks
            }
        }
        return n - 1; // Reached the end
    }
}
