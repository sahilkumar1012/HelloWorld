package com.example.helloworld.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 47. Permutations II
 * asked in Adobe
 *
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique
 * permutations in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
public class PermutationsII {


    List<List<Integer>> ans;
    int n;

    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] hash = new int[22];       // for frequency
        n = nums.length;

        for(int num : nums)
            hash[ num + 10 ] ++;

        ans = new ArrayList<>();
        sol( hash, new ArrayList<>() );
        return ans;
    }

    private void sol(int[] hash, List<Integer> temp){
        if(temp.size() == n){
            ans.add(new ArrayList<>(temp));     // valid permutation
            return;
        }

        for(int i=0; i<=20; i++){
            if( hash[i] == 0) continue;

            temp.add( i - 10 );
            hash[i] --;

            sol( hash, temp);

            hash[i] ++;
            temp.remove(temp.size()-1);
        }
    }
}