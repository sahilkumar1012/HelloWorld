package com.example.helloworld.array.binarysearch.easy;

/**
 * LeetCode Problem 704: Binary Search
 *
 * Code Harmony Video Explanation: https://youtu.be/cnKFWF3mOXk
 *
 * Problem Statement:
 * Given a sorted array of integers `nums` in ascending order and an integer `target`,
 * write a function to search for `target` in `nums`. If the `target` exists, return its index.
 * Otherwise, return -1.
 *
 * This algorithm must have a runtime complexity of O(log n), making it suitable for binary search.
 *
 * Examples:
 * Example 1:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums, and its index is 4.
 *
 * Example 2:
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums, so return -1.
 *
 * Constraints:
 * - 1 <= nums.length <= 10^4
 * - -10^4 < nums[i], target < 10^4
 * - All integers in `nums` are unique.
 * - `nums` is sorted in ascending order.
 */
public class BinarySearch {

    /**
     * Searches for a target value within a sorted array using binary search.
     *
     * @param nums Sorted array of integers
     * @param target Integer value to search for
     * @return Index of the target if found, or -1 if target is not in the array
     */
    public int search(int[] nums, int target) {
        // Initialize the left and right pointers for binary search
        int left = 0;
        int right = nums.length - 1;

        // Continue the loop while the search space is valid (left <= right)
        while (left <= right) {
            // Calculate the middle index to avoid integer overflow
            int mid = left + (right - left) / 2;

            // Check if the middle element is equal to the target
            if (nums[mid] == target) {
                // Target found, return the index
                return mid;
            }
            // If target is smaller than the middle element
            else if (nums[mid] > target) {
                // Move the right pointer to mid - 1 to search the left half
                right = mid - 1;
            }
            // If target is larger than the middle element
            else {
                // Move the left pointer to mid + 1 to search the right half
                left = mid + 1;
            }
        }

        // Target was not found in the array, return -1
        return -1;
    }
}
