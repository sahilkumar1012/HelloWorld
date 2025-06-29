package com.example.helloworld.array.algorithms.kadane;

/**
 * leetcode 53. Maximum Subarray
 * code harmony video : https://youtu.be/BDe0bMrDMEs

 Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

 A subarray is a contiguous part of an array.



 Example 1:

 Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 Output: 6
 Explanation: [4,-1,2,1] has the largest sum = 6.
 Example 2:

 Input: nums = [1]
 Output: 1
 Example 3:

 Input: nums = [5,4,-1,7,8]
 Output: 23


 Constraints:

 1 <= nums.length <= 105
 -104 <= nums[i] <= 104


 Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

 *
 */
public class MaximumSubarray {
        /**
         * reference to understand Kadane's algo : https://youtu.be/BDe0bMrDMEs
         * Kadane's algo
        */
        public int maxSubArray(int[] nums) {
            int tsum = 0, sum = Integer.MIN_VALUE;

            for(int i=0; i<nums.length; i++){
                tsum += nums[i];

                if( tsum > sum )
                    sum = tsum;
                if( tsum < 0 )
                    tsum = 0;
            }

            return sum;
        }
    }
