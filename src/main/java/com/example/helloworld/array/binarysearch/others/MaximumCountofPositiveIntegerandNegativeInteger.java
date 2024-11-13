package com.example.helloworld.array.binarysearch.others;

/**
 * Leetcode 2529. Maximum Count of Positive Integer and Negative Integer
 *
 * Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers and the number of negative integers.
 * Note that 0 is neither positive nor negative.
 *
 * Examples:
 * Input: nums = [-2,-1,-1,1,2,3]   Output: 3
 * Explanation: 3 positive integers and 3 negative integers; the maximum is 3.
 *
 * Input: nums = [-3,-2,-1,0,0,1,2]  Output: 3
 * Explanation: 2 positive integers and 3 negative integers; the maximum is 3.
 *
 * Input: nums = [5,20,66,1314]  Output: 4
 * Explanation: 4 positive integers and 0 negative integers; the maximum is 4.
 *
 * Constraints:
 * - Array is sorted in non-decreasing order.
 * - Array length is between 1 and 2000.
 * - Array elements range from -2000 to 2000.
 *
 * Follow-up: Solve in O(log(n)) time complexity.
 */
public class MaximumCountofPositiveIntegerandNegativeInteger {

    public int maximumCount(int[] nums) {
        int n = nums.length;

        // Special cases: if the array only has positive or negative numbers
        if (nums[0] > 0) return n;   // Entire array is positive
        if (nums[n - 1] < 0) return n; // Entire array is negative

        // Binary search to find the last occurrence of zero (if any)
        int left = 0;
        int right = n - 1;
        int lastZero = -1; // Initialize last zero position as -1 (meaning no zero found)

        // Find the last position where nums[i] == 0
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == 0) {
                lastZero = mid; // Update lastZero with the current position
                left = mid + 1; // Continue to search in the right half
            } else if (nums[mid] < 0) {
                left = mid + 1; // Move search to the right if nums[mid] is negative
            } else {
                right = mid - 1; // Move search to the left if nums[mid] is positive
            }
        }

        // Now we have the position of the last zero or -1 if no zeros were found

        // Binary search to find the first positive integer (> 0)
        int firstPositive = -1; // Initialize the first positive position as -1

        // If the first element is zero, then the first positive is at index 0
        if (nums[0] == 0) {
            firstPositive = 0;
        } else { // Otherwise, there are negative numbers at the start
            left = 0;
            right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;

                // Check if nums[mid] is the first positive integer
                if (nums[mid - 1] < 0 && nums[mid] > 0) {                       // dw, nahi aega index -1 out of bound
                    firstPositive = mid; // Found the first positive integer
                    break;
                } else if (nums[mid] > 0) {
                    right = mid - 1; // Search in the left half if mid is positive
                } else {
                    left = mid + 1; // Search in the right half if mid is negative
                }
            }
        }

        // Count the number of negative integers as the index of the first positive integer
        int neg = firstPositive;

        // Count the number of positive integers
        int pos = (lastZero == -1) ? n - firstPositive : n - 1 - lastZero;

        // Return the maximum count between positive and negative integers
        return Math.max(pos, neg);
    }

}
