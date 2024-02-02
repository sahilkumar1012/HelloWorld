package com.example.helloworld.enumeration;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 1291. Sequential Digits
 *
 * code harmony video solution :  https://youtu.be/UF41llxvjpk
 *
 *
 * An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
 *
 * Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 *
 *
 *
 * Example 1:
 *
 * Input: low = 100, high = 300
 * Output: [123,234]
 * Example 2:
 *
 * Input: low = 1000, high = 13000
 * Output: [1234,2345,3456,4567,5678,6789,12345]
 *
 *
 * Constraints:
 *
 * 10 <= low <= high <= 10^9
 */
public class SequentialDigits {
    /**
     * Finds all integers in the range [low, high] that have sequential digits.
     *
     * @param low  The lower bound of the range (inclusive).
     * @param high The upper bound of the range (inclusive).
     * @return A sorted list of integers with sequential digits in the specified range.
     */
    // Time Complexity: O(1) because the number of possible sequential digits is constant.
    public List<Integer> sequentialDigits(int low, int high) {
        // An array containing all possible sequential digits
        int[] allPossibleNumbers = {
                12, 23, 34, 45, 56, 67, 78, 89,
                123, 234, 345, 456, 567, 678, 789,
                1234, 2345, 3456, 4567, 5678, 6789,
                12345, 23456, 34567, 45678, 56789,
                123456, 234567, 345678, 456789,
                1234567, 2345678, 3456789,
                12345678, 23456789,
                123456789
        };

        List<Integer> ans = new ArrayList<>();
        int n = allPossibleNumbers.length;

        // Iterate through all possible sequential digits
        for (int i = 0; i < n; i++) {
            // Check if the current sequential digit is within the specified range [low, high]
            if (low <= allPossibleNumbers[i] && allPossibleNumbers[i] <= high)
                ans.add(allPossibleNumbers[i]);
        }

        // Return the sorted list of sequential digits in the specified range
        return ans;
    }
}
