package com.example.helloworld.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 15. 3Sum
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 * Example 3:
 *
 * Input: nums = [0]
 * Output: []
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * Note : handling duplicacy is a tricky part.
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        if(nums.length < 3)
            return ans;

        Arrays.sort(nums);
        int n = nums.length;

        List<Integer> temp;

        for(int i=0; i<=n-3; ++i){
            if(i>0 && nums[i-1]==nums[i])
                continue;

            int j=i+1, k=n-1;
            int target = -1 * nums[i];

            int tsum=0;
            while(j<k){
                tsum = nums[j] + nums[k];

                if( tsum > target ){
                    k--;
                }else if( tsum < target ){
                    j++;
                }else{
                    temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    j++; k--;

                    while(j<k && nums[j]==nums[j-1]) j++;

                    while(k>j && nums[k]==nums[k+1]) k--;
                }
            }
        }

        return ans;
    }
}
