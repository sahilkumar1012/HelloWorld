package com.example.helloworld.hashtable.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 1346. Check If N and Its Double Exist , Easy , Asked in Google, Amazon, Adobe
 *
 * Code Harmony Video Explanation : https://youtu.be/sFbEN-zrFiE
 *
 * Given an array arr of integers, check if there exist two indices i and j such that :
 *
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 *
 *
 * Example 1:
 *
 * Input: arr = [10,2,5,3]
 * Output: true
 * Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
 * Example 2:
 *
 * Input: arr = [3,1,7,11]
 * Output: false
 * Explanation: There is no i and j that satisfy the conditions.
 *
 *
 * Constraints:
 *
 * 2 <= arr.length <= 500
 * -103 <= arr[i] <= 103
 *
 */
public class CheckIfNandItsDoubleExist {
    public boolean checkIfExist(int[] arr) {
        // A HashSet to store elements as we iterate through the array.
        Set<Integer> set = new HashSet<>();

        // Traverse the array.
        for (int i : arr) {
            // Check if the current number's double exists in the set
            // or if the current number is even and its half exists in the set.
            if (set.contains(2 * i) || (i % 2 == 0 && set.contains(i / 2))) {
                return true; // Condition satisfied.
            }
            // Add the current number to the set.
            set.add(i);
        }

        return false;   // no valid ans
    }
}
