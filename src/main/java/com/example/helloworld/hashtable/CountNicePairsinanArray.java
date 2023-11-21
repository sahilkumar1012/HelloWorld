package com.example.helloworld.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 1814. Count Nice Pairs in an Array
 * https://leetcode.com/problems/count-nice-pairs-in-an-array/
 *
 * You are given an array nums that consists of non-negative integers. Let us define rev(x) as the reverse of the non-negative integer x. For example, rev(123) = 321, and rev(120) = 21. A pair of indices (i, j) is nice if it satisfies all of the following conditions:
 *
 * 0 <= i < j < nums.length
 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * Return the number of nice pairs of indices. Since that number can be too large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [42,11,1,97]
 * Output: 2
 * Explanation: The two pairs are:
 *  - (0,3) : 42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121.
 *  - (1,2) : 11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12.
 * Example 2:
 *
 * Input: nums = [13,10,35,24,76]
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 */
public class CountNicePairsinanArray {
    public int countNicePairs(int[] nums) {
        int n = nums.length;
        int M = 1000000007;

        for(int i=0; i<n; i++)
            nums[i] -= rev(nums[i]);

        int ans = 0;
        Map<Integer, Integer> map =new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                ans += map.get(num);
                ans %= M;
            }
            map.put(num, map.getOrDefault(num,0)+1);
        }
        return ans;
    }

    private int rev(int n){
        int rev = 0;
        while(n > 0){
            rev = rev*10 + n%10;
            n/=10;
        }
        return rev;
    }
}
