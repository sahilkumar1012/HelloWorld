package com.example.helloworld.array.binarysearch.easy;

/**
 * LeetCode Problem 34: Find First and Last Position of Element in Sorted Array
 *
 * Code Harmony Video Explanation: https://youtu.be/cnKFWF3mOXk
 *
 * Problem Statement:
 * Given a sorted array of integers `nums` in non-decreasing order, find the starting and ending position of a given `target` value.
 * If the `target` is not found in the array, return [-1, -1].
 * The solution must run in O(log n) time complexity, making binary search a suitable approach.
 *
 * Examples:
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 * Constraints:
 * - 0 <= nums.length <= 10^5
 * - -10^9 <= nums[i] <= 10^9
 * - nums is sorted in non-decreasing order.
 * - -10^9 <= target <= 10^9
 */
public class FindFirstandLastPositionofElementinSortedArray {

    /**
     * Finds the first and last positions of the target value in a sorted array.
     * Uses binary search to achieve O(log n) time complexity.
     *
     * @param nums Sorted array of integers
     * @param target Integer value to find
     * @return An array of two integers representing the first and last positions of the target,
     *         or [-1, -1] if the target is not found.
     */
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // Variable to store the index of the first occurrence of the target
        int first = -1;

        // First Binary Search: Find the first occurrence of the target
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate mid-point to avoid overflow

            // Check if the mid element matches the target
            if (nums[mid] == target) {
                first = mid;          // Update the first occurrence index
                right = mid - 1;      // Move left to search for earlier occurrences
            } else if (nums[mid] > target) {
                right = mid - 1;      // Target is in the left half
            } else {
                left = mid + 1;       // Target is in the right half
            }
        }

        // Reset search boundaries for finding the last occurrence
        left = 0;
        right = nums.length - 1;

        // Variable to store the index of the last occurrence of the target
        int last = -1;

        // Second Binary Search: Find the last occurrence of the target
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate mid-point to avoid overflow

            // Check if the mid element matches the target
            if (nums[mid] == target) {
                last = mid;           // Update the last occurrence index
                left = mid + 1;       // Move right to search for later occurrences
            } else if (nums[mid] > target) {
                right = mid - 1;      // Target is in the left half
            } else {
                left = mid + 1;       // Target is in the right half
            }
        }

        // Return the first and last occurrence indices; if target was not found, both will be -1
        return new int[]{first, last};
    }
}
