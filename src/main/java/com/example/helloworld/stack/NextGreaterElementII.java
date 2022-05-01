package com.example.helloworld.stack;

import java.util.Stack;

/**
 * leetcode 503. Next Greater Element II
 *
 *
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
 *
 * The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number.
 * The second 1's next greater number needs to search circularly, which is also 2.
 * Example 2:
 *
 * Input: nums = [1,2,3,4,3]
 * Output: [2,3,4,-1,4]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 *
 */
public class NextGreaterElementII {

    /**
     * iterative approach, brute force,
     */
    public int[] nextGreaterElementsPoor(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // for every array element, checking next n-1 elements circularly
        for(int i=0; i<n; ++i){
            int ng = Integer.MIN_VALUE;

            int idx = i;
            for(int j=0; j<n-1; j++){
                idx = (idx + 1) % n;
                if(nums[idx] > nums[i]){
                    ng = nums[idx];
                    break;
                }
            }

            if(ng == Integer.MIN_VALUE)
                res[i] = -1;
            else
                res[i] = ng;
        }

        return res;
    }

    /**
     * using stack.
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        Stack<Integer> s = new Stack<>();       // to store the indices of elements

        // iterate from 2n-1, as we can move circularly.
        for (int idx = 2 * n - 1; idx >= 0; --idx) {
            int i = idx % n;

            // remove all the previous elements indices which are smaller and equal than current, they're not going to add any value further.
            while (!s.isEmpty() && nums[s.peek()] <= nums[i])
                s.pop();

            res[i] = s.isEmpty() ? -1 : nums[s.peek()];
            s.push(i);
        }

        return res;
    }
}


