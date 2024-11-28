package com.example.helloworld.twopointer.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 1. Two Sum , Most frequently asked coding interview question
 *
 * Code Harmony Video Explanation: https://youtu.be/l8DxsxO9q7g
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 *
 *
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
public class TwoSum {
    /**
     * Solves the Two Sum problem using a HashMap to achieve O(n) time complexity.
     *
     * @param nums The input array of integers.
     * @param target The target sum we want to find.
     * @return An array of two integers representing the indices of the numbers that add up to `target`.
     */
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the elements and their indices
        Map<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement of the current number to reach the target
            int complement = target - nums[i];

            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                // If found, return the indices of the complement and the current number
                return new int[] { map.get(complement), i };
            }

            // Otherwise, store the current number and its index in the map
            map.put(nums[i], i);
        }

        // Return null if no solution is found (though the problem guarantees a solution exists)
        return null;
    }
}
