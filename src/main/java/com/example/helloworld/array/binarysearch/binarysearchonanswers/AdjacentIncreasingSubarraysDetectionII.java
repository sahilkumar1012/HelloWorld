package com.example.helloworld.array.binarysearch.binarysearchonanswers;

import java.util.List;

/**
 * leetcode 3350. Adjacent Increasing Subarrays Detection II
 *
 * prerequisite : 3349
 *
 * Given an array nums of n integers, your task is to find the maximum value of k for which there exist two adjacent subarrays of length k each, such that both subarrays are strictly increasing. Specifically, check if there are two subarrays of length k starting at indices a and b (a < b), where:
 *
 * Both subarrays nums[a..a + k - 1] and nums[b..b + k - 1] are strictly increasing.
 * The subarrays must be adjacent, meaning b = a + k.
 * Return the maximum possible value of k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,5,7,8,9,2,3,4,3,1]
 *
 * Output: 3
 *
 * Explanation:
 *
 * The subarray starting at index 2 is [7, 8, 9], which is strictly increasing.
 * The subarray starting at index 5 is [2, 3, 4], which is also strictly increasing.
 * These two subarrays are adjacent, and 3 is the maximum possible value of k for which two such adjacent strictly increasing subarrays exist.
 * Example 2:
 *
 * Input: nums = [1,2,3,4,4,4,4,5,6,7]
 *
 * Output: 2
 *
 * Explanation:
 *
 * The subarray starting at index 0 is [1, 2], which is strictly increasing.
 * The subarray starting at index 2 is [3, 4], which is also strictly increasing.
 * These two subarrays are adjacent, and 2 is the maximum possible value of k for which two such adjacent strictly increasing subarrays exist.
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 2 * 105
 * -109 <= nums[i] <= 109
 */
public class AdjacentIncreasingSubarraysDetectionII {

    /**
     * O(N * LogN) time & O(1) space
     * @param nums
     * @return
     */
    public int maxIncreasingSubarraysBinarySearchonAnswers(List<Integer> nums) {
        int n = nums.size();

        // Binary search on k: the length of subarrays
        // Goal: find the maximum k such that there exist two adjacent strictly increasing subarrays of length k
        int l = 1, r = n / 2, ans = 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            // Check if it's possible to have two adjacent increasing subarrays of length 'mid'
            if (isValidK(nums, mid)) {
                ans = mid;      // possible, try to find a larger k
                l = mid + 1;
            } else {
                r = mid - 1;    // not possible, try smaller k
            }
        }

        return ans;
    }


    // this is leetcode - 3349
    private boolean isValidK(List<Integer> nums, int k) {
        int n = nums.size();
        int s = 1;   // current increasing streak ending at index i
        int ps = 1;  // increasing streak ending at index (i - k)

        for (int i = 1; i < n; i++) {
            // update current streak length
            if (nums.get(i) > nums.get(i - 1)) {
                s++;
            } else {
                s = 1;
            }

            // update the streak of the subarray k positions behind
            if (i > k) {
                if (nums.get(i - k) > nums.get(i - k - 1)) {
                    ps++;
                } else {
                    ps = 1;
                }
            }

            // if both current and previous adjacent subarrays have at least 'k' length increasing streaks
            if (ps >= k && s >= k)
                return true;
        }

        return false;  // no valid pair found for this k
    }


    // optimized - single pass - O(N) time O(1) space
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int s = 1;   // current increasing streak length
        int ps = 0;  // previous increasing streak length (before a break)
        int n = nums.size();
        int ans = 0; // stores the maximum valid 'k'

        for (int i = 1; i < n; i++) {
            // Extend current streak if strictly increasing, otherwise reset
            if (nums.get(i) > nums.get(i - 1)) {
                s++;
            } else {
                // Current increasing run ended — move s to ps, reset s
                ps = s;
                s = 1;
            }

            // Case 1: Two adjacent increasing runs exist → take min(s, ps)
            ans = Math.max(ans, Math.min(s, ps));

            // Case 2: Single long increasing run can contain two adjacent subarrays internally
            // e.g., [1,2,3,4] → two subarrays of length 2 → s/2
            ans = Math.max(ans, s / 2);
        }

        return ans;
    }


}



