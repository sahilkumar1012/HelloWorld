package com.example.helloworld.greedy;

import java.util.Arrays;

/**
 * leetcode 2966. Divide Array Into Arrays With Max Difference
 *
 * code harmony solution video :
 *
 * You are given an integer array nums of size n and a positive integer k.
 *
 * Divide the array into one or more arrays of size 3 satisfying the following conditions:
 *
 * Each element of nums should be in exactly one array.
 * The difference between any two elements in one array is less than or equal to k.
 * Return a 2D array containing all the arrays. If it is impossible to satisfy the conditions, return an empty array. And if there are multiple answers, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,4,8,7,9,3,5,1], k = 2
 * Output: [[1,1,3],[3,4,5],[7,8,9]]
 * Explanation: We can divide the array into the following arrays: [1,1,3], [3,4,5] and [7,8,9].
 * The difference between any two elements in each array is less than or equal to 2.
 * Note that the order of elements is not important.
 * Example 2:
 *
 * Input: nums = [1,3,3,2,7,3], k = 3
 * Output: []
 * Explanation: It is not possible to divide the array satisfying all the conditions.
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 105
 * n is a multiple of 3.
 * 1 <= nums[i] <= 105
 * 1 <= k <= 105
 */
public class DivideArrayIntoArraysWithMaxDifference {
    /**
     * Method to divide the array into arrays with a max difference of k.
     *
     * @param nums The input integer array.
     * @param k    The positive integer representing the maximum difference between elements in an array.
     * @return A 2D array containing arrays that satisfy the conditions, or an empty array if not possible.
     */
    public int[][] divideArray(int[] nums, int k) {
        // Sorting the array for easy traversal
        Arrays.sort(nums);

        int n = nums.length;

        // Initializing the 2D array to store the result
        int[][] ans = new int[n / 3][3];
        int j = 0;

        // Traverse the sorted array in chunks of 3
        for (int i = 0; i < n; i += 3) {
            // Check if the difference between the first and last element in the chunk is greater than k
            if (nums[i + 2] - nums[i] > k) {
                // If it is, return an empty array as it's not possible to satisfy the conditions
                return new int[0][0];
            }

            // Store the chunk in the result array
            ans[j][0] = nums[i];
            ans[j][1] = nums[i + 1];
            ans[j][2] = nums[i + 2];

            j++;
        }

        // Return the result array
        return ans;
    }
}
