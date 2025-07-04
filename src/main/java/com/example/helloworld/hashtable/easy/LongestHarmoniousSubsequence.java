package com.example.helloworld.hashtable.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 594. Longest Harmonious Subsequence , Google
 *
 * We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.
 *
 * Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,2,2,5,2,3,7]
 *
 * Output: 5
 *
 * Explanation:
 *
 * The longest harmonious subsequence is [3,2,2,2,3].
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 *
 * Output: 2
 *
 * Explanation:
 *
 * The longest harmonious subsequences are [1,2], [2,3], and [3,4], all of which have a length of 2.
 *
 * Example 3:
 *
 * Input: nums = [1,1,1,1]
 *
 * Output: 0
 *
 * Explanation:
 *
 * No harmonic subsequence exists.
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -109 <= nums[i] <= 109
 *
 */
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(int num : nums){        // 3  - f(3) is 2
            int f1 = map.getOrDefault(num-1,0);     // 2 - f(2) is 3
            int f2 = map.getOrDefault(num+1,0);     // 4 - f(4) is 0

            if(f1 == 0 && f2 == 0) continue;

            int f = Math.max(f1,f2);
            int cand = map.get(num) + f;

            ans = Math.max(cand, ans);
        }

        return ans;
    }
}