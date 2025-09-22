package com.example.helloworld.hashtable.easy;

/**
 * leetcode 3005. Count Elements With Maximum Frequency , Amazon
 *
 * Concepts : custom hash table, single pass solution
 *
 * code harmony explanation video : https://youtu.be/xU0yUer6waY
 *
 * You are given an array nums consisting of positive integers.
 *
 * Return the total frequencies of elements in nums such that those elements all have the maximum frequency.
 *
 * The frequency of an element is the number of occurrences of that element in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,3,1,4]
 * Output: 4
 * Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum frequency in the array.
 * So the number of elements in the array with maximum frequency is 4.
 * Example 2:
 *
 * Input: nums = [1,2,3,4,5]
 * Output: 5
 * Explanation: All elements of the array have a frequency of 1 which is the maximum.
 * So the number of elements in the array with maximum frequency is 5.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 *
 */
public class CountElementsWithMaximumFrequency {
    public int maxFrequencyElements(int[] nums) {
        // Hash array to store frequency of numbers.
        // Constraint: nums[i] is in range [1, 100], so size = 101 is enough.
        int[] hash = new int[101];

        // max = highest frequency seen so far
        // count = total number of elements that have the maximum frequency
        int max = 0, count = 0;

        // Traverse each number in the array
        for (int num : nums) {
            // Increase frequency of current number
            hash[num]++;
            int f = hash[num]; // current frequency of this number

            // If this frequency is greater than current max
            if (f > max) {
                max = f;         // update max frequency
                count = max;     // reset count to max (only this number so far)
            }
            // If frequency equals the current maximum frequency
            else if (f == max) {
                count += max;    // add 'max' because this element also has max frequency
            }
        }
        // Return total count of elements with maximum frequency
        return count;
    }
}

