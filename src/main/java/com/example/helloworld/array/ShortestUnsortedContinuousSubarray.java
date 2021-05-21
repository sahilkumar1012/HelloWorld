package com.example.helloworld.array;

/**
 * leetcode 581. Shortest Unsorted Continuous Subarray
 * > asked in google
 *
 * Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.
 *
 * Return the shortest such subarray and output its length.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,6,4,8,10,9,15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: 0
 * Example 3:
 *
 * Input: nums = [1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 *
 *
 * Follow up: Can you solve it in O(n) time complexity?
 */
public class ShortestUnsortedContinuousSubarray {

    /**
     * find the length of shortest unsorted subarray
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {

        int n = nums.length;
        if(n<2) return 0;

        // firsly, find the candidate for left and the right range for unsorted array.
        int left = 0, right = n-1;
        while(nums[left+1] >= nums[left]){
            ++left;
            if(left==n-1)           // if the array is already sorted.
                return 0;
        }

        while(nums[right-1] <= nums[right]){
            --right;
        }

        // max & min in range
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=left; i<=right; ++i){
            if(nums[i] > max) max = nums[i];
            if(nums[i] < min) min = nums[i];
        }

        // min of range should be greater than the element in the left sorted array.
        while(left>0 && nums[left-1] > min)
            --left;

        // max in range should be less than the least element in the right sorted array.
        while(right<n-1 && nums[right+1] < max)
            ++right;

        return right-left+1;
    }
}
