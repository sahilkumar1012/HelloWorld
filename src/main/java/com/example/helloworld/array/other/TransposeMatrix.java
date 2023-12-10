package com.example.helloworld.array.other;

/**
 * leetcode 867. Transpose Matrix
 * https://leetcode.com/problems/transpose-matrix/
 *
 * Given a 2D integer array matrix, return the transpose of matrix.
 *
 * The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
 *
 *
 *
 *
 *
 * Example 1:
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 * Example 2:
 *
 * Input: matrix = [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 1 <= m * n <= 105
 * -109 <= matrix[i][j] <= 109
 *
 */
public class TransposeMatrix {
    /**
     * if m==n then we could have done in-place. so here we'll be converting each row to new matrix's column.
     * T O(m*n) , S O(m*n)
     * @param matrix
     * @return
     */
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] res = new int[n][m];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                res[j][i] = matrix[i][j];
            }
        }

        return res;
    }
}
