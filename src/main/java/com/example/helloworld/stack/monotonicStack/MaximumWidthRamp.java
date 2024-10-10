package com.example.helloworld.stack.monotonicStack;

import java.util.Stack;

/**
 * leetcode 962. Maximum Width Ramp
 *
 * A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j].
 * The width of such a ramp is defined as j - i (the distance between the indices).
 *
 * The goal is to return the maximum width of any ramp in nums. If no ramp exists, return 0.
 *
 * Approach:
 * - First, build a monotonic decreasing stack of indices.
 *   - For each index i, if nums[i] is smaller than or equal to the value at the top of the stack,
 *     push the index i onto the stack.
 * - Then, iterate from the end of the array (right to left) and for each index, pop the stack while
 *   the current element nums[i] is greater than or equal to the element at the index stored at the top of the stack.
 *   - Calculate the width of the ramp (i - popped index) and update the maximum width.
 *
 * The two-pass strategy ensures that we first establish potential "ramp start" candidates in the decreasing
 * stack, and then we explore possible "ramp end" candidates by iterating from the back.
 *
 * Example 1:
 * Input: nums = [6,0,8,2,1,5]
 * Output: 4
 * Explanation: The maximum width ramp is between index 1 (value 0) and index 5 (value 5), with width = 5 - 1 = 4.
 *
 * Example 2:
 * Input: nums = [9,8,1,0,1,9,4,0,4,1]
 * Output: 7
 * Explanation: The maximum width ramp is between index 2 (value 1) and index 9 (value 1), with width = 9 - 2 = 7.
 *
 * Constraints:
 * - 2 <= nums.length <= 50,000
 * - 0 <= nums[i] <= 50,000
 */

public class MaximumWidthRamp {

    /**
     * This method calculates the maximum width ramp in the given array of integers.
     *
     * @param nums The input array of integers.
     * @return The maximum width of any ramp found in the array.
     */
    public int maxWidthRamp(int[] nums) {
        int n = nums.length; // Length of the input array
        int ans = 0; // Variable to store the maximum width of the ramp

        // Stack to store indices of the array, maintaining a monotonic decreasing order
        Stack<Integer> s = new Stack<>();

        // First pass: Build the stack by iterating from left to right
        // We store indices such that the array is decreasing in terms of nums values
        for (int i = 0; i < n; i++) {
            // Push the index if the stack is empty or the current element nums[i] is smaller than the top of the stack
            // This ensures the stack stores potential "ramp start" indices in decreasing order of values
            if (s.isEmpty() || nums[s.peek()] > nums[i]) {
                s.push(i);
            }
        }

        // Second pass: Iterate from the right to left to find the maximum width ramp
        for (int i = n - 1; i >= 0 && !s.isEmpty(); i--) {
            // While the current element nums[i] can form a valid ramp with the top of the stack (i.e., nums[i] >= nums[s.peek()])
            while (!s.isEmpty() && nums[i] >= nums[s.peek()]) {
                // Calculate the width of the ramp and update the maximum width
                ans = Math.max(ans, i - s.pop());
            }
        }

        // Return the maximum width found
        return ans;
    }
}
