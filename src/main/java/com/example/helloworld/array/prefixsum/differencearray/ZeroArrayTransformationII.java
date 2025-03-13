package com.example.helloworld.array.prefixsum.differencearray;

/**
 * leetcode 3356. Zero Array Transformation II  , Google Interview Question
 *
 * code harmony video explanation : [ part I video : https://youtu.be/4XTz1V2rM6I ]
 *
 * my leetcode solution : https://leetcode.com/problems/zero-array-transformation-ii/solutions/6533810/easy-to-understand-difference-array-goog-xtv1
 *
 *
 *
 * You are given an integer array nums of length n and a 2D array queries where queries[i] = [li, ri, vali].
 *
 * Each queries[i] represents the following action on nums:
 *
 * Decrement the value at each index in the range [li, ri] in nums by at most vali.
 * The amount by which each value is decremented can be chosen independently for each index.
 * A Zero Array is an array with all its elements equal to 0.
 *
 * Return the minimum possible non-negative value of k, such that after processing the first k queries in sequence, nums becomes a Zero Array. If no such k exists, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,0,2], queries = [[0,2,1],[0,2,1],[1,1,3]]
 *
 * Output: 2
 *
 * Explanation:
 *
 * For i = 0 (l = 0, r = 2, val = 1):
 * Decrement values at indices [0, 1, 2] by [1, 0, 1] respectively.
 * The array will become [1, 0, 1].
 * For i = 1 (l = 0, r = 2, val = 1):
 * Decrement values at indices [0, 1, 2] by [1, 0, 1] respectively.
 * The array will become [0, 0, 0], which is a Zero Array. Therefore, the minimum value of k is 2.
 * Example 2:
 *
 * Input: nums = [4,3,2,1], queries = [[1,3,2],[0,2,1]]
 *
 * Output: -1
 *
 * Explanation:
 *
 * For i = 0 (l = 1, r = 3, val = 2):
 * Decrement values at indices [1, 2, 3] by [2, 2, 1] respectively.
 * The array will become [4, 1, 0, 0].
 * For i = 1 (l = 0, r = 2, val = 1):
 * Decrement values at indices [0, 1, 2] by [1, 1, 0] respectively.
 * The array will become [3, 0, 0, 0], which is not a Zero Array.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 5 * 105
 * 1 <= queries.length <= 105
 * queries[i].length == 3
 * 0 <= li <= ri < nums.length
 * 1 <= vali <= 5
 *
 */
public class ZeroArrayTransformationII {
    // binary search
    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 0, right = queries.length, ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canZeroArray(nums, queries, mid)) {
                ans = mid;  // Store the answer
                right = mid - 1;  // Try for a smaller k
            } else {
                left = mid + 1;  // Increase k
            }
        }
        return ans;
    }

    private boolean canZeroArray(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];  // Difference array (n+1 for out-of-bounds handling)

        // Apply the first k queries
        for (int i = 0; i < k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];

            diff[l] += val;
            if (r + 1 < n) diff[r + 1] -= val;
        }

        // Compute prefix sum and check if we can zero out nums
        int[] decrements = new int[n];
        decrements[0] = diff[0];
        if (decrements[0] < nums[0]) return false;

        for (int i = 1; i < n; i++) {
            decrements[i] = decrements[i - 1] + diff[i];
            if (decrements[i] < nums[i]) return false;
        }
        return true;  // Successfully zeroed out nums
    }

}
