package com.example.helloworld.array.binarysearch;

import java.util.Arrays;

/**
 * leetcode 35. Search Insert Position
 *
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 *
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 */
public class SearchInsertPosition {
    public int searchInsertShortcut(int[] nums, int target) {
        int idx = Arrays.binarySearch(nums,0,nums.length, target);
        if(idx < 0){
            idx = ( -1 * idx ) - 1;
        }
        return idx;
    }

    /**
     * vanilla binary search algo
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length-1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }

        return low;
    }
}
