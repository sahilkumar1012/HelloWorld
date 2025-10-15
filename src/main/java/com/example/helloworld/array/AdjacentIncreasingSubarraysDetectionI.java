package com.example.helloworld.array;

import java.util.List;

/**
 * leetcode 3349. Adjacent Increasing Subarrays Detection I ,
 *
 * prerequisite of leetcode 3350
 *
 * - optimized by capturing streak
 *
 *  Given an array nums of n integers and an integer k, determine whether there exist two adjacent subarrays of length k such that both subarrays are strictly increasing. Specifically, check if there are two subarrays starting at indices a and b (a < b), where:
 *
 * Both subarrays nums[a..a + k - 1] and nums[b..b + k - 1] are strictly increasing.
 * The subarrays must be adjacent, meaning b = a + k.
 * Return true if it is possible to find two such subarrays, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,5,7,8,9,2,3,4,3,1], k = 3
 *
 * Output: true
 *
 * Explanation:
 *
 * The subarray starting at index 2 is [7, 8, 9], which is strictly increasing.
 * The subarray starting at index 5 is [2, 3, 4], which is also strictly increasing.
 * These two subarrays are adjacent, so the result is true.
 * Example 2:
 *
 * Input: nums = [1,2,3,4,4,4,4,5,6,7], k = 5
 *
 * Output: false
 *
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 100
 * 1 < 2 * k <= nums.length
 * -1000 <= nums[i] <= 1000
 */
public class AdjacentIncreasingSubarraysDetectionI {

    // O(N) time & O(N) space
    public boolean hasIncreasingSubarraysWithSpace(List<Integer> nums, int k) {
        int n = nums.size();
        int[] streak = new int[n];   // streak[i] = length of increasing sequence ending at i
        streak[0] = 1;

        for (int i = 1; i < n; i++) {
            // update current increasing streak
            if (nums.get(i) > nums.get(i - 1)) {
                streak[i] = streak[i - 1] + 1;
            } else {
                streak[i] = 1;
            }

            // check if current and previous adjacent subarrays (length k) are both increasing
            if (streak[i] >= k) {
                if (i - k >= 0 && streak[i - k] >= k)
                    return true;
            }
        }

        return false;
    }

    // O(N) time & O(1) space
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int s = 1;   // current increasing streak
        int ps = 1;  // increasing streak from k positions behind

        for (int i = 1; i < n; i++) {
            // update current streak
            if (nums.get(i) > nums.get(i - 1)) {
                s++;
            } else {
                s = 1;
            }

            // update previous k-distance streak once we have enough elements
            if (i > k) {
                if (nums.get(i - k) > nums.get(i - k - 1)) {
                    ps++;
                } else {
                    ps = 1;
                }
            }

            // both subarrays (current and previous adjacent) are strictly increasing
            if (ps >= k && s >= k)
                return true;
        }

        return false;
    }


    // or do it by capturing the current streak and previous streak values.

}
