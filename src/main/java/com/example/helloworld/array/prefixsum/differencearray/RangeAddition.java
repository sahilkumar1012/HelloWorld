package com.example.helloworld.array.prefixsum.differencearray;

/**
 * leetcode 370. Range Addition , Google Amazon Salesforce
 *
 * code harmony video explanation : https://youtu.be/M0AU0WyZKuQ ( Difference Array Concept, Range update query in O(1) )
 *
 *
 *
 * You are given an integer length and an array updates where updates[i] = [startIdxi, endIdxi, inci].
 *
 * You have an array arr of length length with all zeros, and you have some operation to apply on arr. In the ith operation, you should increment all the elements arr[startIdxi], arr[startIdxi + 1], ..., arr[endIdxi] by inci.
 *
 * Return arr after applying all the updates.
 *
 *
 *
 * Example 1:
 *
 * Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
 * Output: [-2,0,3,5,3]
 *
 * Example 2:
 *
 * Input: length = 10, updates = [[2,4,6],[5,6,8],[1,9,-4]]
 * Output: [0,-4,2,2,2,4,4,-4,-4,-4]
 *
 *
 *
 * Constraints:
 *
 *     1 <= length <= 105
 *     0 <= updates.length <= 104
 *     0 <= startIdxi <= endIdxi < length
 *     -1000 <= inci <= 1000
 *
 *
 */
public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        // Initialize an array of given length with all elements set to 0
        int[] arr = new int[length];

        // Apply range updates using a difference array approach
        for(int[] update : updates){
            int i = update[0]; // Start index of update range
            int j = update[1]; // End index of update range
            int inc = update[2]; // Increment value

            // Apply the increment at the start index
            arr[i] += inc;

            // Apply the decrement at j+1 to mark the end of the increment range
            if(j + 1 < length)
                arr[j + 1] -= inc;
        }

        // Compute the prefix sum to get the final modified array
        for(int i = 1; i < length; i++){
            arr[i] += arr[i - 1];
        }

        return arr;
    }

}
