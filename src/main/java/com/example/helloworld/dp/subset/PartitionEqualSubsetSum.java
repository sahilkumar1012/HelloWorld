package com.example.helloworld.dp.subset;

/**
 * leetcode 416. Partition Equal Subset Sum , Asked in MAANG
 *
 * code harmony reference video : https://youtu.be/ZsxXWSmtEWM
 *
 * my leetcode solution : https://leetcode.com/problems/partition-equal-subset-sum/solutions/6624001/elegant-recursive-memoization-approach-d-7ac4
 *
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */

public class PartitionEqualSubsetSum {
    Boolean[][] dp;

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        // Calculate total sum of elements
        for(int i = 0; i < n; i++)
            sum += nums[i];

        // If sum is odd, we can't partition into equal subsets
        if(sum % 2 == 1) return false;

        int t = sum / 2;

        // Initialize memoization table
        dp = new Boolean[n][t + 1];

        // Start recursion from index 0 and target sum = t
        return sol(nums, 0, t);
    }

    private boolean sol(int[] nums, int idx, int t) {
        // If target becomes negative, not a valid path
        if(t < 0) return false;

        // If target is 0, we've found a valid subset
        if(t == 0) return true;

        // If we've reached end of array without matching target
        if(idx == nums.length) return false;

        // If already computed, return stored result
        if(dp[idx][t] != null) return dp[idx][t];

        // Include current element in subset
        if(sol(nums, idx + 1, t - nums[idx]))
            return dp[idx][t] = true;

        // Exclude current element from subset
        return dp[idx][t] = sol(nums, idx + 1, t);
    }
}

class PartitionEqualSubsetSumBottomUp {
        /*
        we just have to find if it's possible to find a subset with sum = totalsum/2, if total sum is even
        */
        public boolean canPartition(int[] nums) {
            int n = nums.length;
            int sum = 0;
            for(int i=0; i<n; i++)
                sum += nums[i];

            if(sum % 2 == 1) return false;  // sum is odd, not possible to divided.

            boolean[][] dp = new boolean[n+1][sum/2+1]; // we'll have 0th row and 0th col

            for(int i=0; i<=n; i++){
                for(int j=0; j<=(sum/2); j++){
                    if(i==0 && j==0)
                        dp[i][j] = true;
                    else if(i==0)
                        dp[i][j] = false;
                    else if(j==0)
                        dp[i][j] = true;
                    else{
                        // either we include this item which is at(i-1) index of nums or include it
                        int val = nums[i-1];
                        if( dp[i-1][j] )  // we can achieve without including it
                            dp[i][j] = true;
                        else if( val <= j)       // only then it'll be included
                            dp[i][j] = dp[i-1][j-val];
                    }
                }
            }
            return dp[n][sum/2];
        }
    }
