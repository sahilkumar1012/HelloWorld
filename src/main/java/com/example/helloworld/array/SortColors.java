package com.example.helloworld.array;

/**
 * leetcode 75. Sort Colors
 * https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 * ( Dutch National Flag Problem )
 *
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * Example 3:
 *
 * Input: nums = [0]
 * Output: [0]
 * Example 4:
 *
 * Input: nums = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is 0, 1, or 2.
 *
 *
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */
public class SortColors {

    // older self approach.
    public void sortColorsK(int[] nums) {
        int start  = 0, end = nums.length-1;

        int i = 0;
        while(i<=end){
            while(start<=end && nums[start]==0)
                start++;
            while(end>=start && nums[end]==2)
                end--;
            if(i<start)
                i=start;

            if(start<=end && nums[i]==0){
                nums[i] = nums[start];
                nums[start] = 0;
                start++;
                i++;
            }else if(start<=end && nums[i]==2 ){
                nums[i] = nums[end];
                nums[end] = 2;
                end--;
            }else{
                i++;
            }
        }
    }

    public void sortColors(int[] nums) {
        int l=-1, m=0, r=nums.length-1;

        while(m<=r){
            if(nums[m]==0)
                swap(nums, ++l, m++);
            else if(nums[m]==2)
                swap(nums, m, r--);
            else
                m++;
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
