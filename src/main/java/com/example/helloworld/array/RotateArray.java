package com.example.helloworld.array;

/**
 *
 * leetcode 189. Rotate Array
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *
 *
 * Follow up:
 *
 * Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 *
 *
 */
public class RotateArray {

    /**
     * rotate an array without using any extra space.
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;

        rotate(nums, 0, n-k-1);
        rotate(nums, n-k, n-1);

        rotate(nums, 0, n-1);
    }
    private void rotate(int[] arr, int start, int end){
        while(start<end){
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;

            ++start; --end;
        }
    }

    /**
     * rotating array using o(n) extra space and in two iterations.
     * @param nums
     * @param k
     */
    public void rotatePoorApproach(int[] nums, int k) {
        int n = nums.length;
        k = k%n;

        // 0 to n-k-1 , n-k to n-1     // n=5, k=2, 5-2 to 5-1  and 0 to 5-2-1
        int[] res = new int[n];

        int idx = 0;
        for(int i=n-k; i<n; ++i){
            res[idx++] = nums[i];
        }
        for(int i=0; i<(n-k); ++i){
            res[idx++] = nums[i];
        }

        for(int i=0; i<n; ++i)
            nums[i] = res[i];
    }
}
