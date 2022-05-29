package com.example.helloworld.twopointer;

/**
 * leetcode 287. Find the Duplicate Number
 *
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer which appears two or more times.
 *
 *
 * Follow up:
 *
 * How can we prove that at least one duplicate number must exist in nums?
 * Can you solve the problem in linear runtime complexity?
 */
public class FindTheDuplicateNumber {
    // Floyd's Tortoise and Hare (Cycle Detection)
    // refer : Approach 7: Floyd's Tortoise and Hare (Cycle Detection) |||| https://leetcode.com/problems/find-the-duplicate-number/solution/
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];

        do{
            hare = nums[nums[hare]];
            tortoise = nums[tortoise];
        }while(hare != tortoise);
        /*
         d = distance till straight
         k = distance of meeting from the starting of the loop
         n = length of the loop

         distance by slow pointer * 2 = distance by fast pointer

         -> (d + a * n + k) * 2 = d + b * n + k
         -> d + k = (b-a)*n
         -> d = (b-a)*n -k

         // d+k is positive, if one pointer start from the starting of the array
         then second pointer will perform some number of iterations and fall by k point which mean
         it'll meet other pointer at the starting of the loop

         now both the pointers will be pointing to the starting of the loop!!!!
         */
        hare = nums[0];
        while(hare != tortoise){
            hare = nums[hare];
            tortoise = nums[tortoise];
        }

        return hare;
    }
}