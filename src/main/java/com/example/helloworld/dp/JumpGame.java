package com.example.helloworld.dp;

/**
 * leetcode 55. Jump Game
 *
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 */
public class JumpGame {

    /**
     * jump game solution DP, keep finding the last valid index
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int lastValid = n-1;

        for(int i=n-2; i>=0; --i){
            if( lastValid <= nums[i] + i ){
                lastValid = i;
            }
        }

        return lastValid==0;
    }

    // n^2 solution using simple iteration
    public boolean canJumpIterative(int[] nums) {
        int n = nums.length, index = n-1;
        boolean found = false;

        while(index > 0){
            found = false;
            for(int i = 0; i<index; i++){
                if(nums[i] >= index-i){
                    index = i;
                    found = true;
                    break;
                }
            }
            if(!found) return false;
        }

        return true;
    }
    // dp solution
    public boolean canJumpPoorDP(int[] nums) {
        int n = nums.length;

        boolean[] dp = new boolean[n];
        dp[n-1] = true;

        for(int i=n-2; i>=0; i--){
            for(int j=i+1; j<=i+nums[i]; j++){
                if(dp[j]){
                    dp[i] = true; break;
                }
            }
        }

        return dp[0];
    }
}
