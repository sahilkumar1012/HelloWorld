package com.example.helloworld.array.prefixsum.differencearray;

/**
 * leetcode 3355. Zero Array Transformation I , Asked in Google
 *
 * code harmony video explanation : https://youtu.be/4XTz1V2rM6I
 *
 * my leetcode solution : https://leetcode.com/problems/zero-array-transformation-i/solutions/6532843/easy-to-understand-difference-array-goog-fgrl
 *
 *
 * You are given an integer array nums of length n and a 2D array queries, where queries[i] = [li, ri].
 *
 * For each queries[i]:
 *
 * Select a subset of indices within the range [li, ri] in nums.
 * Decrement the values at the selected indices by 1.
 * A Zero Array is an array where all elements are equal to 0.
 *
 * Return true if it is possible to transform nums into a Zero Array after processing all the queries sequentially, otherwise return false.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,0,1], queries = [[0,2]]
 *
 * Output: true
 *
 * Explanation:
 *
 * For i = 0:
 * Select the subset of indices as [0, 2] and decrement the values at these indices by 1.
 * The array will become [0, 0, 0], which is a Zero Array.
 * Example 2:
 *
 * Input: nums = [4,3,2,1], queries = [[1,3],[0,2]]
 *
 * Output: false
 *
 * Explanation:
 *
 * For i = 0:
 * Select the subset of indices as [1, 2, 3] and decrement the values at these indices by 1.
 * The array will become [4, 2, 1, 0].
 * For i = 1:
 * Select the subset of indices as [0, 1, 2] and decrement the values at these indices by 1.
 * The array will become [3, 1, 0, 0], which is not a Zero Array.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 * 1 <= queries.length <= 105
 * queries[i].length == 2
 * 0 <= li <= ri < nums.length
 */
public class ZeroArrayTransformationI {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] arr = new int[n]; // Auxiliary array for difference array technique

        // Apply range updates using the difference array approach
        for(int[] query : queries){
            int i = query[0]; // Start index of the range
            int j = query[1]; // End index of the range

            arr[i] += 1; // Increment at the start index
            if(j + 1 < n)
                arr[j + 1] -= 1; // Decrement at index (j + 1) to limit the effect of increment
        }

        // Apply prefix sum to get the actual values and check against nums
        if(arr[0] < nums[0]) return false; // First element must be at least nums[0]
        for(int i = 1; i < n; i++){
            arr[i] += arr[i - 1]; // Compute prefix sum to get the actual values
            if(arr[i] < nums[i]) // If any value is less than the required value in nums, return false
                return false;
        }
        return true; // If all conditions are met, return true
    }

}
