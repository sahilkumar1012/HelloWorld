package com.example.helloworld.array.slidingwindow;

/**
 * leetcode 1004. Max Consecutive Ones III
 *
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * Example 2:
 *
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 * 0 <= k <= nums.length
 *
 */
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int start = 0, max = 0, zeroCount=0;

        for(int end = 0; end < nums.length; end++){
            if(nums[end] == 0)
                zeroCount++;
            while(zeroCount > k){
                if(nums[start] == 0){
                    zeroCount--;
                }
                start++;
            }
            max = Math.max(max, end-start+1);
        }

        return max;
    }

    // write main to test this method
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(new MaxConsecutiveOnesIII().longestOnes(nums, k));
    }

}
