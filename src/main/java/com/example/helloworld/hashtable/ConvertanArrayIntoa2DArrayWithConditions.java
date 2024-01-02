package com.example.helloworld.hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 2610. Convert an Array Into a 2D Array With Conditions
 * Code Harmony video solution : https://youtu.be/x5aZYFVxKZ4
 *
 * You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:
 *
 * The 2D array should contain only the elements of the array nums.
 * Each row in the 2D array contains distinct integers.
 * The number of rows in the 2D array should be minimal.
 * Return the resulting array. If there are multiple answers, return any of them.
 *
 * Note that the 2D array can have a different number of elements on each row.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,4,1,2,3,1]
 * Output: [[1,3,4,2],[1,3],[1]]
 * Explanation: We can create a 2D array that contains the following rows:
 * - 1,3,4,2
 * - 1,3
 * - 1
 * All elements of nums were used, and each row of the 2D array contains distinct integers, so it is a valid answer.
 * It can be shown that we cannot have less than 3 rows in a valid array.
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: [[4,3,2,1]]
 * Explanation: All elements of the array are distinct, so we can keep all of them in the first row of the 2D array.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= nums.length
 */
public class ConvertanArrayIntoa2DArrayWithConditions {

    /**
     * Function to convert an integer array into a 2D array with distinct rows.
     *
     * @param nums The input integer array.
     * @return A 2D array satisfying the given conditions.
     */
    public List<List<Integer>> findMatrix(int[] nums) {
        // Create a frequency array to keep track of the occurrences of each number.
        int[] freq = new int[nums.length + 1];

        // Initialize an empty list to store the 2D array.
        List<List<Integer>> ans = new ArrayList<>();

        // Iterate through each number in the input array.
        for (int num : nums) {
            // If the frequency of the current number is greater than or equal to the size of 'ans',
            // it means we need to create a new row in the 2D array.
            if (freq[num] >= ans.size()) {
                ans.add(new ArrayList<>());  // Add a new empty row.
            }

            // Add the current number to the appropriate row based on its frequency.
            ans.get(freq[num]).add(num);

            // Increment the frequency of the current number.
            freq[num]++;
        }

        // Return the resulting 2D array.
        return ans;
    }
}
