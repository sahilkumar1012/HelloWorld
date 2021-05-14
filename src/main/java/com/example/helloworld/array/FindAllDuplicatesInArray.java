package com.example.helloworld.array;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 442. Find All Duplicates in an Array
 *
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.
 *
 * You must write an algorithm that runs in O(n) time and uses only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [2,3]
 * Example 2:
 *
 * Input: nums = [1,1,2]
 * Output: [1]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: []
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * Each element in nums appears once or twice.
 */
public class FindAllDuplicatesInArray {

    /**
     * we have to do this without using extra space here.
     * @param nums
     * @return
     */
    public List<Integer> findDuplicatesHashing(int[] nums) {
        int n = nums.length;
        int[] hash = new int[n+1];
        for(int i: nums)
            hash[i]++;

        List<Integer> ans = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(hash[i] == 2)
                ans.add(i);
        }
        return ans;
    }

    /**
     range will have number from 1 to n i.e. ( nums[i]-1 ) is a valid index everytime.
     */
    public List<Integer> findDuplicates(int[] nums) {
        int sign = -1;

        for(int i=0; i<nums.length; ++i){
            nums[Math.abs(nums[i]) - 1] *= sign;
        }

        List<Integer> ans = new ArrayList<>();

        for(int i=0 ;i<nums.length; ++i){
            if( nums[Math.abs(nums[i]) - 1] > 0){
                ans.add(Math.abs(nums[i]));
                nums[Math.abs(nums[i]) - 1] *= sign;
            }
        }

        return ans;
    }
}
