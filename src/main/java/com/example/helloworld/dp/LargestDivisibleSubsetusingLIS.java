package com.example.helloworld.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 368. Largest Divisible Subset
 *
 * Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
 *
 * answer[i] % answer[j] == 0, or
 * answer[j] % answer[i] == 0
 * If there are multiple solutions, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [1,2]
 * Explanation: [1,3] is also accepted.
 * Example 2:
 *
 * Input: nums = [1,2,4,8]
 * Output: [1,2,4,8]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 109
 * All the integers in nums are unique.
 */
public class LargestDivisibleSubsetusingLIS {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] dp = new int[nums.length];
        return constructLDS(nums, dp, getLDSSize(nums, dp));
    }

    // LIS
    private int getLDSSize(int[] nums, int[] dp) {
        Arrays.sort(nums);
        Arrays.fill(dp, 1);
        int ldsSize = 1;

        for (int i = 1; i < nums.length; i++)
            for (int j = 0; j < i; j++)
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ldsSize = Math.max(ldsSize, dp[i]);
                }

        return ldsSize;
    }

    // returning LIS
    private List<Integer> constructLDS(int[] nums, int[] dp, int ldsSize) {
        int prev = -1;
        LinkedList<Integer> lds = new LinkedList<Integer>();

        for (int i = dp.length - 1; i >= 0; i--)
            if (dp[i] == ldsSize && (prev == -1 || prev % nums[i] == 0)) {
                lds.addFirst(nums[i]);
                ldsSize--;
                prev = nums[i];
            }

        return lds;
    }
}