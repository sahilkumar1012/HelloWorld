package com.example.helloworld.hashtable;

import java.util.TreeSet;

/**
 * leetcode 220. Contains Duplicate III
 *
 * Given an integer array nums and two integers k and t, return true if there are two distinct indices i and j in the array such that abs(nums[i] - nums[j]) <= t and abs(i - j) <= k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 104
 * 0 <= t <= 231 - 1
 */
public class ContainsDuplicateIII {

    /**
     * using TreeSet. checking floor and ceiling key against 't' contraint.
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (set.floor((long)nums[i]) != null && set.floor((long)nums[i]) >= (long)nums[i] - t)
                return true;
            if (set.ceiling((long)nums[i]) != null && set.ceiling((long)nums[i]) <= (long)nums[i] + t)
                return true;

            set.add((long)nums[i]);
            if (i >= k)
                set.remove((long)nums[i - k]);
        }
        return false;
    }
}

//             t       t
// floor(n) <----- n -----> ceiling(n)
// n - floor(n) <= t
// ceiling(n) - n <= t
