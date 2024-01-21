package com.example.helloworld.dp.easy;

import static com.example.helloworld.interviews.sahil.uiPath.UiPathInterviewRound2Coding.sol;

/**
 * leetcode 198. House Robber
 *
 * code harmony solution video : https://youtu.be/TRZbkXj0z8E
 *
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */
public class HouseRobber {

    /**
     * Approach 2 - Tabulation - bottom-up approach.
     * O(N) time and O(N) space
     * TODO Assignment: Try to optimize to solve it in constant space!
     *
     * @param nums
     * @return Maximum amount of money that can be robbed without alerting the police.
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // Create an array to store the maximum amount of money that can be robbed up to each house.
        int[] dp = new int[n];

        // Initialize the first two elements of the array.
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // Iterate through the array, calculating the maximum amount of money that can be robbed at each house.
        for (int i = 2; i < n; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);

        // Return the maximum amount of money that can be robbed from the last house.
        return dp[n - 1];
    }

    /**
     * Approach 1 - Recursion with Memorization
     */
    Integer[] dp;

    public int robRWM(int[] nums) {
        // Initialize the memoization array.
        dp = new Integer[101];
        return sol(nums, nums.length - 1);
    }

    /**
     * Recursive function with memorization to calculate the maximum amount of money that can be robbed.
     *
     * @param nums Array representing the amount of money in each house.
     * @param idx  Index of the current house.
     * @return Maximum amount of money that can be robbed up to the current house.
     */
    private int sol(int[] nums, int idx) {
        // Base case: If the index is less than 0, return 0.
        if (idx < 0) return 0;

        // If the result for the current index is already memoized, return the memoized value.
        if (dp[idx] != null) return dp[idx];

        // Calculate the maximum amount of money that can be robbed at the current house.
        int result = Math.max(
                nums[idx] + sol(nums, idx - 2),
                sol(nums, idx - 1)
        );

        // Memoize the result for the current index.
        return dp[idx] = result;
    }
}
