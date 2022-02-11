package com.example.helloworld.hashtable;

import java.util.*;

/**
 * 532. K-diff Pairs in an Array
 *
 * Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
 *
 * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
 *
 * 0 <= i < j < nums.length
 * |nums[i] - nums[j]| == k
 * Notice that |val| denotes the absolute value of val.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,1,4,1,5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * Example 2:
 *
 * Input: nums = [1,2,3,4,5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * Example 3:
 *
 * Input: nums = [1,3,1,5,4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -107 <= nums[i] <= 107
 * 0 <= k <= 107
 */
public class KDiffPairsInAnArray {

     public int findPairsUsingSorting(int[] nums, int k) {
         Arrays.sort(nums);
         int n = nums.length;

         Set<Integer> set = new HashSet<>();
         for(int i=0; i<n-1; ++i){
             if(Arrays.binarySearch(nums, i+1, n, nums[i]+k) > 0){
                 set.add(nums[i]);
             }
         }

         return set.size();
     }

    // faster solution
    public int findPairsUsingHashing(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int n : nums){
            freq.put(n, freq.getOrDefault(n,0)+1);
        }
        int ans = 0;
        for(int n : freq.keySet()){
            if(k == 0){
                if(freq.get(n) > 1) ans ++;
            }else{
                if(freq.get(n + k) != null) ans ++;
            }
        }

        return ans;
    }

}
