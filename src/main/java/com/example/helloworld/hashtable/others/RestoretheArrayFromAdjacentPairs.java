package com.example.helloworld.hashtable.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 1743 Restore the Array From Adjacent Pairs
 *
 * There is an integer array nums that consists of n unique elements, but you have forgotten it. However, you do remember every pair of adjacent elements in nums.
 *
 * You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi] indicates that the elements ui and vi are adjacent in nums.
 *
 * It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs, either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]]. The pairs can appear in any order.
 *
 * Return the original array nums. If there are multiple solutions, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: adjacentPairs = [[2,1],[3,4],[3,2]]
 * Output: [1,2,3,4]
 * Explanation: This array has all its adjacent pairs in adjacentPairs.
 * Notice that adjacentPairs[i] may not be in left-to-right order.
 * Example 2:
 *
 * Input: adjacentPairs = [[4,-2],[1,4],[-3,1]]
 * Output: [-2,4,1,-3]
 * Explanation: There can be negative numbers.
 * Another solution is [-3,1,4,-2], which would also be accepted.
 * Example 3:
 *
 * Input: adjacentPairs = [[100000,-100000]]
 * Output: [100000,-100000]
 *
 *
 * Constraints:
 *
 * nums.length == n
 * adjacentPairs.length == n - 1
 * adjacentPairs[i].length == 2
 * 2 <= n <= 105
 * -105 <= nums[i], ui, vi <= 105
 * There exists some nums that has adjacentPairs as its pairs.
 */
public class RestoretheArrayFromAdjacentPairs {
    public int[] restoreArray(int[][] adjacentPairs) {
        // adj
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] pair : adjacentPairs){
            adj.putIfAbsent(pair[0], new ArrayList<>());
            adj.putIfAbsent(pair[1], new ArrayList<>());

            adj.get(pair[0]).add(pair[1]);
            adj.get(pair[1]).add(pair[0]);
        }

        // start pt
        int start = -1;
        for(int key : adj.keySet()){
            if(adj.get(key).size()==1){
                start = key;
                break;
            }
        }

        // dfs
        int[] res = new int[adjacentPairs.length+1];
        res[0] = start;
        res[1] = adj.get(start).get(0);

        int i=2;
        while(i < res.length){
            List<Integer> neighbors = adj.get(res[i-1]);

            for(int neighbor : neighbors){
                if(neighbor != res[i-2]){
                    res[i] = neighbor;
                }
            }

            i++;
        }

        return res;
    }
}
