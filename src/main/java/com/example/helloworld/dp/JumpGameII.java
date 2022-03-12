package com.example.helloworld.dp;

import java.util.Arrays;

/**
 * leetcode 45. Jump Game II
 * reference video : https://youtu.be/phgjL7SbsWs
 *
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * You can assume that you can always reach the last index.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 */
public class JumpGameII {

    private int minJump;
    private final Integer MAX = 2000;

    public int jump(int[] nums) {
        return jumpDP(nums);
        // return jumpMemo(nums);
        // return jumpNew(nums);
    }

    // sahil's simple dp solution ( bit slower ), reference video : https://youtu.be/phgjL7SbsWs
    public int jumpNew(int[] nums){
        int n = nums.length;
        Integer[] dp = new Integer[n];      // stored dp can be further used to show paths with min jumps.
        dp[n-1] = 0;

        for(int i=n-2; i>=0; i--){
            int steps = nums[i];
            int min = Integer.MAX_VALUE;

            for(int j=1; j<=steps && i+j < n; j++){
                if( dp[i+j] != null && min > dp[i+j] )
                    min = dp[i+j];
            }

            if(min != Integer.MAX_VALUE)
                dp[i] = min + 1;
        }

        return dp[0];   // we can always reach the last index
    }

    // DP solution
    public int jumpDP(int[] nums) {
        int lastValid = nums.length - 1;
        int jumps = 0;
        while (lastValid > 0) {
            for (int i = 0; i < lastValid; i++) {
                if (nums[i] + i >= lastValid) {
                    lastValid = i;
                    jumps++;
                    break;
                }
            }
        }
        return jumps;
    }

    /**
     * TODO giving wrong answer, need to check later
     * @param nums
     * @return
     */
    public int jumpMemo(int[] nums) {
        minJump = Integer.MAX_VALUE;

        int memo[] = new int[nums.length];
        Arrays.fill(memo, MAX);

        sol(nums,0,0,memo);

        return memo[0];
    }
    // recursion with memorization solution, chirag's solution.
    private int sol(int[] arr, int idx, int jump, int[] memo){
        if(idx >= arr.length)
            return MAX;

        if(idx == arr.length-1){
            if(jump < minJump)
                minJump = jump;
            memo[idx] = 0;
            return 0;
        }
        else{
            if(memo[idx] < MAX){
                return memo[idx];
            }
            int min = MAX;
            for(int i=1; i<=arr[idx]; ++i){
                int sol = sol(arr, idx+i, jump+1, memo);
                if(sol < min){
                    min = sol;
                }
            }
            memo[idx] = min+1;
            return min+1;
        }
    }

}


