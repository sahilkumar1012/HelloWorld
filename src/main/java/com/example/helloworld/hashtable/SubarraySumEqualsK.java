package com.example.helloworld.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 560. Subarray Sum Equals K
 *
 * code harmony reference video : https://youtu.be/OQ4oyd3CV5I
 *
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length, count = 0, psum = 0;

        for(int i=0; i<n ; ++i){
            psum += nums[i];
            if(psum == k){
                count += 1;
            }
            if(map.containsKey(psum - k)){
                count += map.get(psum - k);
            }
            map.put(psum, map.getOrDefault(psum,0)+1);
        }

        return count;
    }

    public int subarraySumTricky(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length, count = 0, psum = 0;

        map.put(0,1);       // if at any index prefixsum is = k then we have one subarray for sure, 0 se i tak
        for(int i=0; i<n ; ++i){
            psum += nums[i];
            if(map.containsKey(psum - k)){
                count += map.get(psum - k);
            }
            map.put(psum, map.getOrDefault(psum,0)+1);
        }

        return count;
    }
}
