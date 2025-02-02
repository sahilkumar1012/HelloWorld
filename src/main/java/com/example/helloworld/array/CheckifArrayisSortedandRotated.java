package com.example.helloworld.array;

/**
 * leetcode 1752. Check if Array Is Sorted and Rotated , Google Meta Amazon
 *
 * Code Harmony Reference Video : https://youtu.be/XwXNZMO7HlQ
 *
 * My LeetCode Solution : https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/solutions/6361648/easy-to-understand-beginner-friendly-problem-array-fall-count-detailed-video-explanation
 *
 * Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.
 *
 * There may be duplicates in the original array.
 *
 * Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,4,5,1,2]
 * Output: true
 * Explanation: [1,2,3,4,5] is the original sorted array.
 * You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].
 * Example 2:
 *
 * Input: nums = [2,1,3,4]
 * Output: false
 * Explanation: There is no sorted array once rotated that can make nums.
 * Example 3:
 *
 * Input: nums = [1,2,3]
 * Output: true
 * Explanation: [1,2,3] is the original sorted array.
 * You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class CheckifArrayisSortedandRotated {
    public boolean check(int[] nums) {
        int n = nums.length;
        // If the array has less than 2 elements, it is always considered sorted and rotated.
        if(n<2) return true;

        int fall = 0; // Counts the number of times the sequence decreases.
        for(int i=1; i<n; i++){
            if(nums[i] < nums[i-1]){
                fall++;
            }
        }

        // Additional check to determine if rotation is valid.
        if(nums[n-1] > nums[0]){
            fall++;
        }

        // If there is at most one fall, the array is sorted and rotated.
        if(fall <= 1) return true;
        return false;
    }
}
