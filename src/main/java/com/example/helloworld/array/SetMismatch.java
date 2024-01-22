package com.example.helloworld.array;

/**
 * leetcode 645. Set Mismatch
 *
 * code harmony solution video : https://youtu.be/mAK3WOO2JBw
 *
 * You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 *
 * You are given an integer array nums representing the data status of this set after the error.
 *
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Example 2:
 *
 * Input: nums = [1,1]
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 */
public class SetMismatch {

    /**
     * Approach:
     * This solution uses constant space.
     * It iterates through the array and marks the visited elements by making them negative.
     * The duplicate is the element that is already negative, and the missing is the one that remains positive.
     *
     * @param nums The input array representing the data status of the set after the error.
     * @return An array containing the duplicate and missing numbers.
     */
    public int[] findErrorNumsConstantSpace(int[] nums) {
        int dup = -1, missing = -1;

        for (int n : nums) {
            if (nums[Math.abs(n) - 1] < 0) {
                dup = Math.abs(n);
            } else {
                nums[Math.abs(n) - 1] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        return new int[]{dup, missing};
    }

    /**
     * Approach:
     * This solution uses extra space to keep track of the count of each number using a hash array.
     * It then identifies the duplicate and missing numbers based on the counts in the hash array.
     *
     * @param nums The input array representing the data status of the set after the error.
     * @return An array containing the duplicate and missing numbers.
     */
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] hash = new int[n + 1];
        int[] ans = new int[2];

        for (int i = 0; i < n; i++) {
            hash[nums[i]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (hash[i] == 2) {
                ans[0] = i; // Duplicate number
            } else if (hash[i] == 0) {
                ans[1] = i; // Missing number
            }
        }

        return ans;
    }
}