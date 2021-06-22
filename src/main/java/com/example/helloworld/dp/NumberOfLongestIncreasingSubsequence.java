package com.example.helloworld.dp;

import java.util.Arrays;

/**
 * leetcode 673. Number of Longest Increasing Subsequence
 *
 * Given an integer array nums, return the number of longest increasing subsequences.
 *
 * Notice that the sequence has to be strictly increasing.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
 * Example 2:
 *
 * Input: nums = [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2000
 * -106 <= nums[i] <= 106
 */
public class NumberOfLongestIncreasingSubsequence {
    /**
     * took reference from https://youtu.be/C1DTXdF3s14
     * <p>
     * aa jaega samaj 2 3 bar try kario.
     */
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int n = nums.length;
        int[] length = new int[n], count = new int[n];
        Arrays.fill(length, 1);
        Arrays.fill(count, 1);

        int lis = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (length[j] + 1 > length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    } else if (length[j] + 1 == length[i]) {
                        count[i] += count[j];
                    }
                }
            }
            lis = Math.max(lis, length[i]);
        }

        int numLis = 0;
        for (int i = 0; i < n; i++)
            if (length[i] == lis)
                numLis += count[i];

        return numLis;
    }
}