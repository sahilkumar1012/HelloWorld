package com.example.helloworld.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 40. Combination Sum II
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // container to hold the final combinations
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();

        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int candidate : candidates) {
            if (counter.containsKey(candidate))
                counter.put(candidate, counter.get(candidate) + 1);
            else
                counter.put(candidate, 1);
        }

        // convert the counter table to a list of (num, count) tuples
        List<int[]> counterList = new ArrayList<>();
        counter.forEach((key, value) -> {
            counterList.add(new int[]{key, value});
        });

        backtrack(comb, target, 0, counterList, results);
        return results;
    }

    private void backtrack(LinkedList<Integer> comb,
                           int remain, int curr,
                           List<int[]> counter,
                           List<List<Integer>> results) {

        if (remain <= 0) {
            if (remain == 0) {
                // make a deep copy of the current combination.
                results.add(new ArrayList<Integer>(comb));
            }
            return;
        }

        for (int nextCurr = curr; nextCurr < counter.size(); ++nextCurr) {
            int[] entry = counter.get(nextCurr);
            Integer candidate = entry[0], freq = entry[1];

            if (freq <= 0)
                continue;

            // add a new element to the current combination
            comb.addLast(candidate);
            counter.set(nextCurr, new int[]{candidate, freq - 1});

            // continue the exploration with the updated combination
            backtrack(comb, remain - candidate, nextCurr, counter, results);

            // backtrack the changes, so that we can try another candidate
            counter.set(nextCurr, new int[]{candidate, freq});
            comb.removeLast();
        }
    }
}
