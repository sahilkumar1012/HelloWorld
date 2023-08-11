package com.example.helloworld.array.slidingwindow;

/**
 * leetcode 1493. Longest Subarray of 1's After Deleting One Element
 *
 * Given a binary array nums, you should delete one element from it.
 *
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,0,1]
 * Output: 3
 * Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
 * Example 2:
 *
 * Input: nums = [0,1,1,1,0,1,1,0,1]
 * Output: 5
 * Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
 * Example 3:
 *
 * Input: nums = [1,1,1]
 * Output: 2
 * Explanation: You must delete one element.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 */
public class LongestSubarray1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int start = 0, end = 0, k = 1, kk=0, max = 0;

        for(; end < nums.length; end++){
            if(nums[end] == 0){
                kk++;
            }
            while(kk > 1){
                if(nums[start] != 1){
                    kk--;
                }
                start++;
            }
            max = Math.max(max, end-start);
        }

        return max;
    }

    // write a main method to test the solution
    public static void main(String[] args) {
        LongestSubarray1sAfterDeletingOneElement solution = new LongestSubarray1sAfterDeletingOneElement();
        int[] nums = {1,1,0,1};
        System.out.println(solution.longestSubarray(nums));
        nums = new int[]{0,1,1,1,0,1,1,0,1};
        System.out.println(solution.longestSubarray(nums));
        nums = new int[]{1,1,1};
        System.out.println(solution.longestSubarray(nums));
    }
}
