package com.example.helloworld.dp.subset;

import java.util.*;

/**
 * leetcode 368. Largest Divisible Subset , Asked in Google
 *
 * code harmony video explanation : https://youtu.be/fw2GwsAt3yo
 *
 *
 * my leetcode solution : https://leetcode.com/problems/largest-divisible-subset/solutions/6620509/easy-to-understand-top-down-recursion-with-memorization-detailed-explanation-video
 *
 *
 * Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
 *
 * answer[i] % answer[j] == 0, or
 * answer[j] % answer[i] == 0
 * If there are multiple solutions, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [1,2]
 * Explanation: [1,3] is also accepted.
 * Example 2:
 *
 * Input: nums = [1,2,4,8]
 * Output: [1,2,4,8]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 109
 * All the integers in nums are unique.
 */
public class LargestDivisibleSubset {
    int[] nums; // Stores the input array
    int n; // Length of the array
    Map<String, List<Integer>> map; // Memoization map to store results for (idx, prev)

    public List<Integer> largestDivisibleSubset(int[] nums) {
        this.nums = nums;
        n = nums.length;
        map = new HashMap<>();

        Arrays.sort(nums); // Sort the array to ensure divisibility can be checked in increasing order
        return sol(0, 1); // Start recursion from index 0 and previous number as 1 (since every number is divisible by 1)
    }

    private List<Integer> sol(int idx, int prev){
        if(idx == n){
            return new ArrayList<>(); // Base case: return empty list when we reach the end
        }

        String key = idx + " " + prev;
        if(map.containsKey(key)){
            return map.get(key); // Return cached result if already computed
        }

        // take: include current number if divisible by prev
        List<Integer> tlist = new ArrayList<>();
        if(nums[idx] % prev == 0){
            tlist.add(nums[idx]);
            tlist.addAll(sol(idx + 1, nums[idx]));
        }

        // not take: skip current number
        List<Integer> ntlist = sol(idx + 1, prev);

        // choose the larger subset between taking and not taking
        if(tlist.size() > ntlist.size()){
            map.put(key, tlist);
            return tlist;
        }

        map.put(key, ntlist);
        return ntlist;
    }
}
