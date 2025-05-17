package com.example.helloworld.array.twopointers;

import java.util.Arrays;

/**
 * leetcode 2563. Count the Number of Fair Pairs , Google Amazon
 *
 * code harmony video explanation :
 *
 * my leetcode solution :
 *
 *
 * Given a 0-indexed integer array nums of size n and two integers lower and upper, return the number of fair pairs.
 *
 * A pair (i, j) is fair if:
 *
 * 0 <= i < j < n, and
 * lower <= nums[i] + nums[j] <= upper
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,7,4,4,5], lower = 3, upper = 6
 * Output: 6
 * Explanation: There are 6 fair pairs: (0,3), (0,4), (0,5), (1,3), (1,4), and (1,5).
 * Example 2:
 *
 * Input: nums = [1,7,9,2,5], lower = 11, upper = 11
 * Output: 1
 * Explanation: There is a single fair pair: (2,3).
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums.length == n
 * -109 <= nums[i] <= 109
 * -109 <= lower <= upper <= 109
 */
public class CounttheNumberofFairPairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        // Sort the array to use two-pointer efficiently
        Arrays.sort(nums);

        // Count of pairs with sum ≤ upper MINUS pairs with sum < lower
        // This gives count of pairs such that lower ≤ sum ≤ upper
        return helper(nums, upper + 1) - helper(nums, lower);
    }

    // Helper method to count number of pairs (i, j) with 0 ≤ i < j < n
    // and nums[i] + nums[j] < target
    private long helper(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        long count = 0;

        // Two-pointer traversal to count valid pairs
        while (l < r) {
            int sum = nums[l] + nums[r];

            if (sum < target) {
                // Since nums is sorted and sum < target,
                // all pairs (l, l+1), (l, l+2), ..., (l, r) are valid
                count += (r - l);
                l++; // Move to next left element
            } else {
                // If sum ≥ target, decrease right pointer to reduce sum
                r--;
            }
        }

        return count;
    }
}
