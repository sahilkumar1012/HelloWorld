package com.example.helloworld.backtracking.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * find all the subsets with sum K
 *
 * inputs:
 * negatives are allowed
 */
public class SubsetsWithSumK {

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(new Integer[]{5,10,12,15,18});
        int arr[] = new int[]{5,10,12,15,18};
        System.out.println(new SubsetsWithSumK().subsetsWithSumK(arr,30));
    }

    public List<List<Integer>> subsetsWithSumK(int[] nums, int k) {
        if(k==0)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
//        res.add(new ArrayList<>());

        sol(nums, res, new ArrayList<Integer>(), 0, k);
        return res;
    }

    private void sol(int[] nums, List<List<Integer>> res, ArrayList<Integer> temp, int idx, int k) {
        if(idx==nums.length)
            return;

        for(int i=idx; i<nums.length; ++i){
            temp.add(nums[i]);
            k -= nums[i];

            if(k==0)
                res.add(new ArrayList<>(temp));
            sol(nums, res, temp, i+1, k);

            k += nums[i];
            temp.remove(temp.size()-1);
        }
    }
}
