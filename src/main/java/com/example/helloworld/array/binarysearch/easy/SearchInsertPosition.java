package com.example.helloworld.array.binarysearch.easy;

/**
 * LeetCode Problem 35: Search Insert Position
 *
 * Code Harmony Video Explanation: https://youtu.be/cnKFWF3mOXk
 *
 * Problem Statement:
 * Given a sorted array of distinct integers `nums` and a target value `target`,
 * return the index if the target is found. If the target is not found, return the index
 * where it would be if it were inserted in order.
 *
 * This algorithm must achieve an O(log n) runtime complexity, making binary search suitable.
 *
 * Examples:
 * Example 1:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 *
 * Example 2:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 *
 * Example 3:
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 *
 * Constraints:
 * - 1 <= nums.length <= 10^4
 * - -10^4 <= nums[i] <= 10^4
 * - `nums` contains distinct values sorted in ascending order.
 * - -10^4 <= target <= 10^4
 */
public class SearchInsertPosition {

    /**
     * Searches for the target value within a sorted array using binary search.
     * If the target is found, returns its index. If not, returns the index where
     * it should be inserted to maintain sorted order.
     *
     * @param nums Sorted array of distinct integers
     * @param target Integer value to search for or insert position
     * @return Index of the target if found, or insertion index if not found
     */
    public int searchInsert(int[] nums, int target) {
        // Initialize the left and right pointers for binary search
        int left = 0;
        int right = nums.length - 1;

        // Loop until the search space is exhausted (left > right)
        while (left <= right) {
            // Calculate the middle index to prevent overflow
            int mid = left + (right - left) / 2;

            // Check if the middle element is equal to the target
            if (nums[mid] == target) {
                // Target found, return the index
                return mid;
            }
            // If target is less than the middle element
            else if (nums[mid] > target) {
                // Narrow the search to the left half by moving the right pointer
                right = mid - 1;
            }
            // If target is greater than the middle element
            else {
                // Narrow the search to the right half by moving the left pointer
                left = mid + 1;
            }
        }

        // Target was not found in the array; return left as the insertion index
        return left;
    }
}
