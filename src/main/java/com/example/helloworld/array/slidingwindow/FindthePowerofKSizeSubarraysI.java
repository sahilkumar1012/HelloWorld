package com.example.helloworld.array.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * leetcode 3254. Find the Power of K-Size Subarrays I
 * Code Harmony Video Explanation: https://youtu.be/6YGPxyzwXqg
 *
 * You are given an array of integers nums of length n and a positive integer k.
 *
 * The power of an array is defined as:
 * - Its maximum element if all of its elements are consecutive and sorted in ascending order.
 * - -1 otherwise.
 *
 * You need to find the power of all subarrays of nums of size k.
 *
 * Return an integer array results of size n - k + 1, where results[i] is the power of nums[i..(i + k - 1)].
 *
 * Examples:
 * Input: nums = [1,2,3,4,3,2,5], k = 3
 * Output: [3,4,-1,-1,-1]
 *
 * Input: nums = [2,2,2,2,2], k = 4
 * Output: [-1,-1]
 *
 * Input: nums = [3,2,3,2,3,2], k = 2
 * Output: [-1,3,-1,3,-1]
 *
 * Constraints:
 * 1 <= n == nums.length <= 500
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= n
 */
public class FindthePowerofKSizeSubarraysI {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length; // Length of the input array
        int[] result = new int[n - k + 1]; // Array to store results for all subarrays of size k
        Deque<Integer> dq = new ArrayDeque<>(); // Deque to maintain indices of valid elements in the current window
        int idx = 0; // Index to track the position in the result array

        for (int i = 0; i < n; i++) {
            // Step 1: Remove elements from the deque that are outside the current window
            // These elements are no longer relevant for the current subarray of size k
            if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst(); // Remove the oldest element outside the window
            }

            // Step 2: Check for consecutive sorted order
            // If the current element is not consecutive to the last element in the deque,
            // clear the deque because the current window is invalid
            if (!dq.isEmpty() && nums[dq.peekLast()] + 1 != nums[i]) {
                dq.clear();
            }

            // Step 3: Add the current element's index to the deque
            // This maintains the indices of elements in the current valid window
            dq.offerLast(i);

            // Step 4: Process the window once its size reaches k
            if (i >= k - 1) {
                // If the deque size equals k, the window is valid and sorted
                // The result for this window is the maximum element (last element in deque)
                if (dq.size() == k) {
                    result[idx] = nums[dq.peekLast()];
                } else {
                    // Otherwise, the window is invalid, and the result is -1
                    result[idx] = -1;
                }

                // Move to the next position in the result array
                idx++;
            }
        }
        return result; // Return the array containing results for all k-size subarrays
    }
}
