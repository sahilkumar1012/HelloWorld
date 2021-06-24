package com.example.helloworld.array;

import java.util.Arrays;

/**
 * leetcode 164. Maximum Gap
 *  Reference https://www.youtube.com/watch?v=VT-6zwGKYwA
 * Given an integer array nums, return the maximum difference between two successive elements in its sorted form. If the array contains less than two elements, return 0.
 *
 * You must write an algorithm that runs in linear time and uses linear extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,6,9,1]
 * Output: 3
 * Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.
 * Example 2:
 *
 * Input: nums = [10]
 * Output: 0
 * Explanation: The array contains less than 2 elements, therefore return 0.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 109
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {

        if (nums.length < 2) return 0;
        int min = nums[0], max = 0;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int interval = (int) Math.ceil((max - min + 0.0) / (nums.length - 1));

        int[] bucketMin = new int[nums.length - 1];
        int[] bucketMax = new int[nums.length - 1];

        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == min || nums[i] == max) continue;  // min max are considered as separate buckets ( left end and right end).

            int index = (nums[i] - min) / interval;
            bucketMin[index] = Math.min(bucketMin[index], nums[i]);
            bucketMax[index] = Math.max(bucketMax[index], nums[i]);
        }

        int prev = min;
        int maxGap = 0;
        for (int i = 0; i < bucketMin.length; i++) {
            if (bucketMax[i] == -1) continue;
            maxGap = Math.max(bucketMin[i] - prev, maxGap);
            prev = bucketMax[i];
        }
        maxGap = Math.max(max - prev, maxGap);

        return maxGap;
    }
}
