package com.example.helloworld.greedy.other;

/**
 * leetcode 1975. Maximum Matrix Sum , Adobe Interview Question
 *
 * Code Harmony Video Explanation : https://youtu.be/5e9URQObGhw
 *
 * You are given an n x n integer matrix. You can do the following operation any number of times:
 *
 * Choose any two adjacent elements of matrix and multiply each of them by -1.
 * Two elements are considered adjacent if and only if they share a border.
 *
 * Your goal is to maximize the summation of the matrix's elements. Return the maximum sum of the matrix's elements using the operation mentioned above.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,-1],[-1,1]]
 * Output: 4
 * Explanation: We can follow the following steps to reach sum equals 4:
 * - Multiply the 2 elements in the first row by -1.
 * - Multiply the 2 elements in the first column by -1.
 * Example 2:
 *
 *
 * Input: matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]
 * Output: 16
 * Explanation: We can follow the following step to reach sum equals 16:
 * - Multiply the 2 last elements in the second row by -1.
 *
 *
 * Constraints:
 *
 * n == matrix.length == matrix[i].length
 * 2 <= n <= 250
 * -105 <= matrix[i][j] <= 105
 */
public class MaximumMatrixSum {
    /**
     * Finds the maximum sum of the matrix after performing the allowed operations.
     *
     * @param matrix The input 2D matrix of integers.
     * @return The maximum possible sum of the matrix elements.
     */
    public long maxMatrixSum(int[][] matrix) {
        // Variable to store the minimum absolute value in the matrix
        int minabs = Integer.MAX_VALUE;

        // Counter for negative elements in the matrix
        int ncount = 0;

        // Variable to store the cumulative sum of absolute values of matrix elements
        long sum = 0;

        // Dimension of the matrix (n x n)
        int n = matrix.length;

        // Traverse each element in the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];

                // Add the absolute value of the current element to the sum
                sum += Math.abs(val);

                // Count the negative elements
                if (val < 0) {
                    ncount++;
                }

                // Update the smallest absolute value found so far
                minabs = Math.min(minabs, Math.abs(val));
            }
        }

        // If there is an odd count of negative elements:
        // After making all possible flips, one negative will remain,
        // so we reduce the sum by 2 times the smallest absolute value.
        if (ncount % 2 == 1) {
            sum -= 2 * minabs;
        }

        // Return the calculated maximum sum
        return sum;
    }


}
