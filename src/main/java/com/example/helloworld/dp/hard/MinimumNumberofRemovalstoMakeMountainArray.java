package com.example.helloworld.dp.hard;

/**
 * leetcode 1671. Minimum Number of Removals to Make Mountain Array
 *
 * A mountain array is defined as an array with three or more elements that satisfies the following conditions:
 * 1. The elements strictly increase up to a certain peak index (i), and then strictly decrease afterwards.
 * 2. There exists some index i (0 < i < arr.length - 1) where:
 *      - arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 *      - arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * Given an integer array nums, return the minimum number of elements that need to be removed
 * to make nums a mountain array.
 *
 * Example 1:
 * Input: nums = [1,3,1]
 * Output: 0
 * Explanation: The array itself is a mountain array so no elements need to be removed.
 *
 * Example 2:
 * Input: nums = [2,1,1,5,6,2,3,1]
 * Output: 3
 * Explanation: One solution is to remove elements at indices 0, 1, and 5, making nums = [1,5,6,3,1].
 *
 * Constraints:
 * - 3 <= nums.length <= 1000
 * - 1 <= nums[i] <= 10^9
 * - It is guaranteed that a mountain array can be formed from nums.
 */
public class MinimumNumberofRemovalstoMakeMountainArray {

    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;

        // Compute the longest increasing subsequence (LIS) from the left up to each index
        int[] leftLIS = lis(nums);

        // Compute the LIS from the right by reversing the array and applying the LIS function
        int[] rightLIS = lis(reverse(nums));

        // Reverse the right LIS to align it with the original index positions of nums
        reverse(rightLIS);

        // Initialize the minimum number of removals to a large value
        int ans = Integer.MAX_VALUE;

        // Check each position as the potential peak of the mountain
        for(int i = 1; i < n - 1; i++) {
            // Skip indices where we can't form a valid mountain (LIS length must be greater than 1 on both sides)
            if(leftLIS[i] == 1 || rightLIS[i] == 1) continue;

            // Calculate the length of the mountain array with peak at index i
            int mountain = leftLIS[i] + rightLIS[i] - 1;

            // Update the minimum removals needed to form the mountain array
            ans = Math.min(ans, n - mountain);
        }

        return ans;
    }

    /**
     * Helper function to compute the Longest Increasing Subsequence (LIS) for each element.
     * Each element ans[i] in the result array represents the length of the LIS ending at index i.
     */
    private int[] lis(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {
            int max = 0;

            // Check previous elements to find the maximum LIS that can extend to nums[i]
            for(int j = i - 1; j >= 0; j--) {
                if(nums[j] < nums[i])
                    max = Math.max(max, ans[j]);
            }

            // Update the LIS length at index i
            ans[i] = 1 + max;
        }

        return ans;
    }

    /**
     * Helper function to reverse an array in-place.
     * Used to compute the LIS from the right by reversing the input array.
     */
    private int[] reverse(int[] arr) {
        int n = arr.length;

        // Swap elements from both ends moving towards the center
        for(int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }

        return arr;
    }
}
