package com.example.helloworld.hashtable.others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 1072  Flip Columns For Maximum Number of Equal Rows
 *
 * Code Harmony Video Explanation : https://youtu.be/SHweY-n28A4
 *
 * You are given an m x n binary matrix matrix.
 *
 * You can choose any number of columns in the matrix and flip every cell in that column (i.e., Change the value of the cell from 0 to 1 or vice versa).
 *
 * Return the maximum number of rows that have all values equal after some number of flips.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix = [[0,1],[1,1]]
 * Output: 1
 * Explanation: After flipping no values, 1 row has all values equal.
 * Example 2:
 *
 * Input: matrix = [[0,1],[1,0]]
 * Output: 2
 * Explanation: After flipping values in the first column, both rows have equal values.
 * Example 3:
 *
 * Input: matrix = [[0,0,0],[0,0,1],[1,1,0]]
 * Output: 2
 * Explanation: After flipping values in the first two columns, the last two rows have equal values.
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] is either 0 or 1.
 */
public class FlipColumnsForMaximumNumberofEqualRows {

    /**
     * Method to find the maximum number of rows that have all values equal
     * after flipping any number of columns.
     *
     * @param matrix the binary matrix
     * @return the maximum number of rows with all equal values
     */
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        // Map to store the frequency of each row configuration
        Map<String, Integer> map = new HashMap<>();

        // Traverse through each row of the matrix
        for (int[] row : matrix) {
            // Convert the row to a string key representation
            String key = Arrays.toString(row);
            // Increment the frequency of this key in the map
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int ans = 0; // Variable to store the maximum number of equal rows

        // Traverse through each row again to calculate the maximum rows with all equal values
        for (int[] row : matrix) {
            // Original row representation as a key
            String key = Arrays.toString(row);
            // Flipped version of the row as a key
            String oppkey = Arrays.toString(flipped(row));
            // Calculate the total frequency of rows that are either the same or flipped
            ans = Math.max(ans,
                    map.getOrDefault(key, 0) +
                            map.getOrDefault(oppkey, 0));
        }

        return ans; // Return the maximum number of equal rows
    }

    /**
     * Helper method to flip the binary values in a row.
     * For example, [0,1,0] -> [1,0,1].
     *
     * @param row the input binary row
     * @return a new array with flipped binary values
     */
    private int[] flipped(int[] row) {
        int n = row.length; // Length of the row
        int[] ans = new int[n]; // Array to store the flipped values
        for (int i = 0; i < n; i++) {
            // Flip the value: 0 -> 1, 1 -> 0
            ans[i] = (row[i] == 1) ? 0 : 1;
        }
        return ans; // Return the flipped row
    }
}