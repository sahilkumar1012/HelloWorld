package com.example.helloworld.array.prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 523. Continuous Subarray Sum , meta interview Question
 *
 * Topic : prefix sum + hash table  , Array , Math.
 *
 * Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
 *
 * A good subarray is a subarray where:
 *
 * its length is at least two, and
 * the sum of the elements of the subarray is a multiple of k.
 * Note that:
 *
 * A subarray is a contiguous part of the array.
 * An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 *
 *
 * Example 1:
 *
 * Input: nums = [23,2,4,6,7], k = 6
 * Output: true
 * Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
 * Example 2:
 *
 * Input: nums = [23,2,6,4,7], k = 6
 * Output: true
 * Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
 * 42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
 * Example 3:
 *
 * Input: nums = [23,2,6,4,7], k = 13
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 0 <= sum(nums[i]) <= 231 - 1
 * 1 <= k <= 231 - 1
 */
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int pmod = 0; // Variable to store the prefix sum modulo k
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>(); // Map to store (prefix sum % k) -> first occurrence index
        map.put(0, -1); // Initialize with (0, -1) to handle cases where a subarray starting from index 0 is valid

        for (int i = 0; i < n; i++) {
            pmod = (pmod + nums[i]) % k; // Compute the prefix sum modulo k

            // Handling negative modulo case to ensure it remains positive
            // but input is positive here, so ok to skip this condition.
            if (pmod < 0) {
                pmod += k;
            }

            if (map.containsKey(pmod)) { // Check if this remainder has been seen before
                if (i - map.get(pmod) > 1) { // Ensure the subarray has at least two elements
                    return true; // Found a valid subarray
                }
            } else {
                // Store the first occurrence of this remainder
                map.put(pmod, i);
            }
        }

        return false; // No valid subarray found
    }

/**
 [23,2,4,6,7] k = 6
 [5, 1,5, ]


 [23,2,4,6,6] k = 7
 [2,4,1,0,6]

 [1,0] , k = 2
 [1,1]
 */
}
