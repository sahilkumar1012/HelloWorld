package com.example.helloworld.array.prefixsum;

/**
 * leetcode 1685. Sum of Absolute Differences in a Sorted Array
 * https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
 *
 * You are given an integer array nums sorted in non-decreasing order.
 *
 * Build and return an integer array result with the same length as nums such that result[i] is equal to the summation
 * of absolute differences between nums[i] and all the other elements in the array.
 *
 * In other words, result[i] is equal to sum(|nums[i]-nums[j]|) where 0 <= j < nums.length and j != i (0-indexed).
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,5]
 * Output: [4,3,5]
 * Explanation: Assuming the arrays are 0-indexed, then
 * result[0] = |2-2| + |2-3| + |2-5| = 0 + 1 + 3 = 4,
 * result[1] = |3-2| + |3-3| + |3-5| = 1 + 0 + 2 = 3,
 * result[2] = |5-2| + |5-3| + |5-5| = 3 + 2 + 0 = 5.
 * Example 2:
 *
 * Input: nums = [1,4,6,8,10]
 * Output: [24,15,13,15,21]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * 1 <= nums[i] <= nums[i + 1] <= 104
 */
public class SumofAbsoluteDifferencesinSortedArray {
    // brute force |  TLE solution.
    public int[] getSumAbsoluteDifferencesTLE(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            int temp = 0;
            for(int j=0; j<n; j++){
                temp += (Math.abs(nums[i]-nums[j]));
            }
            ans[i] = temp;
        }

        return ans;
    }


    // Linear time solution | Accepted.
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];

        prefix[0] = nums[0];
        for(int i=1; i<n; i++)
            prefix[i] = prefix[i-1] + nums[i];

        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            int leftSum = prefix[i] - nums[i];
            int rightSum = prefix[n-1] - prefix[i];

            int leftCount = i;
            int rightCount = n-1-i;

            int leftAns = nums[i] * leftCount - leftSum;
            int rightAns = rightSum - nums[i] * rightCount;

            ans[i] = leftAns + rightAns;
        }
        return ans;
    }
}
