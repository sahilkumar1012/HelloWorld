package com.example.helloworld.array.twopointers;

import java.util.Arrays;

/**
 * leetcode 1498. Number of Subsequences That Satisfy the Given Sum Condition, asked in google amazon meta
 *
 * code harmony reference video :  https://youtu.be/lhR4JpKrRow
 *
 *
 * You are given an array of integers nums and an integer target.
 *
 * Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is less or equal to target. Since the answer may be too large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,5,6,7], target = 9
 * Output: 4
 * Explanation: There are 4 subsequences that satisfy the condition.
 * [3] -> Min value + max value <= target (3 + 3 <= 9)
 * [3,5] -> (3 + 5 <= 9)
 * [3,5,6] -> (3 + 6 <= 9)
 * [3,6] -> (3 + 6 <= 9)
 * Example 2:
 *
 * Input: nums = [3,3,6,8], target = 10
 * Output: 6
 * Explanation: There are 6 subsequences that satisfy the condition. (nums can have repeated numbers).
 * [3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
 * Example 3:
 *
 * Input: nums = [2,3,3,4,6,7], target = 12
 * Output: 61
 * Explanation: There are 63 non-empty subsequences, two of them do not satisfy the condition ([6,7], [7]).
 * Number of valid subsequences (63 - 2 = 61).
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 * 1 <= target <= 106
 */
public class SubsequencesThatSatisfytheGivenSumCondition {

    public int numSubseq(int[] nums, int t) {
        // Sort the array to enable two-pointer technique
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, r = n - 1;
        int ans = 0;
        int M = 1_000_000_007; // Modulo value to avoid integer overflow

        // Precompute powers of 2 up to n (i.e., power[i] = 2^i % M)
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (2 * power[i - 1]) % M;
        }

        // Two-pointer approach
        while (l <= r) {
            // If the sum of the current smallest and largest elements is <= t,
            // then all subsequences with nums[l] as the minimum and any subset of elements
            // between l and r (inclusive) can form valid subsequences
            if (nums[l] + nums[r] <= t) {
                // Count of valid subsequences is 2^(r - l)
                ans = (ans + power[r - l]) % M;
                l++; // move left pointer forward to check next possible subsequence
            } else {
                // If the sum is too large, decrease the right pointer to reduce the sum
                r--;
            }
        }

        return ans;
    }
}
