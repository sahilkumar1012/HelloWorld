package com.example.helloworld.bitmanipulation.medium;

/**
 * leetcode 1829. Maximum XOR for Each Query
 *
 * You are given a sorted array nums of n non-negative integers and an integer maximumBit. You want to perform the following query n times:
 *
 * Find a non-negative integer k < 2maximumBit such that nums[0] XOR nums[1] XOR ... XOR nums[nums.length-1] XOR k is maximized. k is the answer to the ith query.
 * Remove the last element from the current array nums.
 * Return an array answer, where answer[i] is the answer to the ith query.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,1,3], maximumBit = 2
 * Output: [0,3,2,3]
 * Explanation: The queries are answered as follows:
 * 1st query: nums = [0,1,1,3], k = 0 since 0 XOR 1 XOR 1 XOR 3 XOR 0 = 3.
 * 2nd query: nums = [0,1,1], k = 3 since 0 XOR 1 XOR 1 XOR 3 = 3.
 * 3rd query: nums = [0,1], k = 2 since 0 XOR 1 XOR 2 = 3.
 * 4th query: nums = [0], k = 3 since 0 XOR 3 = 3.
 * Example 2:
 *
 * Input: nums = [2,3,4,7], maximumBit = 3
 * Output: [5,2,6,5]
 * Explanation: The queries are answered as follows:
 * 1st query: nums = [2,3,4,7], k = 5 since 2 XOR 3 XOR 4 XOR 7 XOR 5 = 7.
 * 2nd query: nums = [2,3,4], k = 2 since 2 XOR 3 XOR 4 XOR 2 = 7.
 * 3rd query: nums = [2,3], k = 6 since 2 XOR 3 XOR 6 = 7.
 * 4th query: nums = [2], k = 5 since 2 XOR 5 = 7.
 * Example 3:
 *
 * Input: nums = [0,1,2,2,5,7], maximumBit = 3
 * Output: [4,3,6,4,6,7]
 *
 *
 * Constraints:
 *
 * nums.length == n
 * 1 <= n <= 105
 * 1 <= maximumBit <= 20
 * 0 <= nums[i] < 2maximumBit
 * nums​​​ is sorted in ascending order.
 */
public class MaximumXORforEachQuery {

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;

        // Initialize the xor variable to hold the XOR of all elements in nums
        int xor = 0;
        for (int num : nums) {
            xor ^= num;  // Calculate XOR of all elements in nums
        }

        // Initialize the result array to store answers for each query
        int[] ans = new int[n];

        // Iterate over each query (in reverse order of nums)
        for (int ii = 0; ii < n; ii++) {
            int val = 0;

            // Calculate the number 'k' by examining each bit position
            /**
             * If we consider this constraint : 0 <= nums[i] < 2maximumBit
             * then mask = (1 << maxbit)-1 , will work.
             */
            for (int i = maximumBit - 1; i >= 0; i--) {
                int mask = (1 << i);  // Create a mask with the ith bit set

                // If the current bit in xor is 0, set it in val to maximize XOR
                if ((xor & mask) == 0) {
                    val |= mask;
                }
            }
            ans[ii] = val;  // Store the calculated 'k' value for the current query

            // Update xor by removing the last element of nums for the next query
            xor ^= nums[n - 1 - ii];
        }

        return ans;  // Return the array of answers for each query
    }

}
