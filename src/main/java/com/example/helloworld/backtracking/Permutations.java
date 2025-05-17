package com.example.helloworld.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 46. Permutations ,
 *
 *
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */
public class Permutations {

    List<List<Integer>> ans;
    int n;
    int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        n = nums.length;
        ans = new ArrayList<>();
        sol(0,new ArrayList<>());
        return ans;
    }

    private void sol(int idx, List<Integer> temp){
        if(idx == n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx; i<n; i++){ // now pick any >=idx
            temp.add(nums[i]);
            swap(idx, i);
            sol(idx+1, temp);
            swap(idx,i);
            temp.remove(temp.size()-1);
        }
    }

    private void swap(int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
