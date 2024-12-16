package com.example.helloworld.heap.easy;

import java.util.PriorityQueue;

/**
 * leetcode 3264 Final Array State After K Multiplication Operations I , Heap, Easy , Amazon
 *
 * Code Harmony Video Explanation : https://youtu.be/qZLmio7PXE0
 *
 * My LeetCode Solution : https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/solutions/6150698/easy-to-understand-100-heap-detailed-vid-ypzm/
 *
 * You are given an integer array nums, an integer k, and an integer multiplier.
 *
 * You need to perform k operations on nums. In each operation:
 *
 * Find the minimum value x in nums. If there are multiple occurrences of the minimum value, select the one that appears first.
 * Replace the selected minimum value x with x * multiplier.
 * Return an integer array denoting the final state of nums after performing all k operations.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,1,3,5,6], k = 5, multiplier = 2
 *
 * Output: [8,4,6,5,6]
 *
 * Explanation:
 *
 * Operation	Result
 * After operation 1	[2, 2, 3, 5, 6]
 * After operation 2	[4, 2, 3, 5, 6]
 * After operation 3	[4, 4, 3, 5, 6]
 * After operation 4	[4, 4, 6, 5, 6]
 * After operation 5	[8, 4, 6, 5, 6]
 * Example 2:
 *
 * Input: nums = [1,2], k = 3, multiplier = 4
 *
 * Output: [16,8]
 *
 * Explanation:
 *
 * Operation	Result
 * After operation 1	[4, 2]
 * After operation 2	[4, 8]
 * After operation 3	[16, 8]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * 1 <= k <= 10
 * 1 <= multiplier <= 5
 */
public class FinalArrayStateAfterKMultiplicationOperationsI {

    // This method modifies the array by multiplying the smallest elements k times with a given multiplier
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;

        // Priority queue to maintain elements in ascending order based on value,
        // with a tie-breaker based on their original index
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a[0] == b[0]) return a[1] - b[1]; // Compare indices if values are equal
                    return a[0] - b[0]; // Otherwise, compare based on values
                }
        );

        // Add all elements of nums along with their indices into the priority queue
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        // Perform the operation k times
        while (k-- > 0) {
            // Poll the smallest element from the queue
            int[] t = pq.poll();
            int v = t[0]; // Value of the smallest element
            int i = t[1]; // Index of the smallest element

            // Update the value in the original array by multiplying with the multiplier
            nums[i] = v * multiplier;

            // Push the updated value back into the priority queue
            pq.offer(new int[]{nums[i], i});
        }

        // Return the modified array
        return nums;
    }
}