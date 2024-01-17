package com.example.helloworld.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 1207. Unique Number of Occurrences
 *
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 * Example 2:
 *
 * Input: arr = [1,2]
 * Output: false
 * Example 3:
 *
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 *
 *
 * Solution :
 *
 * The code defines a class UniqueNumberofOccurrences with a method uniqueOccurrences that takes an array of integers as input and checks if the number of occurrences
 * of each value in the array is unique. The approach involves using an array to store occurrences and a set to keep track of unique occurrences.
 * The code iterates through the array to count occurrences and then checks if each count is unique using a set.
 * The final result is returned based on the uniqueness of occurrences.
 */
public class UniqueNumberofOccurrences {

    /**
     * Checks if the number of occurrences of each value in the array is unique.
     *
     * @param arr The input array of integers.
     * @return True if the occurrences are unique, false otherwise.
     */
    public boolean uniqueOccurrences(int[] arr) {
        // Using an array to store occurrences of each number (ranging from -1000 to 1000)
        // The index 0 corresponds to -1000, index 1000 corresponds to 0, and index 2000 corresponds to 1000.
        int[] hash = new int[2001];

        // Set to keep track of unique occurrences
        Set<Integer> set = new HashSet<>();

        // Count occurrences of each number in the array
        for (int n : arr) {
            hash[n + 1000]++;
        }

        // Check for unique occurrences
        for (int i = 0; i < 2000; i++) {
            if (hash[i] != 0) {
                // If the count is already in the set, occurrences are not unique
                if (!set.add(hash[i]))
                    return false;
            }
        }

        // All occurrences are unique
        return true;
    }
}