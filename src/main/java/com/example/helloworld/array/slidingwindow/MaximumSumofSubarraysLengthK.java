package com.example.helloworld.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 2461. Maximum Sum of Distinct Subarrays With Length K
 * Code Harmony Video Explanation: https://youtu.be/FLF1vff8hEc
 *
 * You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:
 *
 * The length of the subarray is k, and
 * All the elements of the subarray are distinct.
 * Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,5,4,2,9,9,9], k = 3
 * Output: 15
 * Explanation: The subarrays of nums with length 3 are:
 * - [1,5,4] which meets the requirements and has a sum of 10.
 * - [5,4,2] which meets the requirements and has a sum of 11.
 * - [4,2,9] which meets the requirements and has a sum of 15.
 * - [2,9,9] which does not meet the requirements because the element 9 is repeated.
 * - [9,9,9] which does not meet the requirements because the element 9 is repeated.
 * We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions
 * Example 2:
 *
 * Input: nums = [4,4,4], k = 3
 * Output: 0
 * Explanation: The subarrays of nums with length 3 are:
 * - [4,4,4] which does not meet the requirements because the element 4 is repeated.
 * We return 0 because no subarrays meet the conditions.
 *
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 105
 * 1 <= nums[i] <= 105
 *
 */
public class MaximumSumofSubarraysLengthK {

    /**
     * Finds the maximum sum of subarrays of length k, where all elements in the subarray are distinct.
     *
     * @param nums The input integer array.
     * @param k    The length of the subarray.
     * @return The maximum sum of all valid subarrays, or 0 if no valid subarray exists.
     */
    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0; // Stores the maximum sum found so far.
        long cs = 0; // Current sum of the sliding window.
        int begin = 0, end = 0; // Pointers for the sliding window's start and end.
        Map<Integer, Integer> lastseen = new HashMap<>(); // Tracks the last occurrence of each number.

        // Traverse the array using the sliding window technique.
        while (end < nums.length) {
            int curr = nums[end]; // Current element at the end of the window.
            int j = lastseen.getOrDefault(curr, -1); // Get the last occurrence of the current element.

            // Shrink the window if:
            // 1. The current element was seen within the current window (duplicate found).
            // 2. The window size exceeds k.
            while (j >= begin || (end - begin + 1) > k) {
                cs -= nums[begin]; // Remove the first element of the window from the current sum.
                begin++; // Move the start of the window forward.
            }

            // Expand the window by adding the current element to the sum.
            cs += nums[end];
            // Update the last seen index of the current element.
            lastseen.put(curr, end);

            // If the window size equals k and all elements are distinct,
            // update the maximum sum found so far.
            if (end - begin + 1 == k) {
                ans = Math.max(ans, cs);
            }

            // Move the end pointer to expand the window.
            end++;
        }

        // Return the maximum sum found, or 0 if no valid subarray was found.
        return ans;
    }
}
