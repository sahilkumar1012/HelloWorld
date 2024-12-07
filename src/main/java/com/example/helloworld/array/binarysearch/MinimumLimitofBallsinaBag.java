package com.example.helloworld.array.binarysearch;

/**
 * leetcode 1760. Minimum Limit of Balls in a Bag, Binary Search on Answers, Flipkart , Amazon
 *
 * Code Harmony Video Explanation : https://youtu.be/mUWhmEwYCWI
 * My LeetCode Solution : https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/solutions/6121477/simple-explanation-binary-search-on-answer-space-detailed-video-explanation
 *
 * You are given an integer array nums where the ith bag contains nums[i] balls. You are also given an integer maxOperations.
 *
 * You can perform the following operation at most maxOperations times:
 *
 * Take any bag of balls and divide it into two new bags with a positive number of balls.
 * For example, a bag of 5 balls can become two new bags of 1 and 4 balls, or two new bags of 2 and 3 balls.
 * Your penalty is the maximum number of balls in a bag. You want to minimize your penalty after the operations.
 *
 * Return the minimum possible penalty after performing the operations.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [9], maxOperations = 2
 * Output: 3
 * Explanation:
 * - Divide the bag with 9 balls into two bags of sizes 6 and 3. [9] -> [6,3].
 * - Divide the bag with 6 balls into two bags of sizes 3 and 3. [6,3] -> [3,3,3].
 * The bag with the most number of balls has 3 balls, so your penalty is 3 and you should return 3.
 * Example 2:
 *
 * Input: nums = [2,4,8,2], maxOperations = 4
 * Output: 2
 * Explanation:
 * - Divide the bag with 8 balls into two bags of sizes 4 and 4. [2,4,8,2] -> [2,4,4,4,2].
 * - Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,4,4,4,2] -> [2,2,2,4,4,2].
 * - Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,4,4,2] -> [2,2,2,2,2,4,2].
 * - Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,2,2,4,2] -> [2,2,2,2,2,2,2,2].
 * The bag with the most number of balls has 2 balls, so your penalty is 2, and you should return 2.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= maxOperations, nums[i] <= 109
 *
 *
 */
public class MinimumLimitofBallsinaBag {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 0, right = 0;

        // Determine the initial range for binary search.
        // `right` is set to the maximum number in `nums` because
        // the largest number is the theoretical upper bound for the minimum size.
        for (int i : nums) {
            right = Math.max(right, i);
        }

        // Initialize `ans` with the maximum possible size of a bag.
        int ans = right;

        // Perform binary search to find the smallest possible maximum size of a bag.
        while (left <= right) {
            int mid = (left + right) / 2; // Midpoint of current range.

            // Check if it's possible to split the bags such that
            // no bag has more than `mid` balls with the given operations.
            if (valid(mid, nums, maxOperations)) {
                ans = mid;        // Update the answer with the current valid `mid`.
                right = mid - 1; // Try for a smaller maximum size.
            } else {
                left = mid + 1;  // Increase the minimum size limit to find a valid solution.
            }
        }
        return ans; // Return the smallest valid maximum size.
    }

    // Helper function to determine if a given `mid` is a valid maximum size for the bags.
    private boolean valid(int mid, int[] nums, int maxo) {
        int o = 0; // Count of operations needed to make all bags <= `mid`.

        for (int num : nums) {
            // Calculate the number of splits needed for the current bag
            // to make all parts <= `mid`. Subtract 1 because no operation is needed
            // if the size is already less than or equal to `mid`.
            o += (int) Math.ceil(num / (double) mid) - 1;

            // If operations exceed `maxo`, `mid` is not valid.
            if (o > maxo) return false;
        }
        return true; // All bags can be split within the allowed operations.
    }

}
