package com.example.helloworld.array.slidingwindow.hard;

import java.util.PriorityQueue;

/**
 * leetcode 862. Shortest Subarray with Sum at Least K
 *
 * Code Harmony Video Explanation : https://youtu.be/PemOgnbWeH4
 *
 * Given an integer array nums and an integer k, return the length of the shortest non-empty subarray of nums with a sum of at least k. If there is no such subarray, return -1.
 *
 * A subarray is a contiguous part of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1], k = 1
 * Output: 1
 * Example 2:
 *
 * Input: nums = [1,2], k = 4
 * Output: -1
 * Example 3:
 *
 * Input: nums = [2,-1,2], k = 3
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -105 <= nums[i] <= 105
 * 1 <= k <= 109
 */
public class ShortestSubarraywithSumatLeastK {

    // Helper class to store prefix sum and corresponding index.
    static class Value {
        long ps;  // Prefix sum at this point
        int idx;  // Index in the array

        public Value(long ps, int idx) {
            this.ps = ps;
            this.idx = idx;
        }
    }

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE; // Initialize the answer with a large value
        long csum = 0; // Cumulative sum to store the running sum of elements

        // Priority queue to maintain the smallest prefix sums and their indices.
        // The queue is sorted by the prefix sum values.
        PriorityQueue<Value> pq = new PriorityQueue<Value>(
                (a, b) -> Long.compare(a.ps, b.ps)
        );

        // Traverse the array
        for (int i = 0; i < n; i++) {
            csum += nums[i]; // Update the cumulative sum with the current element

            // If the cumulative sum itself is greater than or equal to `k`,
            // the subarray from the start to this index satisfies the condition.
            if (csum >= k) {
                ans = Math.min(ans, i + 1); // Update the answer with the subarray length
            }

            // Remove elements from the queue whose prefix sum satisfies the condition
            // for the current cumulative sum. The difference `csum - pq.peek().ps` >= `k`
            // indicates that we have found a valid subarray.
            while (!pq.isEmpty() && csum - pq.peek().ps >= k) {
                Value piece = pq.poll(); // Remove the element with the smallest prefix sum
                ans = Math.min(ans, i - piece.idx); // Update the answer with the subarray length
            }

            // Add the current cumulative sum and its index to the queue.
            pq.offer(new Value(csum, i));
        }

        // If no valid subarray was found, return -1
        if (ans == Integer.MAX_VALUE) return -1;

        // Return the length of the shortest valid subarray
        return ans;
    }
}
