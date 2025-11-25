package com.example.helloworld.backtracking;

import java.util.Arrays;

/**
 * leetcode 698. Partition to K Equal Sum Subsets,
 *
 * Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,3,2,3,5,2,1], k = 4
 * Output: true
 * Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 * Example 2:
 *
 * Input: nums = [1,2,3,4], k = 3
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 16
 * 1 <= nums[i] <= 104
 * The frequency of each element is in the range [1, 4].
 */
public class PartitiontoKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int x : nums) sum += x;
        if (sum % k != 0) return false;

        int target = sum / k;
        int n = nums.length;

        Arrays.sort(nums);
        if (nums[n-1] > target) return false;

        // reverse sort (largest first)
        for (int i = 0; i < n/2; i++) {
            int t = nums[i];
            nums[i] = nums[n-1-i];
            nums[n-1-i] = t;
        }

        int[] buckets = new int[k];
        return backtrack(nums, buckets, 0, target);
    }


    private boolean backtrack(int[] nums, int[] buckets,
                              int index, int target) {

        if (index == nums.length) {
            for (int b : buckets)
                if (b != target) return false;
            return true;
        }

        int val = nums[index];


        for (int i = 0; i < buckets.length; i++) {

            // if placing exceeds target, skip
            if (buckets[i] + val > target) continue;

            // IMPORTANT - symmetry pruning:
            // if this bucket is same as previous empty bucket → skip
            // or just use DP instead.
            if (i > 0 && buckets[i] == buckets[i-1]) continue;

            // choose
            buckets[i] += val;

            if (backtrack(nums, buckets, index + 1, target))
                return true;

            // unchoose
            buckets[i] -= val;

        }

        return false;
    }
}

