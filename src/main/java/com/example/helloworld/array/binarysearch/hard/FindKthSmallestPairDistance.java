package com.example.helloworld.array.binarysearch.hard;

import java.util.Arrays;

/**
 * leetcode 719. Find K-th Smallest Pair Distance , binary search on answers , hard , google / amazon
 *
 * The distance of a pair of integers a and b is defined as the absolute difference between a and b.
 *
 * Given an integer array nums and an integer k, return the kth smallest distance among all the pairs nums[i] and nums[j] where 0 <= i < j < nums.length.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,1], k = 1
 * Output: 0
 * Explanation: Here are all the pairs:
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * Then the 1st smallest distance pair is (1,1), and its distance is 0.
 *
 * Example 2:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 0
 *
 * Example 3:
 *
 * Input: nums = [1,6,1], k = 3
 * Output: 5
 *
 *
 *
 * Constraints:
 *
 *     n == nums.length
 *     2 <= n <= 104
 *     0 <= nums[i] <= 106
 *     1 <= k <= n * (n - 1) / 2
 *
 *
 */

public class FindKthSmallestPairDistance {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums); // Sort array to enable two-pointer difference counting
        int n = nums.length;

        int l = 0; // Minimum possible distance
        int r = nums[n - 1] - nums[0]; // Maximum possible distance (max - min)
        int ans = 0;

        // Binary search on possible distance values
        while (l <= r) {
            int mid = (l + r) / 2; // Current distance to test

            // Count how many pairs have distance <= mid
            if (countPairs(nums, mid) >= k) {
                ans = mid;       // mid might be the answer
                r = mid - 1;     // Try smaller distances
            } else {
                l = mid + 1;     // Not enough pairs, increase distance
            }
        }

        return ans; // The smallest distance with at least k pairs
    }

    // Counts how many pairs (i, j) have nums[j] - nums[i] <= mid
    private int countPairs(int[] nums, int mid) {
        int n = nums.length;
        int count = 0;
        int j = 0;

        // Two-pointer sliding window approach
        for (int i = 0; i < n; i++) {
            // Move j as far right as possible while condition holds
            while (j < n && nums[j] - nums[i] <= mid) {
                j++;
            }
            // All indices between i and j-1 form valid pairs with i
            count += j - i - 1;
        }

        return count; // Total number of valid pairs
    }
}

