package com.example.helloworld.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 2364. Count Number of Bad Pairs , google amazon
 *
 * code harmony explanation video : https://youtu.be/H-1SWRTYsmg
 *
 * my leetcode solution : https://leetcode.com/problems/count-number-of-bad-pairs/solutions/6396914/easy-to-understand-hash-table-detailed-video-explanation
 *
 * You are given a 0-indexed integer array nums. A pair of indices (i, j) is a bad pair if i < j and j - i != nums[j] - nums[i].
 *
 * Return the total number of bad pairs in nums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,1,3,3]
 * Output: 5
 * Explanation: The pair (0, 1) is a bad pair since 1 - 0 != 1 - 4.
 * The pair (0, 2) is a bad pair since 2 - 0 != 3 - 4, 2 != -1.
 * The pair (0, 3) is a bad pair since 3 - 0 != 3 - 4, 3 != -1.
 * The pair (1, 2) is a bad pair since 2 - 1 != 3 - 1, 1 != 2.
 * The pair (2, 3) is a bad pair since 3 - 2 != 3 - 3, 1 != 0.
 * There are a total of 5 bad pairs, so we return 5.
 * Example 2:
 *
 * Input: nums = [1,2,3,4,5]
 * Output: 0
 * Explanation: There are no bad pairs.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 *
 */
public class CountNumberofBadPairs {
    public long countBadPairs(int[] nums) {
        // Map to store the frequency of (i - nums[i]) values
        Map<Integer, Integer> map = new HashMap<>();

        // Variable to store the count of bad pairs
        long bp = 0;

        // Iterate through the array
        for(int i = 0; i < nums.length; i++) {
            // Compute the key as (i - nums[i])
            int key = i - nums[i];

            // Get the count of previously seen elements with the same key (good pairs)
            int gp = map.getOrDefault(key, 0);

            // The total number of pairs that can be formed with the current index
            int total = i;

            // Update the frequency map with the new count
            map.put(key, gp + 1);

            // Calculate the number of bad pairs by subtracting good pairs from total pairs
            bp += total - gp;
        }

        // Return the total number of bad pairs
        return bp;
    }

}
