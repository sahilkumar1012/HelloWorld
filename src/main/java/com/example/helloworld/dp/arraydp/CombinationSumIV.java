package com.example.helloworld.dp.arraydp;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 377. Combination Sum IV
 *
 * https://leetcode.com/problems/combination-sum-iv/description/
 *
 * Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
 *
 * The test cases are generated so that the answer can fit in a 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3], target = 4
 * Output: 7
 * Explanation:
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * Note that different sequences are counted as different combinations.
 * Example 2:
 *
 * Input: nums = [9], target = 3
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * All the elements of nums are unique.
 * 1 <= target <= 1000
 *
 *
 * Follow up: What if negative numbers are allowed in the given array? How does it change the problem? What limitation we need to add to the question to allow negative numbers?
 */
public class CombinationSumIV {
    // tabulation DP
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];

        dp[0] = 1;
        for(int i=0; i<=target; i++){
            for(int num: nums){
                dp[i] += (i >= num) ? dp[i - num] : 0;
            }
        }

        return dp[target];
    }
}

/**
 * Memoization DP
 */
class CombinationSumIVRecursionwithMemo {
    Map<Integer, Integer> map;

    public int combinationSum4(int[] nums, int target) {
        map = new HashMap();
        return sol(nums, target);
    }

    private int sol(int[] nums, int tar){
        if(tar == 0){
            return 1;
        }
        if(tar < 0){
            return 0;
        }

        if(map.containsKey(tar))
            return map.get(tar);

        int ans = 0;
        for(int i=0; i<nums.length; i++){
            ans += sol(nums, tar-nums[i]);
        }

        map.put(tar, ans);
        return ans;
    }
}
