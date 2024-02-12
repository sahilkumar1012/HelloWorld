package com.example.helloworld.array.easy;

/**
 * leetcode 169. Majority Element
 *
 * Code harmony solution video : https://youtu.be/Ix4AQqOKuKs
 *
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class MajorityElement {

    /**
     * did using moore voting algorithm, Using Moore’s Voting Algorithm
     */
    public int majorityElement(int[] nums) {
        return findCandidate(nums);

//        if(isMajority(nums,candidate))
//            return cand;
//
//        throw new IllegalArgumentException("tune bola tha majority element hamesha aega.");
    }

    private boolean isMajority(int[] nums, int cand) {
        int count = 0;
        for(int i: nums){
            if( cand ==i ) count++;
        }
        return count > nums.length/2;
    }

    // 2 3 3 3 22222
    private int findCandidate(int[] nums) {
        int maj_index = 0, count = 1 ;           // cosidering the first element is majority
        for(int i=1; i<nums.length; ++i){
            if( nums[maj_index] == nums[i] )
                count++;
            else
                count--;

            if(count==0){               // means this element can not be the majority element.
                maj_index = i;
                count = 1;
            }
        }
        return nums[maj_index];
    }
}
