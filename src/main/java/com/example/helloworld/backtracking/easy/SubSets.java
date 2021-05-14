package com.example.helloworld.backtracking.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 78. Subsets
 *
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 */
public class SubSets {

        // here we have only positive numbers
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());

            sol(nums, res, new ArrayList<>(), 0);
            return res;
        }

        private void sol(int[] nums, List<List<Integer>> res, List<Integer> temp, int idx){
            if(idx == nums.length)
                return;

            for(int i=idx; i<nums.length; ++i){
                temp.add(nums[i]);
                res.add( new ArrayList<>(temp) );
                sol(nums, res, temp, i+1);
                temp.remove(temp.size()-1);
            }
        }

        public List<List<Integer>> subsetsWithSumK(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());

            sol(nums, res, new ArrayList<>(), 0);
            return res;
        }
    }
