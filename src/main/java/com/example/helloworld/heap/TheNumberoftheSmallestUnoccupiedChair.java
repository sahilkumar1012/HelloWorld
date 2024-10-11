package com.example.helloworld.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * leetcode 1942. The Number of the Smallest Unoccupied Chair
 *
 * There is a party where n friends numbered from 0 to n - 1 are attending. There is an infinite number of chairs in this party that are numbered from 0 to infinity. When a friend arrives at the party, they sit on the unoccupied chair with the smallest number.
 *
 * For example, if chairs 0, 1, and 5 are occupied when a friend comes, they will sit on chair number 2.
 * When a friend leaves the party, their chair becomes unoccupied at the moment they leave. If another friend arrives at that same moment, they can sit in that chair.
 *
 * You are given a 0-indexed 2D integer array times where times[i] = [arrivali, leavingi], indicating the arrival and leaving times of the ith friend respectively, and an integer targetFriend. All arrival times are distinct.
 *
 * Return the chair number that the friend numbered targetFriend will sit on.
 *
 *
 *
 * Example 1:
 *
 * Input: times = [[1,4],[2,3],[4,6]], targetFriend = 1
 * Output: 1
 * Explanation:
 * - Friend 0 arrives at time 1 and sits on chair 0.
 * - Friend 1 arrives at time 2 and sits on chair 1.
 * - Friend 1 leaves at time 3 and chair 1 becomes empty.
 * - Friend 0 leaves at time 4 and chair 0 becomes empty.
 * - Friend 2 arrives at time 4 and sits on chair 0.
 * Since friend 1 sat on chair 1, we return 1.
 * Example 2:
 *
 * Input: times = [[3,10],[1,5],[2,6]], targetFriend = 0
 * Output: 2
 * Explanation:
 * - Friend 1 arrives at time 1 and sits on chair 0.
 * - Friend 2 arrives at time 2 and sits on chair 1.
 * - Friend 0 arrives at time 3 and sits on chair 2.
 * - Friend 1 leaves at time 5 and chair 0 becomes empty.
 * - Friend 2 leaves at time 6 and chair 1 becomes empty.
 * - Friend 0 leaves at time 10 and chair 2 becomes empty.
 * Since friend 0 sat on chair 2, we return 2.
 *
 *
 * Constraints:
 *
 * n == times.length
 * 2 <= n <= 104
 * times[i].length == 2
 * 1 <= arrivali < leavingi <= 105
 * 0 <= targetFriend <= n - 1
 * Each arrivali time is distinct.
 */
public class TheNumberoftheSmallestUnoccupiedChair {
    // This method finds the chair number the targetFriend will sit on
    public int smallestChair(int[][] times, int targetFriend) {

        // Step 1: Get the arrival time of the target friend, so we can track it later
        int arrivalTime = times[targetFriend][0];  // Keep track of the target friend's arrival time

        // Step 2: Sort the times array by arrival times to simulate friends arriving in order
        Arrays.sort(times, Comparator.comparingInt(a -> a[0]));

        // Step 3: Priority queue to track which chairs become available when a friend leaves
        // pq1 stores [leaving time, chair number] pairs and orders them by leaving time (so we know which chair frees up next)
        PriorityQueue<int[]> pq1 = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[0])); // Sort by the first element (leaving time)

        // Step 4: Counter to keep track of the next available chair number if no chairs are free
        int counter = -1; // Counter keeps track of the next new chair

        // Step 5: Priority queue to store available chair numbers when friends leave
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(); // pq2 stores available chair numbers sorted by chair id

        // Step 6: Iterate over the sorted times array (simulating friends arriving in order)
        for (int[] time : times) {
            // Step 7: Free up chairs of friends who have already left before the current friend's arrival
            // Poll from pq1 (leaving time priority queue) and add freed chairs to pq2 (available chair queue)
            while (!pq1.isEmpty() && pq1.peek()[0] <= time[0]) {
                pq2.offer(pq1.poll()[1]); // Offer the chair to pq2, making it available
            }

            // Step 8: Assign a chair to the current arriving friend
            // If there are available chairs in pq2, assign the smallest one; otherwise, use a new chair
            int chair = pq2.isEmpty() ? ++counter : pq2.poll(); // Get the smallest available chair or increment the counter

            // Step 9: Add the current friend's leaving time and chair to pq1 for tracking
            pq1.offer(new int[]{time[1], chair}); // Add the friend's leaving time and the chair they occupied

            // Step 10: If the current friend is the target friend, return their chair number
            if (arrivalTime == time[0]) return chair; // If this is the target friend, return the chair they got
        }

        // Step 11: If no chair is found (which shouldn't happen with valid input), return -1
        return -1;
    }

}
