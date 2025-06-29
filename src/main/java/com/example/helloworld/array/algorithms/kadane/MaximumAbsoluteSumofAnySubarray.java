package com.example.helloworld.array.algorithms.kadane;

/**
 * leetCode 1749. Maximum Absolute Sum of Any Subarray , Kadane's Algo, Important
 *
 * problem link : https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/
 * code harmony video explanation : https://youtu.be/9eswigiGTUQ
 *
 * my leetcode solution :
 *
 * You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr).
 *
 * Return the maximum absolute sum of any (possibly empty) subarray of nums.
 *
 * Note that abs(x) is defined as follows:
 *
 * If x is a negative integer, then abs(x) = -x.
 * If x is a non-negative integer, then abs(x) = x.
 *
 *
 * Example 1:
 *
 * Input: nums = [1,-3,2,3,-4]
 * Output: 5
 * Explanation: The subarray [2,3] has absolute sum = abs(2+3) = abs(5) = 5.
 * Example 2:
 *
 * Input: nums = [2,-5,1,-4,3,-2]
 * Output: 8
 * Explanation: The subarray [-5,1,-4] has absolute sum = abs(-5+1-4) = abs(-8) = 8.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 *
 */
public class MaximumAbsoluteSumofAnySubarray {

    class Solution {
        // This method calculates the maximum absolute sum of any subarray in the input array.
        public int maxAbsoluteSum(int[] nums) {
            // The result is the maximum of the absolute values of:
            // - The minimum subarray sum (minSS)
            // - The maximum subarray sum (maxSS)
            return Math.max(
                    Math.abs(minSS(nums)),
                    Math.abs(maxSS(nums))
            );
        }

        // Helper method to calculate the minimum subarray sum (Kadane's Algorithm variation)
        private int minSS(int[] nums) {
            int t = 0; // Tracks the current subarray sum.
            int min = Integer.MAX_VALUE; // Stores the minimum subarray sum.

            for (int num : nums) {
                t += num; // Add the current number to the current sum.
                if (min > t)
                    min = t; // Update the minimum sum if the current sum is smaller.
                if (t > 0)
                    t = 0; // Reset current sum if it becomes positive (to find minimum subarray).
            }

            return min; // Return the minimum subarray sum.
        }

        // Helper method to calculate the maximum subarray sum (Kadane's Algorithm)
        private int maxSS(int[] nums) {
            int t = 0; // Tracks the current subarray sum.
            int max = Integer.MIN_VALUE; // Stores the maximum subarray sum.

            for (int num : nums) {
                t += num; // Add the current number to the current sum.
                if (max < t)
                    max = t; // Update the maximum sum if the current sum is larger.
                if (t < 0)
                    t = 0; // Reset current sum if it becomes negative (to find maximum subarray).
            }

            return max; // Return the maximum subarray sum.
        }
    }


}
