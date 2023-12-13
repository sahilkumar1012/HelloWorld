package com.example.helloworld.array.easy;

/**
 * leetcode 1582. Special Positions in a Binary Matrix
 * https://leetcode.com/problems/special-positions-in-a-binary-matrix/
 *
 * Given an m x n binary matrix mat, return the number of special positions in mat.
 *
 * A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: mat = [[1,0,0],[0,0,1],[1,0,0]]
 * Output: 1
 * Explanation: (1, 2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.
 * Example 2:
 *
 *
 * Input: mat = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 * Explanation: (0, 0), (1, 1) and (2, 2) are special positions.
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * mat[i][j] is either 0 or 1.
 */
public class SpecialPositionsinaBinaryMatrix {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        // count number of 1s in each row and col.
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1){
                    rowCount[i] ++;
                    colCount[j] ++;
                }
            }
        }

        int ans = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                // only i,j is 1 rest in this row & col are 0
                if(mat[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1){
                    ans++;
                }
            }
        }

        return ans;
    }
}
