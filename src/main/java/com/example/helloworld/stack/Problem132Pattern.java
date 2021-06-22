package com.example.helloworld.stack;

import java.util.Stack;

/**
 * leetcode 456. 132 Pattern
 *
 * Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
 *
 * Return true if there is a 132 pattern in nums, otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 * Explanation: There is no 132 pattern in the sequence.
 * Example 2:
 *
 * Input: nums = [3,1,4,2]
 * Output: true
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 * Example 3:
 *
 * Input: nums = [-1,3,2,0]
 * Output: true
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 2 * 105
 * -109 <= nums[i] <= 109
 */
public class Problem132Pattern {

    // n^3 time
    public boolean find132patternBrute(int[] nums) {
        int n = nums.length;

        for(int i=0; i<n; ++i){
            for(int j=i+1; j<n; ++j){
                if(nums[j] > nums[i]){

                    for(int k=j+1; k<n; ++k){
                        if(nums[k] > nums[i] && nums[k] < nums[j])
                            return true;
                    }
                }
            }
        }

        return false;
    }

    // n^2 time
    public boolean find132patternOld(int[] nums) {
        int n = nums.length;
        int lmin = nums[0];

        for(int j=1; j<n; ++j){

            if(nums[j] > lmin)
                for(int k=j+1; k<n; ++k){

                    if(nums[j] > nums[k] && nums[k] > lmin){
                        return true;
                    }
                }

            lmin = Math.min(lmin, nums[j]);
        }
        return false;
    }

    // using stack in linear time, best case and accepted solution.
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] lmin = new int[n];
        lmin[0] = nums[0];
        for(int i=1; i<n; ++i)
            lmin[i] = Math.min(lmin[i-1], nums[i]);

        Stack<Integer> s = new Stack<>();

        for(int j=n-1; j>=0; j--){
            if(nums[j] > lmin[j]){
                while(!s.isEmpty() && s.peek() <= lmin[j])      // kaam ke nahi hai
                    s.pop();
                if(!s.isEmpty() && s.peek() < nums[j])      // valid case.
                    return true;
                s.push(nums[j]);
            }
        }
        return false;
    }
}