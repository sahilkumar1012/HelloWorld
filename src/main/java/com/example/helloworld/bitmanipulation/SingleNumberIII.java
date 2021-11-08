package com.example.helloworld.bitmanipulation;

/**
 * leetcode 260. Single Number III
 *
 * Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.
 *
 * You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,1,3,2,5]
 * Output: [3,5]
 * Explanation:  [5, 3] is also a valid answer.
 * Example 2:
 *
 * Input: nums = [-1,0]
 * Output: [-1,0]
 * Example 3:
 *
 * Input: nums = [0,1]
 * Output: [1,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * Each integer in nums will appear twice, only two integers will appear once.
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {

        // first of all take xor of all the numbers.
        int axorb = 0;
        for(int num : nums)
            axorb ^= num;

        // find right significant bit mask for this xor value ( xor mai 1 aya hai matlab a and b mai differnet hai bits)
        int rsbm = axorb & -axorb;

        // group these two values based on the rsbm ( rsbm ke based pe dono gruop ban jaege jisme se ek mai a hoga and dusre mai b hoga.)
        int axor = 0, bxor = 0;

        for(int num : nums){
            if( (num & rsbm) == 0){
                axor ^= num;
            }else{
                bxor ^= num;
            }
        }

        return new int[]{axor,bxor};
    }
}
